package ch.dams333.betterUHC.objects.game;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.listener.item.ItemLimit;
import ch.dams333.betterUHC.objects.game.tasks.BombTask;
import ch.dams333.betterUHC.objects.game.tasks.Bordertask;
import ch.dams333.betterUHC.objects.game.tasks.GameTask;
import ch.dams333.betterUHC.objects.gameStep.GameStep;
import ch.dams333.damsLib.ScoreboardSign;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.*;

import java.util.*;

public class GameManager {
    BetterUHC main;
    public GameManager(BetterUHC betterUHC) {
        this.main = betterUHC;
        scoreboards = new HashMap<>();
        inGamePlayers = new ArrayList<>();
        gameTime = 0;
        itemLimits = new ArrayList<>();
        death = new HashMap<>();
        revive = new ArrayList<>();
        bestPVE = new ArrayList<>();
        noFall = new ArrayList<>();
    }

    private GameTask gameTask;

    private Map<Player, ScoreboardSign> scoreboards;

    private int startedPlayerNumber;
    public List<Player> inGamePlayers;
    public List<Player> bestPVE;
    private int border;

    public List<Player> revive;

    private int gameTime;

    public int getGameTime(){
        return gameTime;
    }

    public List<ItemLimit> itemLimits;

    public Map<Player, Location> death;

    public List<Player> noFall;

    public void startGame() {
        startedPlayerNumber = Bukkit.getOnlinePlayers().size();
        inGamePlayers.addAll(Bukkit.getOnlinePlayers());
        border = main.gameVariables.preBorder;
        Bukkit.getWorld("world").setGameRule(GameRule.NATURAL_REGENERATION, false);

        if(main.gameScenariosManager.isScenarioActivate("superheroes")){
            this.distribSuperHeroPowers();
        }

        if(main.gameVariables.afficheHealth){
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            Scoreboard board = manager.getNewScoreboard();

            Objective objective = board.registerNewObjective("showhealth", "health");
            objective.setDisplaySlot(DisplaySlot.PLAYER_LIST);

            for(Player online : Bukkit.getOnlinePlayers()){
                online.setScoreboard(board);
                Score score = objective.getScore(online);
                score.setScore((int) online.getMaxHealth());
                if(main.gameScenariosManager.isScenarioActivate("best pve")){
                    this.bestPVE.add(online);
                }
            }
        }

        this.setupBorder();
        this.resetPlayers();
        this.spreadPlayers();
        this.createScoreboard();
        this.startTask();


        for(Player p : Bukkit.getOnlinePlayers()){
            for(Material mat : main.gameVariables.itemsLimits.keySet()){
                ItemLimit itemLimit = new ItemLimit(p, mat, 0, main.gameVariables.itemsLimits.get(mat));
                itemLimits.add(itemLimit);
            }
            if(main.gameScenariosManager.isScenarioActivate("gonefishing")){
                ItemStack it = new ItemStack(Material.FISHING_ROD);
                it.addUnsafeEnchantment(Enchantment.LUCK, 250);
                ItemMeta itM = it.getItemMeta();
                itM.setUnbreakable(true);
                it.setItemMeta(itM);
                p.getInventory().addItem(it);
            }
            if(main.gameScenariosManager.isScenarioActivate("infinite enchanter")){
                p.setLevel(999999999);
            }
            if(main.gameScenariosManager.isScenarioActivate("skyhigh")){
                p.getInventory().addItem(main.API.itemStackManager.create(Material.DIRT, 5, ChatColor.GOLD + "Terre infinie"));
            }
        }

        main.customCraftManager.applyCrafts();

        for(int x = -25; x < 25; x++){
            for(int z = -25; z < 25; z++){
                new Location(Bukkit.getWorld("world"), x, 149, z).getBlock().setType(Material.AIR);
            }
        }

        if(main.gameScenariosManager.isScenarioActivate("cateyes")){
            for(Player p : Bukkit.getOnlinePlayers()){
                p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 1, true), true);
            }
        }

        if(main.gameScenariosManager.isScenarioActivate("random start item")){
            for(Player p : Bukkit.getOnlinePlayers()) {
                Material mat = Material.values()[new Random().nextInt(Material.values().length)];
                int quantity = main.API.random(1, 64);
                p.getInventory().addItem(main.API.itemStackManager.create(mat, quantity));
                Bukkit.broadcastMessage(p.getDisplayName() + ChatColor.GOLD + " obtient " + mat.name() + " " + quantity + " fois");
            }
        }

        if(main.gameScenariosManager.isScenarioActivate("randomcrafts")){
            List<Recipe> preRecipe = new ArrayList<>();
            for (Iterator<Recipe> it = main.getServer().recipeIterator(); it.hasNext(); ) {
                Recipe gameRecipe = it.next();
                preRecipe.add(gameRecipe);
            }

            List<Recipe> newRecipes = new ArrayList<>();

            for (Iterator<Recipe> it = main.getServer().recipeIterator(); it.hasNext(); ) {
                Recipe gameRecipe = it.next();

                if(gameRecipe instanceof ShapedRecipe){
                    ShapedRecipe shapedRecipe = (ShapedRecipe) gameRecipe;
                    int rdmIndex = main.API.random(0, preRecipe.size() - 1);
                        int index = 0;
                        while (preRecipe.get(rdmIndex).getResult().getType() == shapedRecipe.getResult().getType() && index < 100){
                            rdmIndex = main.API.random(0, preRecipe.size() - 1);
                            index++;
                        }
                    if(preRecipe.get(rdmIndex).getResult().getType() != Material.AIR) {
                        ShapedRecipe newShapedRecipe = new ShapedRecipe(preRecipe.get(rdmIndex).getResult());
                        preRecipe.remove(rdmIndex);
                        newShapedRecipe.shape(shapedRecipe.getShape());
                        for (Character character : shapedRecipe.getIngredientMap().keySet()) {
                            if (character != null && shapedRecipe.getIngredientMap().get(character) != null) {
                                if (shapedRecipe.getIngredientMap().get(character).getData() != null) {
                                    newShapedRecipe.setIngredient(character, shapedRecipe.getIngredientMap().get(character).getType(), shapedRecipe.getIngredientMap().get(character).getData().getData());
                                } else {
                                    newShapedRecipe.setIngredient(character, shapedRecipe.getIngredientMap().get(character).getType());
                                }
                            }
                        }
                        newRecipes.add(newShapedRecipe);
                    }
                }
                if(gameRecipe instanceof ShapelessRecipe) {
                    ShapelessRecipe shapelessRecipe = (ShapelessRecipe) gameRecipe;
                    int rdmIndex = main.API.random(0, preRecipe.size() - 1);
                        int index = 0;
                        while (preRecipe.get(rdmIndex).getResult().getType() == shapelessRecipe.getResult().getType() && index < 100){
                            rdmIndex = main.API.random(0, preRecipe.size() - 1);
                            index++;
                        }
                    if (preRecipe.get(rdmIndex).getResult().getType() != Material.AIR) {
                        ShapelessRecipe newShapeLessRecipe = new ShapelessRecipe(preRecipe.get(rdmIndex).getResult());
                        preRecipe.remove(rdmIndex);
                        for (ItemStack ingredient : shapelessRecipe.getIngredientList()) {
                            if (ingredient.getData() != null) {
                                newShapeLessRecipe.addIngredient(ingredient.getType(), ingredient.getData().getData());
                            } else {
                                newShapeLessRecipe.addIngredient(ingredient.getType());
                            }
                        }
                        newRecipes.add(newShapeLessRecipe);
                    }
                }
                if(gameRecipe instanceof FurnaceRecipe){
                    FurnaceRecipe preCookingRecipe = (FurnaceRecipe) gameRecipe;
                    int rdmIndex = main.API.random(0, preRecipe.size() - 1);
                    if (preRecipe.get(rdmIndex).getResult().getType() != Material.AIR) {
                        FurnaceRecipe newCookingRecipe = new FurnaceRecipe(preRecipe.get(rdmIndex).getResult(), preCookingRecipe.getInput().getType());
                        preRecipe.remove(rdmIndex);
                        newRecipes.add(newCookingRecipe);
                    }
                }

            }

            for(Recipe newRecipe : newRecipes){
                main.getServer().addRecipe(newRecipe);
            }
        }

    }

    private void distribSuperHeroPowers() {
        for(Player p : Bukkit.getOnlinePlayers()){
            int rand = main.API.random(1, 5);
            if(rand == 1) p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 0, false), false);
            if(rand == 2) p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, 2, false), false);
            if(rand == 2) noFall.add(p);
            if(rand == 3) p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 1, false), false);
            if(rand == 4) p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 0, false), false);
            if(rand == 5) p.setMaxHealth(40);
        }
    }

    public ItemLimit getItemLimit(Player p, Material mat){
        for(ItemLimit itemLimit : itemLimits){
            if(itemLimit.getP() == p && itemLimit.getMat() == mat){
                return itemLimit;
            }
        }
        return null;
    }

    public void updateItemLimit(ItemLimit itemLimit){
        for(ItemLimit itemLimitSTO : itemLimits){
            if(itemLimit.getUuid() == itemLimitSTO.getUuid()){
                itemLimits.remove(itemLimitSTO);
                itemLimits.add(itemLimit);
            }
        }
    }

    private void startTask() {
        gameTask = new GameTask(main);
        gameTask.runTaskTimer(main, 20, 20);
    }

    private void setupBorder() {
        WorldBorder bordure = Bukkit.getWorld("world").getWorldBorder();
        bordure.setCenter(0, 0);
        bordure.setSize(main.gameVariables.preBorder * 2);
        bordure.setWarningDistance(10);
        bordure.setDamageAmount(1);
        bordure = Bukkit.getWorld("world_nether").getWorldBorder();
        bordure.setCenter(0, 0);
        bordure.setSize(main.gameVariables.preBorder * 2);
        bordure.setWarningDistance(10);
        bordure.setDamageAmount(1);
    }

    private void resetPlayers() {
        for(Player p : Bukkit.getOnlinePlayers()){
            p.setHealth(p.getMaxHealth());
            p.setFoodLevel(20);
            p.getInventory().clear();
            p.setGameMode(GameMode.SURVIVAL);
            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 999999, 999999), true);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 999999), true);
            for(ItemStack it : main.gameVariables.startInventory){
                p.getInventory().addItem(it);
            }
        }
    }

    private void spreadPlayers() {
        if(!main.gameVariables.activateTeams) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de " + p.getName());
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
            }
        }else{
            if(main.teamsManager.white.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe blanche");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.white){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
            if(main.teamsManager.orange.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe orange");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.orange){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
            if(main.teamsManager.magenta.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe magenta");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.magenta){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
            if(main.teamsManager.lightblue.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe bleue calir");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.lightblue){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
            if(main.teamsManager.yellow.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe jaune");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.yellow){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
            if(main.teamsManager.lime.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe verte clair");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.lime){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
            if(main.teamsManager.pink.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe rose");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.pink){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
            if(main.teamsManager.gray.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe grise");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.gray){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
            if(main.teamsManager.lightgray.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe grise calir");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.lightgray){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
            if(main.teamsManager.cyan.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe cyan");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.cyan){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
            if(main.teamsManager.purple.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe violette");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.purple){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
            if(main.teamsManager.blue.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe bleue");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.brown){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
            if(main.teamsManager.green.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe verte");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.green){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
            if(main.teamsManager.red.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe rouge");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.red){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
            if(main.teamsManager.black.size() >= 1){
                Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "Téléportation de l'équipe noire");
                int x = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                int z = main.API.random(main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 3), main.gameVariables.preBorder - Math.round(main.gameVariables.preBorder / 10));
                if(main.API.random(0, 1) == 1) x = x * (-1);
                if(main.API.random(0, 1) == 1) z = z * (-1);
                for(Player p : main.teamsManager.black){
                    p.teleport(new Location(Bukkit.getWorld("world"), x, 150, z));
                }
            }
        }
    }

    private void createScoreboard() {
        for(Player p : Bukkit.getOnlinePlayers()){
            ScoreboardSign scoreboardSign = new ScoreboardSign(p, ChatColor.GOLD + "UHC");
            scoreboardSign.create();
            scoreboardSign.setLine(0, "§a");
            scoreboardSign.setLine(1, ChatColor.WHITE + "Joueurs restants: " + ChatColor.GREEN + inGamePlayers.size() + "/" + startedPlayerNumber);
            if(main.gameVariables.afficheTimers){
                scoreboardSign.setLine(2, "§c");
                scoreboardSign.setLine(3, ChatColor.WHITE + "PVP: " + ChatColor.GOLD + "00:00");
                scoreboardSign.setLine(4, ChatColor.WHITE + "Réduction: " + ChatColor.GOLD + "00:00");
                scoreboardSign.setLine(5, ChatColor.WHITE + "Temps de jeu: " + ChatColor.GOLD + "00:00");
                if(main.gameVariables.afficheBorder){
                    scoreboardSign.setLine(6, "§r");
                    scoreboardSign.setLine(7, ChatColor.WHITE + "Bordure:" + ChatColor.YELLOW + " ±" + main.gameVariables.preBorder);
                }
            }else{
                if(main.gameVariables.afficheBorder){
                    scoreboardSign.setLine(2, "§c");
                    scoreboardSign.setLine(3, "§r");
                    scoreboardSign.setLine(4, ChatColor.WHITE + "Bordure:" + ChatColor.YELLOW + " ±" + ChatColor.YELLOW + main.gameVariables.preBorder);
                }
            }
            this.scoreboards.put(p, scoreboardSign);
        }
    }

    public void updateScoreboard(int gameTimer) {
        this.gameTime = gameTimer;

        if(gameTimer == main.gameVariables.graceTime){
            Bukkit.broadcastMessage(ChatColor.GOLD + "Fin de l'invincibilité, bonne chance !");
        }
        if(gameTimer == main.gameVariables.pvpTime){
            Bukkit.broadcastMessage(ChatColor.GOLD + "Le PVP est maintenant activé !");
            if(main.gameScenariosManager.isScenarioActivate("finalheal")){
                for(Player p : this.inGamePlayers){
                    p.setHealth(p.getMaxHealth());
                }
            }
        }
        if(gameTimer == main.gameVariables.borderTime){
            Bukkit.broadcastMessage(ChatColor.GOLD + "La bordure se réduit, dirigez-vous vers le centre !");
            this.reduceBorder();
        }
        if(gameTimer > 0 && gameTimer % 1200 == 0){
            for(Player p : this.bestPVE){
                p.setMaxHealth(p.getMaxHealth() + 2);
            }

        }
        if(gameTimer > main.gameVariables.pvpTime && gameTimer % 30 == 0){
            if(main.gameScenariosManager.isScenarioActivate("skyhigh")){
                for(Player p : this.inGamePlayers){
                    if(p.getLocation().getY() < 150){
                        if(p.getHealth() > 2){
                            p.setHealth(p.getHealth() - 2);
                        }else{
                            killPlayer(p);
                        }
                    }
                }
            }
            if(main.gameScenariosManager.isScenarioActivate("underground")){
                for(Player p : this.inGamePlayers){
                    if(p.getLocation().getY() > 40){
                        if(p.getHealth() > 2){
                            p.setHealth(p.getHealth() - 2);
                        }else{
                            killPlayer(p);
                        }
                    }
                }
            }
        }

        if(gameTimer > main.gameVariables.pvpTime && gameTimer % 15 == 0) {
            if (main.gameScenariosManager.isScenarioActivate("netheribus")) {
                for (Player p : this.inGamePlayers) {
                    if (!p.getLocation().getWorld().getName().equals("world_nether")) {
                        if (p.getHealth() > 2) {
                            p.setHealth(p.getHealth() - 2);
                        } else {
                            killPlayer(p);
                        }
                    }
                }
            }
        }

        if(gameTimer > main.gameVariables.pvpTime && gameTimer % 600 == 0) {
            if (main.gameScenariosManager.isScenarioActivate("enderpearl drop")) {
                for (Player p : this.inGamePlayers) {
                    p.getInventory().addItem(main.API.itemStackManager.create(Material.ENDER_PEARL));
                }
            }
        }

        if(gameTimer > 1 && gameTimer % 290 == 0){
            if(main.gameScenariosManager.isScenarioActivate("playersswitch")){
                Bukkit.broadcastMessage(ChatColor.GOLD + "Switch dans 10 secondes !");
            }
        }

        if(gameTimer > 1 && gameTimer % 300 == 0){
            if(main.gameScenariosManager.isScenarioActivate("playersswitch")){
                Map<Player, Location> playersLoc = new HashMap<>();
                for(Player p : this.inGamePlayers){
                    playersLoc.put(p, p.getLocation());
                }
                for(Player p : playersLoc.keySet()){
                    boolean found = false;
                    Player next = null;
                    for(Player pl : playersLoc.keySet()){
                        if(found){
                            next = pl;
                            break;
                        }else{
                            if(pl == p){
                                found = true;
                            }
                        }
                    }
                    if(next == null){
                        next = (Player) playersLoc.keySet().toArray()[0];
                    }
                    p.teleport(playersLoc.get(next));
                }
            }

            if(main.gameScenariosManager.isScenarioActivate("coordinateDrops")){
                for(Player p : this.inGamePlayers){
                    Bukkit.broadcastMessage(p.getDisplayName() + ChatColor.GOLD + " est en "
                            + ChatColor.WHITE + "X: " + ChatColor.GREEN + Math.round(p.getLocation().getX()) + ChatColor.GRAY + " | "
                            + ChatColor.WHITE + "Y: " + ChatColor.GREEN + Math.round(p.getLocation().getY()) + ChatColor.GRAY + " | "
                            + ChatColor.WHITE + "Z: " + ChatColor.GREEN + Math.round(p.getLocation().getZ()) + ChatColor.GRAY + " | "
                    );
                }
            }
        }

        for(Player p : Bukkit.getOnlinePlayers()){
            ScoreboardSign scoreboardSign = scoreboards.get(p);
            scoreboardSign.setLine(1, ChatColor.WHITE + "Joueurs restants: " + ChatColor.GREEN + inGamePlayers.size() + "/" + startedPlayerNumber);
            if(main.gameVariables.afficheTimers){
                if(main.gameVariables.pvpTime > gameTimer) {
                    scoreboardSign.setLine(3, ChatColor.WHITE + "PVP: " + ChatColor.GOLD + main.gameVariables.getTimeIntoStringWithoutHour(main.gameVariables.pvpTime - gameTimer));
                }else{
                    scoreboardSign.setLine(3, ChatColor.WHITE + "PVP:" + ChatColor.GOLD + " Activé");
                }
                if(main.gameVariables.borderTime > gameTimer) {
                    scoreboardSign.setLine(4, ChatColor.WHITE + "Réduction: " + ChatColor.GOLD + main.gameVariables.getTimeIntoStringWithoutHour(main.gameVariables.borderTime - gameTimer));
                }else{
                    if(main.gameVariables.borderTime + main.gameVariables.reductionTime > gameTimer){
                        scoreboardSign.setLine(4, ChatColor.WHITE + "Réduction:" + ChatColor.GOLD + " En cours");
                    }else{
                        scoreboardSign.setLine(4, ChatColor.WHITE + "Réduction:" + ChatColor.GOLD + " Terminée");
                    }
                }
                scoreboardSign.setLine(5, ChatColor.WHITE + "Temps de jeu: " + ChatColor.GOLD + main.gameVariables.getTimeIntoStringWithoutHour(gameTimer));
                if(main.gameVariables.afficheBorder){
                    scoreboardSign.setLine(7, ChatColor.WHITE + "Bordure:" + ChatColor.YELLOW + " ±" + ChatColor.YELLOW + border);
                }
            }else{
                if(main.gameVariables.afficheBorder){
                    scoreboardSign.setLine(4, ChatColor.WHITE + "Bordure:" + ChatColor.YELLOW  + " ±" + ChatColor.YELLOW + border);
                }
            }
            this.scoreboards.put(p, scoreboardSign);
        }
    }

    public void setBorder(int border) {
        this.border = border;
    }

    private void reduceBorder() {
        Bordertask bordertask = new Bordertask(main);
        bordertask.runTaskTimer(main, 20, 20);
    }

    public void killPlayer(Player p) {
        if(this.inGamePlayers.contains(p)) {
            Bukkit.broadcastMessage(p.getDisplayName() + ChatColor.GRAY + " est mort");
            this.kill(p);
        }
    }

    public void killPlayerByPlayer(Player p, Player damager) {
        if(this.inGamePlayers.contains(p)) {
            if (main.gameVariables.afficheKiller) {
                Bukkit.broadcastMessage(p.getDisplayName() + ChatColor.GRAY + " est mort de la main de " + ChatColor.RESET + damager.getDisplayName());
            } else {
                Bukkit.broadcastMessage(p.getDisplayName() + ChatColor.GRAY + " est mort");
            }
            if(main.gameScenariosManager.isScenarioActivate("no cleanup")){
                damager.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 999999, 1, true), true);
            }
            this.kill(p);
        }
    }

    private void kill(Player p) {
        if(main.gameScenariosManager.isScenarioActivate("Timebomb")){
            Location loc = p.getLocation();
            Block leftBlock = loc.getBlock();
            loc.add(1, 0, 0);
            Block rightBlock = loc.getBlock();
            leftBlock.setType(Material.CHEST);
            rightBlock.setType(Material.CHEST);

            leftBlock.setBlockData(Material.CHEST.createBlockData("[facing=south,type=right]"));
            rightBlock.setBlockData(Material.CHEST.createBlockData("[facing=south,type=left]"));

            Chest doubleChest = (Chest) leftBlock.getState();
            for(ItemStack it : p.getInventory()){
                if (it != null) {
                    doubleChest.getInventory().addItem(it);
                    ArmorStand armorStand = (ArmorStand) Bukkit.getWorld("world").spawnEntity(leftBlock.getLocation().add(1, 1, 0), EntityType.ARMOR_STAND);
                    armorStand.setCustomNameVisible(true);
                    armorStand.setCustomName("60");
                    armorStand.setVisible(false);
                    armorStand.setInvulnerable(true);
                    armorStand.setSmall(true);
                    armorStand.setGravity(false);
                    BombTask bombTask = new BombTask(leftBlock.getLocation(), armorStand);
                    bombTask.runTaskTimer(main, 20, 20);
                }
            }

        }else {
            for (ItemStack it : p.getInventory()) {
                if (it != null) {
                    p.getLocation().getWorld().dropItemNaturally(p.getLocation(), it);
                }
            }
        }
        for(Player online : Bukkit.getOnlinePlayers()){
            online.playSound(online.getLocation(), Sound.ENTITY_WITHER_SPAWN, 20, 1);
        }
        p.getInventory().clear();
        p.setGameMode(GameMode.SPECTATOR);
        p.setHealth(20);
        p.setFoodLevel(20);
        death.put(p, p.getLocation());
        this.inGamePlayers.remove(p);
        this.checkWin();
    }

    private void checkWin() {
        if(main.gameVariables.activateTeams){
            String colorWinned = "";
            boolean win = false;
            for(Player p : inGamePlayers){
                if(main.teamsManager.isInTeam(p, "white")){
                    if(colorWinned.equals("")) {
                        colorWinned = "w";
                        win = true;
                    }else if(!colorWinned.equals("w")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "orange")){
                    if(colorWinned.equals("")) {
                        colorWinned = "o";
                        win = true;
                    }else if(!colorWinned.equals("o")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "magenta")){
                    if(colorWinned.equals("")) {
                        colorWinned = "m";
                        win = true;
                    }else if(!colorWinned.equals("m")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "lightblue")){
                    if(colorWinned.equals("")) {
                        colorWinned = "lb";
                        win = true;
                    }else if(!colorWinned.equals("lb")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "yellow")){
                    if(colorWinned.equals("")) {
                        colorWinned = "y";
                        win = true;
                    }else if(!colorWinned.equals("y")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "lime")){
                    if(colorWinned.equals("")) {
                        colorWinned = "l";
                        win = true;
                    }else if(!colorWinned.equals("l")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "pink")){
                    if(colorWinned.equals("")) {
                        colorWinned = "pin";
                        win = true;
                    }else if(!colorWinned.equals("pin")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "gray")){
                    if(colorWinned.equals("")) {
                        colorWinned = "g";
                        win = true;
                    }else if(!colorWinned.equals("g")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "lightgray")){
                    if(colorWinned.equals("")) {
                        colorWinned = "lg";
                        win = true;
                    }else if(!colorWinned.equals("lg")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "cyan")){
                    if(colorWinned.equals("")) {
                        colorWinned = "c";
                        win = true;
                    }else if(!colorWinned.equals("c")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "purple")){
                    if(colorWinned.equals("")) {
                        colorWinned = "pu";
                        win = true;
                    }else if(!colorWinned.equals("pu")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "blue")){
                    if(colorWinned.equals("")) {
                        colorWinned = "bl";
                        win = true;
                    }else if(!colorWinned.equals("bl")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "brown")){
                    if(colorWinned.equals("")) {
                        colorWinned = "br";
                        win = true;
                    }else if(!colorWinned.equals("br")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "green")){
                    if(colorWinned.equals("")) {
                        colorWinned = "gre";
                        win = true;
                    }else if(!colorWinned.equals("gre")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "red")){
                    if(colorWinned.equals("")) {
                        colorWinned = "r";
                        win = true;
                    }else if(!colorWinned.equals("r")){
                        win = false;
                    }
                }
                if(main.teamsManager.isInTeam(p, "black")){
                    if(colorWinned.equals("")) {
                        colorWinned = "bla";
                        win = true;
                    }else if(!colorWinned.equals("bla")){
                        win = false;
                    }
                }
            }
            if(win){
                main.gameStepManager.setStep(GameStep.END);
                if(colorWinned.equals("w"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe blanche remporte la partie !");
                if(colorWinned.equals("o"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe orange remporte la partie !");
                if(colorWinned.equals("m"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe magenta remporte la partie !");
                if(colorWinned.equals("lb"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe bleue clair remporte la partie !");
                if(colorWinned.equals("y"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe jaune remporte la partie !");
                if(colorWinned.equals("l"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe verte clair remporte la partie !");
                if(colorWinned.equals("pu"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe violette remporte la partie !");
                if(colorWinned.equals("g"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe grise remporte la partie !");
                if(colorWinned.equals("lg"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe grise clair remporte la partie !");
                if(colorWinned.equals("c"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe cyan remporte la partie !");
                if(colorWinned.equals("pin"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe rose remporte la partie !");
                if(colorWinned.equals("bl"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe bleue remporte la partie !");
                if(colorWinned.equals("br"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe brown remporte la partie !");
                if(colorWinned.equals("gre"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe verte remporte la partie !");
                if(colorWinned.equals("r"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe rouge remporte la partie !");
                if(colorWinned.equals("bla"))  Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "L'équipe noire remporte la partie !");
            }
        }else{
            if(this.inGamePlayers.size() == 1){
                main.gameStepManager.setStep(GameStep.END);
                Bukkit.broadcastMessage(ChatColor.BOLD + inGamePlayers.get(0).getDisplayName() + ChatColor.GOLD + " remporte la partie !");
            }
        }
    }
}
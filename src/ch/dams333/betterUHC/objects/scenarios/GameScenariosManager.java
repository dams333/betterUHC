package ch.dams333.betterUHC.objects.scenarios;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameScenariosManager {
    BetterUHC main;
    private List<GameScenario> gameScenarios;

    public List<GameScenario> getGameScenarios() {
        return gameScenarios;
    }

    public GameScenariosManager(BetterUHC main) {
        this.main = main;
        gameScenarios = new ArrayList<>();

        gameScenarios.add(new GameScenario("CutClean", Arrays.asList(ChatColor.GRAY + "Tout est déjà cuit"), Material.COOKED_BEEF, null));
        gameScenarios.add(new GameScenario("Timber", Arrays.asList(ChatColor.GRAY + "Les arbres se cassent en un coup"), Material.DIAMOND_AXE, null));
        gameScenarios.add(new GameScenario("Best PVE", Arrays.asList(ChatColor.GRAY + "Lorsqu'ils prennent un dégât PVE, les joueurs", ChatColor.GRAY + "sont enlevés de la liste. Toutes les 20min, " , ChatColor.GRAY + "les joueurs restants gagnent un coeur"), Material.DIAMOND_SWORD, null));
        gameScenarios.add(new GameScenario("SuperHeroes", Arrays.asList(ChatColor.GRAY + "Chaque joueur spawn avec un pouvoir" , ChatColor.GRAY + "(Force, JumpBoost, Speed, Resistance, Double vie)"), Material.JACK_O_LANTERN, null));
        gameScenarios.add(new GameScenario("Blood Diamond", Arrays.asList(ChatColor.GRAY + "Les diamants font perdre X coeur quand ils sont minés"), Material.DIAMOND, Arrays.asList(new ScenarioArgument("Perte à chaque diamant", 0.5, Material.GOLDEN_APPLE, 0.5))));
        gameScenarios.add(new GameScenario("TimeBomb", Arrays.asList(ChatColor.GRAY + "Quand un joueur meurt, un coffre apparaît avec" , ChatColor.GRAY + "son stuff mais explose au bout de X secondes"), Material.TNT, Arrays.asList(new ScenarioArgument("Temps avant l'explosion", (double) 60, Material.CLOCK, (double) 10))));
        gameScenarios.add(new GameScenario("LongShot", Arrays.asList(ChatColor.GRAY + "Si un joueur touch un ennemi à plus de X blocs," , ChatColor.GRAY + "il régénère 1 coeur"), Material.BOW, Arrays.asList(new ScenarioArgument("Distance nécessaire", (double) 75, Material.BOW, (double) 5))));
        gameScenarios.add(new GameScenario("Paranoia", Arrays.asList(ChatColor.GRAY + "Miner de l'or ou du diamant, révèle les coordonées du joueur"), Material.LEATHER_HELMET, null));
        gameScenarios.add(new GameScenario("SkyHigh", Arrays.asList(ChatColor.GRAY + "A l'activation du PVP, tous les", ChatColor.GRAY + "joueurs sous la couche X perdront", ChatColor.GRAY + "1 coeur toutes les 30 sec"), Material.FEATHER, Arrays.asList(new ScenarioArgument("Couche nécessaire", (double) 150, Material.FEATHER, (double) 5))));
        gameScenarios.add(new GameScenario("GoneFishing", Arrays.asList(ChatColor.GRAY + "Les joueurs spawnent avec une canne à", ChatColor.GRAY + "pêche chéatée"), Material.FISHING_ROD, null));
        gameScenarios.add(new GameScenario("Infinite enchanter", Arrays.asList(ChatColor.GRAY + "Les joueurs peuvent enchanter et", ChatColor.GRAY + "fusionner à l'infini"), Material.ANVIL, null));
        gameScenarios.add(new GameScenario("HasteyBoys", Arrays.asList(ChatColor.GRAY + "Les outils ont automatiquement", ChatColor.GRAY + "l'enchantement éfficacité III"), Material.IRON_PICKAXE, null));
        gameScenarios.add(new GameScenario("No CleanUp", Arrays.asList(ChatColor.GRAY + "Quand un joueur fait un kill,", ChatColor.GRAY + "il obtient 2 coeurs d'absorption"), Material.GLISTERING_MELON_SLICE, null));
        gameScenarios.add(new GameScenario("NetherLess", Arrays.asList(ChatColor.GRAY + "Le nether est désactivé"), Material.LAVA_BUCKET, null));
        gameScenarios.add(new GameScenario("Underground", Arrays.asList(ChatColor.GRAY + "A l'activation du PVP, tous les", ChatColor.GRAY + "joueurs au dessus de la couche X perdront", ChatColor.GRAY + "1 coeur toutes les 30 sec"), Material.STONE, Arrays.asList(new ScenarioArgument("Couche nécessaire", (double) 30, Material.STONE, (double) 5))));
        gameScenarios.add(new GameScenario("Netheribus", Arrays.asList(ChatColor.GRAY + "A l'activation du PVP, tous les", ChatColor.GRAY + "joueurs qui ne sont pas dans le nether perdront", ChatColor.GRAY + "1 coeur toutes les 15 sec"), Material.NETHERRACK, null));
        gameScenarios.add(new GameScenario("EnderPearl drop", Arrays.asList(ChatColor.GRAY + "A l'activation du PVP, toutes les", ChatColor.GRAY + "X minutes, les joueurs", ChatColor.GRAY + "recevront une enderpearl"), Material.ENDER_PEARL, Arrays.asList(new ScenarioArgument("Minutes entre chaque enderpearl", (double) 10, Material.CLOCK, (double) 1))));
        gameScenarios.add(new GameScenario("CatEyes", Arrays.asList(ChatColor.GRAY + "Les joueurs ont night vision infinie"), Material.ENDER_EYE, null));
        gameScenarios.add(new GameScenario("SwitchHeroes", Arrays.asList(ChatColor.GRAY + "Quand un joueur touche un autre à l'arc,", ChatColor.GRAY + "il a X% de chance d'échanger sa place", ChatColor.GRAY + "avec celui-ci"), Material.CHORUS_FRUIT, Arrays.asList(new ScenarioArgument("Pourcentage de chance", (double) 10, Material.BOW, (double) 5))));
        gameScenarios.add(new GameScenario("BlockRush", Arrays.asList(ChatColor.GRAY + "Quand un joueur casse un bloc qui n'a jamais,", ChatColor.GRAY + "été cassé, il gagne X lingot d'or"), Material.GOLD_INGOT, Arrays.asList(new ScenarioArgument("Nombre de lingots", (double) 1, Material.GOLD_INGOT, (double) 1))));
        gameScenarios.add(new GameScenario("Inventor Paranoia", Arrays.asList(ChatColor.GRAY + "Quand un joueur craft un item qui n'a,", ChatColor.GRAY + "jamais été crafté, ses coordonées sont révélées"), Material.CRAFTING_TABLE, null));
        gameScenarios.add(new GameScenario("Random start item", Arrays.asList(ChatColor.GRAY + "Au lancement, chaque joueur obtient", ChatColor.GRAY + "un objet aléatoire dans une quantité aléatoire"), Material.STICK, null));
        gameScenarios.add(new GameScenario("BowInfos", Arrays.asList(ChatColor.GRAY + "Quand un joueur touche un autre à l'arc,", ChatColor.GRAY + "il connaît sont pseudo et sa vie restante"), Material.ARROW, null));
        gameScenarios.add(new GameScenario("FinalHeal", Arrays.asList(ChatColor.GRAY + "A l'activation du PVP, tous les", ChatColor.GRAY + "joueurs sont soignés"), Material.GOLDEN_APPLE, null));
        gameScenarios.add(new GameScenario("CoordinateDrops", Arrays.asList(ChatColor.GRAY + "Toutes les X minutes,", ChatColor.GRAY + "les coordonées des joueurs sont données"), Material.COMPASS, Arrays.asList(new ScenarioArgument("Minutes entre chaque drops", (double) 5, Material.CLOCK, (double) 1))));
        gameScenarios.add(new GameScenario("RandomCrafts", Arrays.asList(ChatColor.GRAY + "Tous les crafts sont mélangés"), Material.SUNFLOWER, null));
        gameScenarios.add(new GameScenario("FlowerPower", Arrays.asList(ChatColor.GRAY + "Les fleurs droppent un item aléatoire"), Material.POPPY, null));
    }

    public boolean isScenarioActivate(String name){
        for(GameScenario gameScenario : this.gameScenarios){
            if(gameScenario.getName().equalsIgnoreCase(name)){
                return gameScenario.isActivated();
            }
        }
        return false;
    }

    public GameScenario getGameScenario(ItemStack it){
        for(GameScenario gameScenario : this.gameScenarios){
            if(gameScenario.getMaterial() == it.getType()){
                return gameScenario;
            }
        }
        return null;
    }

    public void setScenarios(List<GameScenario> gameScenarios){
        this.gameScenarios = gameScenarios;
    }

    public GameScenario getGameScenario(String name){
        for(GameScenario gameScenario : this.gameScenarios){
            if(gameScenario.getName().equalsIgnoreCase(name)){
                return gameScenario;
            }
        }
        return null;
    }

    public void changeScenarioStatu(ItemStack it){
        GameScenario gameScenario = getGameScenario(it);
        int index = gameScenarios.indexOf(gameScenario);
        gameScenario.setActivated(!gameScenario.isActivated());
        gameScenarios.set(index, gameScenario);
    }

    public void openArgumentsInventory(Player p, ItemStack it) {
        GameScenario gameScenario = getGameScenario(it);
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Scénarios > " + gameScenario.getName());

        inv = gameScenario.addArguments(inv);

        inv.setItem(8, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière"));
        p.openInventory(inv);
    }

    public void changeArgument(InventoryClickEvent e) {
        String name = e.getView().getTitle().split(">")[1].replaceFirst(" ", "");
        GameScenario gameScenario = getGameScenario(name);
        int index = gameScenarios.indexOf(gameScenario);

        for(ScenarioArgument arg : gameScenario.getArguments()){
            if(arg.getItem().getType() == e.getCurrentItem().getType()){
                int index2 = gameScenario.getArguments().indexOf(arg);
                if(e.getAction() == InventoryAction.PICKUP_ALL){
                    arg.setValue(arg.getValue() + arg.getIncrement());
                }else{
                    arg.setValue(arg.getValue() - arg.getIncrement());
                }
                gameScenario.getArguments().set(index2, arg);
            }
        }
        gameScenarios.set(index, gameScenario);
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Scénarios > " + gameScenario.getName());

        inv = gameScenario.addArguments(inv);

        inv.setItem(8, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière"));
        e.getWhoClicked().openInventory(inv);
    }

    public Double getScenarioArgument(String scenario, String argument){
        for(GameScenario gameScenario : this.gameScenarios){
            if(gameScenario.getName().equalsIgnoreCase(scenario)) {
                for(ScenarioArgument arg : gameScenario.getArguments()){
                    if (arg.getName().equalsIgnoreCase(argument)) {
                        return arg.getValue();
                    }
                }
            }
        }
        return (double) 0;
    }
}

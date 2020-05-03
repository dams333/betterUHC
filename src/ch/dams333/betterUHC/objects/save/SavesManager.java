package ch.dams333.betterUHC.objects.save;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.craft.CustomCraft;
import ch.dams333.betterUHC.objects.scenarios.GameScenario;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class SavesManager implements Listener {
    BetterUHC main;

    private List<Player> inSave;
    private List<Save> saves;

    public SavesManager(BetterUHC betterUHC) {
        this.main = betterUHC;
        this.inSave = new ArrayList<>();
        this.saves = new ArrayList<>();
    }

    public void addToSave(Player p) {
        inSave.add(p);
    }

    public List<Save> getSavedConfigs(){
        return this.saves;
    }

    private Save getSave(String name){
        for(Save save : this.saves){
            if(save.getSaveName().equalsIgnoreCase(name)){
                return save;
            }
        }
        return null;
    }

    public void loadSave(String name, Player p){
        if(saveExist(name)){
            Save save = getSave(name);
            save.load(main);
            p.closeInventory();
            p.sendMessage(ChatColor.LIGHT_PURPLE + "La configuration " + name + " a été chargée");
        }else{
            p.closeInventory();
            p.sendMessage(ChatColor.RED + "Une erreur est survenue");
        }
    }

    @EventHandler
    public void chat(AsyncPlayerChatEvent e){
        if(inSave.contains(e.getPlayer())){
            e.setCancelled(true);
            if(saveExist(e.getMessage())){
                e.getPlayer().sendMessage(ChatColor.RED + "Ce nom est déjà pris, choisis en un autre");
            }else {
                Save save = new Save(e.getMessage(), main.gameVariables.graceTime, main.gameVariables.pvpTime, main.gameVariables.borderTime, main.gameVariables.startInventory, main.gameVariables.activateTeams, main.gameVariables.infiniteTeams, main.gameVariables.whiteTeam, main.gameVariables.orangeTeam, main.gameVariables.magentaTeam, main.gameVariables.lightBlueTeam, main.gameVariables.yellowTeam, main.gameVariables.limeTeam, main.gameVariables.pinkTeam, main.gameVariables.grayTeam, main.gameVariables.lightGrayTeam, main.gameVariables.cyanTeam, main.gameVariables.purpleTeam, main.gameVariables.blueTeam, main.gameVariables.brownTeam, main.gameVariables.greenTeam, main.gameVariables.redTeam, main.gameVariables.blackTeam, main.gameVariables.preBorder, main.gameVariables.postBorder, main.gameVariables.reductionTime, main.gameVariables.itemsLimits, main.gameVariables.leatherLimit, main.gameVariables.ironLimit, main.gameVariables.chainLimit, main.gameVariables.goldLimit, main.gameVariables.diamondLimit, main.gameVariables.diamondProtecLimit, main.gameVariables.ironProteclimit, main.gameVariables.diamondSharpLimit, main.gameVariables.ironSharpLimit, main.gameVariables.globalChat, main.gameVariables.anonymGlobalChat, main.gameVariables.teamChat, main.gameVariables.anonymTeamChat, main.gameVariables.afficheTimers, main.gameVariables.afficheBorder, main.gameVariables.afficheKiller, main.gameVariables.afficheHealth, main.gameScenariosManager.getGameScenarios(), main.customCraftManager.getCustomCrafts());
                this.saves.add(save);
                inSave.remove(e.getPlayer());
                e.getPlayer().sendMessage(ChatColor.GREEN + "Sauvegarde de la configuration éffectuée");
            }
        }
    }

    private boolean saveExist(String name){
        for(Save save : this.saves){
            if(save.getSaveName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public void serializeSaves(){
        for(String key : main.getConfig().getKeys(false)){
            main.getConfig().set(key, null);
        }
        main.getConfig().createSection("Configuration saves");
        for(Save save : this.saves){
            ConfigurationSection sec = main.getConfig().getConfigurationSection("Configuration saves").createSection(save.getSaveName());
            sec.set("graceTime", save.getGraceTime());
            sec.set("pvpTime", save.getPvpTime());
            sec.set("borderTime", save.getBorderTime());

            ConfigurationSection startInventorySec = sec.createSection("startInventory");
            for(ItemStack it : save.getStartInventory()){
                main.API.serializeItem(startInventorySec, it);
            }

            sec.set("activateTeams", save.isActivateTeams());
            sec.set("infiniteTeams", save.isInfiniteTeams());
            sec.set("whiteTeam", save.getWhiteTeam());
            sec.set("orangeTeam", save.getOrangeTeam());
            sec.set("magentaTeam", save.getMagentaTeam());
            sec.set("lightBlueTeam", save.getLightBlueTeam());
            sec.set("yellowTeam", save.getYellowTeam());
            sec.set("limeTeam", save.getLimeTeam());
            sec.set("pinkTeam", save.getPinkTeam());
            sec.set("grayTeam", save.getGrayTeam());
            sec.set("lightGrayTeam", save.getLightGrayTeam());
            sec.set("cyanTeam", save.getCyanTeam());
            sec.set("purpleTeam", save.getPurpleTeam());
            sec.set("blueTeam", save.getBlueTeam());
            sec.set("brownTeam", save.getBrownTeam());
            sec.set("greenTeam", save.getGreenTeam());
            sec.set("redTeam", save.getRedTeam());
            sec.set("blackTeam", save.getBlackTeam());

            sec.set("preBorder", save.getPreBorder());
            sec.set("postBorder", save.getPostBorder());
            sec.set("reductionTime", save.getReductionTime());

            ConfigurationSection itemLimitsSec = sec.createSection("itemsLimits");
            for(Material mat : save.getItemsLimits().keySet()){
                itemLimitsSec.set(mat.toString(), save.getItemsLimits().get(mat));
            }

            sec.set("leatherLimit", save.getLeatherLimit());
            sec.set("chainLimit", save.getChainLimit());
            sec.set("ironLimit", save.getIronLimit());
            sec.set("goldLimit", save.getGoldLimit());
            sec.set("diamondLimit", save.getDiamondLimit());

            sec.set("diamondProtetLimit", save.getDiamondProtecLimit());
            sec.set("ironProtecLimit", save.getIronProteclimit());
            sec.set("diamondSharpLimit", save.getDiamondSharpLimit());
            sec.set("ironSharpLimit", save.getIronSharpLimit());

            sec.set("globalChat", save.isGlobalChat());
            sec.set("anonymGlobalChat", save.isAnonymGlobalChat());
            sec.set("teamChat", save.isTeamChat());
            sec.set("anonymTeamChat", save.isAnonymTeamChat());

            sec.set("afficheTimers", save.isAfficheTimers());
            sec.set("afficheBorder", save.isAfficheBorder());
            sec.set("afficheKiller", save.isAfficheKiller());
            sec.set("afficheHealth", save.isAfficheHealth());

            ConfigurationSection scenariosSec = sec.createSection("Scenarios");

            for(GameScenario gameScenario : save.getGameScenarios()){
                scenariosSec.set(gameScenario.getName(), gameScenario.isActivated());
            }

            ConfigurationSection craftsSec = sec.createSection("Crafts");
            for(CustomCraft customCraft : save.getCustomCrafts()){
                ConfigurationSection s = craftsSec.createSection(customCraft.getUuid().toString());
                ConfigurationSection needed = s.createSection("Ingredients");
                List<ItemStack> ingredients = new ArrayList<>();
                if(customCraft.getAa() != null) {
                    ingredients.add(customCraft.getAa());
                }else{
                    ingredients.add(new ItemStack(Material.AIR));
                }
                ingredients.add(customCraft.getAb());
                ingredients.add(customCraft.getAc());
                ingredients.add(customCraft.getBa());
                ingredients.add(customCraft.getBb());
                ingredients.add(customCraft.getBc());
                ingredients.add(customCraft.getCa());
                ingredients.add(customCraft.getCb());
                ingredients.add(customCraft.getCc());
                for(ItemStack it : ingredients) {
                    if(it != null && it.getType() != Material.AIR) {
                        main.API.serializeItem(needed, it);
                    }else{
                        main.API.serializeItem(needed, new ItemStack(Material.BARRIER));
                    }
                }
                ConfigurationSection result = s.createSection("Result");
                main.API.serializeItem(result, customCraft.getResult());
            }
        }

        main.saveConfig();
    }

    public void deserializeSaves(){
        for(String configName : main.getConfig().getConfigurationSection("Configuration saves").getKeys(false)){
            ConfigurationSection sec = main.getConfig().getConfigurationSection("Configuration saves").getConfigurationSection(configName);

            int graceTime = sec.getInt("graceTime");
            int pvpTime = sec.getInt("pvpTime");
            int borderTime = sec.getInt("borderTime");

            List<ItemStack> startInventory = main.API.deserializeItems(sec.getConfigurationSection("startInventory"));

            boolean activateTeams = sec.getBoolean("activateTeams");
            boolean infiniteTeams = sec.getBoolean("infiniteTeams");
            int whiteTeam = sec.getInt("whiteTeam");
            int orangeTeam = sec.getInt("orangeTeam");
            int magentaTeam = sec.getInt("magentaTeam");
            int lightBlueTeam = sec.getInt("lightBlueTeam");
            int yellowTeam = sec.getInt("yellowTeam");
            int limeTeam = sec.getInt("limeTeam");
            int pinkTeam = sec.getInt("pinkTeam");
            int grayTeam = sec.getInt("grayTeam");
            int lightGrayTeam = sec.getInt("lightGrayTeam");
            int cyanTeam = sec.getInt("cyanTeam");
            int purpleTeam = sec.getInt("purpleTeam");
            int blueTeam = sec.getInt("blueTeam");
            int brownTeam = sec.getInt("brownTeam");
            int greenTeam = sec.getInt("greenTeam");
            int redTeam = sec.getInt("redTeam");
            int blackTeam = sec.getInt("blackTeam");

            int preBorder = sec.getInt("preBorder");
            int postBorder = sec.getInt("postBorder");
            int reductionTime = sec.getInt("reductionTime");

            Map<Material, Integer> itemsLimits = new HashMap<>();
            for(String matSTR : sec.getConfigurationSection("itemsLimits").getKeys(false)){
                itemsLimits.put(Material.valueOf(matSTR), sec.getConfigurationSection("itemsLimits").getInt(matSTR));
            }

            int leatherLimit = sec.getInt("leatherLimit");
            int chainLimit = sec.getInt("chainLimit");
            int ironLimit = sec.getInt("ironLimit");
            int goldLimit = sec.getInt("goldLimit");
            int diamondLimit = sec.getInt("diamondLimit");

            int diamondProtecLimit = sec.getInt("diamondProtecLimit");
            int diamondSharpLimit = sec.getInt("diamondSharpLimit");
            int ironProtecLimit = sec.getInt("ironProtecLimit");
            int ironSharpLimit = sec.getInt("ironSharpLimit");

            boolean globalChat = sec.getBoolean("globalChat");
            boolean anonymGlobalChat = sec.getBoolean("anonymGlobalChat");
            boolean teamChat = sec.getBoolean("teamChat");
            boolean anonymTeamChat = sec.getBoolean("anonymTeamChat");

            boolean afficheTimers = sec.getBoolean("afficheTimers");
            boolean afficheBorder = sec.getBoolean("afficheBorder");
            boolean afficheKiller = sec.getBoolean("afficheKiller");
            boolean afficheHealth = sec.getBoolean("afficheHealth");

            List<GameScenario> gameScenarios = new ArrayList<>();
            for(String scenarioName : sec.getConfigurationSection("Scenarios").getKeys(false)){
                GameScenario gameScenario = main.gameScenariosManager.getGameScenario(scenarioName);
                gameScenario.setActivated(sec.getConfigurationSection("Scenarios").getBoolean(scenarioName));
                gameScenarios.add(gameScenario);
            }

            ConfigurationSection craftsSec = sec.getConfigurationSection("Crafts");
            List<CustomCraft> customCrafts = new ArrayList<>();
            for(String uuidSTR : craftsSec.getKeys(false)){
                ConfigurationSection s = craftsSec.getConfigurationSection(uuidSTR);
                ConfigurationSection needed = s.getConfigurationSection("Ingredients");
                List<ItemStack> ingredients = main.API.deserializeItems(needed);
                ItemStack Aa = null;
                if(ingredients.get(0).getType() != Material.BARRIER) {
                    Aa = ingredients.get(0);
                }else{
                    Aa = new ItemStack(Material.AIR);
                }
                ItemStack Ab = null;
                if(ingredients.get(1).getType() != Material.BARRIER) {
                    Ab = ingredients.get(1);
                }else{
                    Ab = new ItemStack(Material.AIR);
                }
                ItemStack Ac = null;
                if(ingredients.get(2).getType() != Material.BARRIER) {
                    Ac = ingredients.get(2);
                }else{
                    Ac = new ItemStack(Material.AIR);
                }
                ItemStack Ba = null;
                if(ingredients.get(3).getType() != Material.BARRIER) {
                    Ba = ingredients.get(3);
                }else{
                    Ba = new ItemStack(Material.AIR);
                }
                ItemStack Bb = null;
                if(ingredients.get(4).getType() != Material.BARRIER) {
                    Bb = ingredients.get(4);
                }else{
                    Bb = new ItemStack(Material.AIR);
                }
                ItemStack Bc = null;
                if(ingredients.get(5).getType() != Material.BARRIER) {
                    Bc = ingredients.get(5);
                }else{
                    Bc = new ItemStack(Material.AIR);
                }
                ItemStack Ca = null;
                if(ingredients.get(6).getType() != Material.BARRIER) {
                    Ca = ingredients.get(6);
                }else{
                    Ca = new ItemStack(Material.AIR);
                }
                ItemStack Cb = null;
                if(ingredients.get(7).getType() != Material.BARRIER) {
                    Cb = ingredients.get(7);
                }else{
                    Cb = new ItemStack(Material.AIR);
                }
                ItemStack Cc = null;
                if(ingredients.get(8).getType() != Material.BARRIER) {
                    Cc = ingredients.get(8);
                }else{
                    Cc = new ItemStack(Material.AIR);
                }

                ConfigurationSection result = s.getConfigurationSection("Result");
                ItemStack resultIT = main.API.deserializeItems(result).get(0);
                CustomCraft customCraft = new CustomCraft(Aa, Ab, Ac, Ba, Bb, Bc, Ca, Cb, Cc, resultIT, UUID.fromString(uuidSTR));
                customCrafts.add(customCraft);
            }

            Save save = new Save(configName,  graceTime,  pvpTime,  borderTime, startInventory,  activateTeams,  infiniteTeams,  whiteTeam,  orangeTeam,  magentaTeam,  lightBlueTeam,  yellowTeam,  limeTeam,  pinkTeam,  grayTeam,  lightGrayTeam,  cyanTeam,  purpleTeam,  blueTeam,  brownTeam,  greenTeam,  redTeam,  blackTeam,  preBorder,  postBorder,  reductionTime, itemsLimits,  leatherLimit,  ironLimit,  chainLimit,  goldLimit,  diamondLimit,  diamondProtecLimit,  ironProtecLimit,  diamondSharpLimit,  ironSharpLimit,  globalChat,  anonymGlobalChat,  teamChat,  anonymTeamChat,  afficheTimers,  afficheBorder,  afficheKiller,  afficheHealth, gameScenarios, customCrafts);
            this.saves.add(save);
        }
    }

    public void removeSave(String name, Player p) {
        if(saveExist(name)){
            Save save = getSave(name);
            this.saves.remove(save);
            p.sendMessage(ChatColor.LIGHT_PURPLE + "La configuration " + name + " a été supprimée");
        }else{
            p.sendMessage(ChatColor.RED + "Une erreur est survenue");
        }
    }
}

package ch.dams333.betterUHC.objects.scenarios;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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

        gameScenarios.add(new GameScenario("CutClean", Arrays.asList(ChatColor.GRAY + "Tout est déjà cuit"), Material.COOKED_BEEF));
        gameScenarios.add(new GameScenario("Timber", Arrays.asList(ChatColor.GRAY + "Les arbres se cassent en un coup"), Material.DIAMOND_AXE));
        gameScenarios.add(new GameScenario("Best PVE", Arrays.asList(ChatColor.GRAY + "Lorsqu'ils prennent un dégât PVE, les joueurs", ChatColor.GRAY + "sont enlevés de la liste. Toutes les 20min, " , ChatColor.GRAY + "les joueurs restants gagnent un coeur"), Material.DIAMOND_SWORD));
        gameScenarios.add(new GameScenario("SuperHeroes", Arrays.asList(ChatColor.GRAY + "Chaque joueur spawn avec un pouvoir" , ChatColor.GRAY + "(Force, JumpBoost, Speed, Resistance, Double vie)"), Material.JACK_O_LANTERN));
        gameScenarios.add(new GameScenario("Blood Diamond", Arrays.asList(ChatColor.GRAY + "Les diamants font perdre 1/2 coeur quand ils sont minés"), Material.DIAMOND));
        gameScenarios.add(new GameScenario("TimeBomb", Arrays.asList(ChatColor.GRAY + "Quand un joueur meurt, un coffre apparaît avec" , ChatColor.GRAY + "son stuff mais explose au bout de 60 secondes"), Material.TNT));
        gameScenarios.add(new GameScenario("LongShot", Arrays.asList(ChatColor.GRAY + "Si un joueur touch un ennemi à plus de 75 blocs," , ChatColor.GRAY + "il régénère 1 coeur"), Material.BOW));
        gameScenarios.add(new GameScenario("Paranoia", Arrays.asList(ChatColor.GRAY + "Miner de l'or ou du diamant, révèle les coordonées du joueur"), Material.LEATHER_HELMET));
        gameScenarios.add(new GameScenario("SkyHigh", Arrays.asList(ChatColor.GRAY + "A l'activation du PVP, tous les", ChatColor.GRAY + "joueurs sous la couche 150 perdront", ChatColor.GRAY + "1 coeur toutes les 30 sec"), Material.FEATHER));
        gameScenarios.add(new GameScenario("GoneFishing", Arrays.asList(ChatColor.GRAY + "Les joueurs spawnent avec une canne à", ChatColor.GRAY + "pêche chéatée"), Material.FISHING_ROD));
        gameScenarios.add(new GameScenario("Infinite enchanter", Arrays.asList(ChatColor.GRAY + "Les joueurs peuvent enchanter et", ChatColor.GRAY + "fusionner à l'infini"), Material.ANVIL));
        gameScenarios.add(new GameScenario("HasteyBoys", Arrays.asList(ChatColor.GRAY + "Les outils ont automatiquement", ChatColor.GRAY + "l'enchantement éfficacité III"), Material.IRON_PICKAXE));
        gameScenarios.add(new GameScenario("No CleanUp", Arrays.asList(ChatColor.GRAY + "Quand un joueur fait un kill,", ChatColor.GRAY + "il obtient 2 coeurs d'absorption"), Material.GLISTERING_MELON_SLICE));
        gameScenarios.add(new GameScenario("NetherLess", Arrays.asList(ChatColor.GRAY + "Le nether est désactivé"), Material.LAVA_BUCKET));
        gameScenarios.add(new GameScenario("Underground", Arrays.asList(ChatColor.GRAY + "A l'activation du PVP, tous les", ChatColor.GRAY + "joueurs au dessus de la couche 40 perdront", ChatColor.GRAY + "1 coeur toutes les 30 sec"), Material.STONE));
        gameScenarios.add(new GameScenario("Netheribus", Arrays.asList(ChatColor.GRAY + "A l'activation du PVP, tous les", ChatColor.GRAY + "joueurs qui ne sont pas dans le nether perdront", ChatColor.GRAY + "1 coeur toutes les 15 sec"), Material.NETHERRACK));
        gameScenarios.add(new GameScenario("EnderPearl drop", Arrays.asList(ChatColor.GRAY + "A l'activation du PVP, toutes les", ChatColor.GRAY + "10 minutes, les joueurs", ChatColor.GRAY + "recevront une enderpearl"), Material.ENDER_PEARL));
        gameScenarios.add(new GameScenario("CatEyes", Arrays.asList(ChatColor.GRAY + "Les joueurs ont night vision infinie"), Material.ENDER_EYE));
        gameScenarios.add(new GameScenario("SwitchHeroes", Arrays.asList(ChatColor.GRAY + "Quand un joueur touche un autre à l'arc,", ChatColor.GRAY + "il a 10% de chance d'échanger sa place", ChatColor.GRAY + "avec celui-ci"), Material.CHORUS_FRUIT));
        gameScenarios.add(new GameScenario("BlockRush", Arrays.asList(ChatColor.GRAY + "Quand un joueur casse un bloc qui n'a jamais,", ChatColor.GRAY + "été cassé, il gagne un lingot d'or"), Material.GOLD_INGOT));
        gameScenarios.add(new GameScenario("Inventor Paranoia", Arrays.asList(ChatColor.GRAY + "Quand un joueur craft un item qui n'a,", ChatColor.GRAY + "jamais été crafté, ses coordonées sont révélées"), Material.CRAFTING_TABLE));
        gameScenarios.add(new GameScenario("Random start item", Arrays.asList(ChatColor.GRAY + "Au lancement, chaque joueur obtient", ChatColor.GRAY + "un objet aléatoire dans une quantité aléatoire"), Material.STICK));
        gameScenarios.add(new GameScenario("BowInfos", Arrays.asList(ChatColor.GRAY + "Quand un joueur touche un autre à l'arc,", ChatColor.GRAY + "il connaît sont pseudo et sa vie restante"), Material.ARROW));
        gameScenarios.add(new GameScenario("PlayersSwitch", Arrays.asList(ChatColor.GRAY + "Toutes les 5 minutes,", ChatColor.GRAY + "les joueurs voient leurs positions échangées"), Material.END_PORTAL_FRAME));
        gameScenarios.add(new GameScenario("FinalHeal", Arrays.asList(ChatColor.GRAY + "A l'activation du PVP, tous les", ChatColor.GRAY + "joueurs sont soignés"), Material.GOLDEN_APPLE));
        gameScenarios.add(new GameScenario("CoordinateDrops", Arrays.asList(ChatColor.GRAY + "Toutes les 5 minutes,", ChatColor.GRAY + "les coordonées des joueurs sont données"), Material.COMPASS));
        gameScenarios.add(new GameScenario("RandomCrafts", Arrays.asList(ChatColor.GRAY + "Tous les crafts sont mélangés"), Material.SUNFLOWER));
    }

    public boolean isScenarioActivate(String name){
        for(GameScenario gameScenario : this.gameScenarios){
            if(gameScenario.getName().equalsIgnoreCase(name)){
                return gameScenario.isActivated();
            }
        }
        return false;
    }

    private GameScenario getGameScenario(ItemStack it){
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
}

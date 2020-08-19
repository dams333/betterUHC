package ch.dams333.betterUHC;

import ch.dams333.betterUHC.commands.CommandsManager;
import ch.dams333.betterUHC.inventories.AdminInventoriesGenerator;
import ch.dams333.betterUHC.inventories.TeamInventoriesGenerator;
import ch.dams333.betterUHC.listener.ListenerManager;
import ch.dams333.betterUHC.objects.craft.CustomCraftManager;
import ch.dams333.betterUHC.objects.game.GameManager;
import ch.dams333.betterUHC.objects.game.GameVariables;
import ch.dams333.betterUHC.objects.gameStep.GameStepManager;
import ch.dams333.betterUHC.objects.scenarios.GameScenariosManager;
import ch.dams333.betterUHC.objects.teams.TeamsManager;
import ch.dams333.damsLib.DamsLIB;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BetterUHC extends JavaPlugin {

    public GameStepManager gameStepManager;
    public AdminInventoriesGenerator adminInventoriesGenerator;
    public GameVariables gameVariables;
    public CustomCraftManager customCraftManager;
    public GameManager gameManager;
    public TeamsManager teamsManager;
    public TeamInventoriesGenerator teamInventoriesGenerator;
    public GameScenariosManager gameScenariosManager;

    public static DamsLIB API;

    public List<UUID> diconnected;

    @Override
    public void onEnable(){

        diconnected = new ArrayList<>();

        API = (DamsLIB) getServer().getPluginManager().getPlugin("DamsLIB");

        this.gameStepManager = new GameStepManager();
        this.adminInventoriesGenerator = new AdminInventoriesGenerator(this);
        this.gameVariables = new GameVariables();
        this.customCraftManager = new CustomCraftManager(this);
        this.gameManager = new GameManager(this);
        this.teamsManager = new TeamsManager(this);
        this.teamInventoriesGenerator = new TeamInventoriesGenerator(this);
        this.gameScenariosManager = new GameScenariosManager(this);

        new ListenerManager(this);
        new CommandsManager(this);


        getServer().resetRecipes();

    }

    public void rejoin(Player p) {
        gameManager.rejoin(p);
    }
}

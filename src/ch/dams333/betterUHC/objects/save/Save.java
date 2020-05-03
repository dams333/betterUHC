package ch.dams333.betterUHC.objects.save;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.craft.CustomCraft;
import ch.dams333.betterUHC.objects.scenarios.GameScenario;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

public class Save {

    private String saveName;

    private int graceTime;
    private int pvpTime;
    private int borderTime;

    private List<ItemStack> startInventory;

    private boolean activateTeams;
    private boolean infiniteTeams;
    private int whiteTeam;
    private int orangeTeam;
    private int magentaTeam;
    private int lightBlueTeam;
    private int yellowTeam;
    private int limeTeam;
    private int pinkTeam;
    private int grayTeam;
    private int lightGrayTeam;
    private int cyanTeam;
    private int purpleTeam;
    private int blueTeam;
    private int brownTeam;
    private int greenTeam;
    private int redTeam;
    private int blackTeam;

    private int preBorder;
    private int postBorder;
    private int reductionTime;

    private Map<Material, Integer> itemsLimits;

    private int leatherLimit;
    private int ironLimit;
    private int chainLimit;
    private int goldLimit;
    private int diamondLimit;

    private int diamondProtecLimit;
    private int ironProteclimit;
    private int diamondSharpLimit;
    private int ironSharpLimit;

    private boolean globalChat;
    private boolean anonymGlobalChat;
    private boolean teamChat;
    private boolean anonymTeamChat;

    private boolean afficheTimers;
    private boolean afficheBorder;
    private boolean afficheKiller;
    private boolean afficheHealth;

    private List<GameScenario> gameScenarios;

    public List<GameScenario> getGameScenarios() {
        return gameScenarios;
    }

    public String getSaveName() {
        return saveName;
    }

    public int getGraceTime() {
        return graceTime;
    }

    public int getPvpTime() {
        return pvpTime;
    }

    public int getBorderTime() {
        return borderTime;
    }

    public List<ItemStack> getStartInventory() {
        return startInventory;
    }

    public boolean isActivateTeams() {
        return activateTeams;
    }

    public boolean isInfiniteTeams() {
        return infiniteTeams;
    }

    public int getWhiteTeam() {
        return whiteTeam;
    }

    public int getOrangeTeam() {
        return orangeTeam;
    }

    public int getMagentaTeam() {
        return magentaTeam;
    }

    public int getLightBlueTeam() {
        return lightBlueTeam;
    }

    public int getYellowTeam() {
        return yellowTeam;
    }

    public int getLimeTeam() {
        return limeTeam;
    }

    public int getPinkTeam() {
        return pinkTeam;
    }

    public int getGrayTeam() {
        return grayTeam;
    }

    public int getLightGrayTeam() {
        return lightGrayTeam;
    }

    public int getCyanTeam() {
        return cyanTeam;
    }

    public int getPurpleTeam() {
        return purpleTeam;
    }

    public int getBlueTeam() {
        return blueTeam;
    }

    public int getBrownTeam() {
        return brownTeam;
    }

    public int getGreenTeam() {
        return greenTeam;
    }

    public int getRedTeam() {
        return redTeam;
    }

    public int getBlackTeam() {
        return blackTeam;
    }

    public int getPreBorder() {
        return preBorder;
    }

    public int getPostBorder() {
        return postBorder;
    }

    public int getReductionTime() {
        return reductionTime;
    }

    public Map<Material, Integer> getItemsLimits() {
        return itemsLimits;
    }

    public int getLeatherLimit() {
        return leatherLimit;
    }

    public int getIronLimit() {
        return ironLimit;
    }

    public int getChainLimit() {
        return chainLimit;
    }

    public int getGoldLimit() {
        return goldLimit;
    }

    public int getDiamondLimit() {
        return diamondLimit;
    }

    public int getDiamondProtecLimit() {
        return diamondProtecLimit;
    }

    public int getIronProteclimit() {
        return ironProteclimit;
    }

    public int getDiamondSharpLimit() {
        return diamondSharpLimit;
    }

    public int getIronSharpLimit() {
        return ironSharpLimit;
    }

    public boolean isGlobalChat() {
        return globalChat;
    }

    public boolean isAnonymGlobalChat() {
        return anonymGlobalChat;
    }

    public boolean isTeamChat() {
        return teamChat;
    }

    public boolean isAnonymTeamChat() {
        return anonymTeamChat;
    }

    public boolean isAfficheTimers() {
        return afficheTimers;
    }

    public boolean isAfficheBorder() {
        return afficheBorder;
    }

    public boolean isAfficheKiller() {
        return afficheKiller;
    }

    public boolean isAfficheHealth() {
        return afficheHealth;
    }

    public List<CustomCraft> customCrafts;

    public List<CustomCraft> getCustomCrafts() {
        return customCrafts;
    }

    public Save(String saveName, int graceTime, int pvpTime, int borderTime, List<ItemStack> startInventory, boolean activateTeams, boolean infiniteTeams, int whiteTeam, int orangeTeam, int magentaTeam, int lightBlueTeam, int yellowTeam, int limeTeam, int pinkTeam, int grayTeam, int lightGrayTeam, int cyanTeam, int purpleTeam, int blueTeam, int brownTeam, int greenTeam, int redTeam, int blackTeam, int preBorder, int postBorder, int reductionTime, Map<Material, Integer> itemsLimits, int leatherLimit, int ironLimit, int chainLimit, int goldLimit, int diamondLimit, int diamondProtecLimit, int ironProteclimit, int diamondSharpLimit, int ironSharpLimit, boolean globalChat, boolean anonymGlobalChat, boolean teamChat, boolean anonymTeamChat, boolean afficheTimers, boolean afficheBorder, boolean afficheKiller, boolean afficheHealth, List<GameScenario> gameScenarios, List<CustomCraft> customCrafts) {
        this.graceTime = graceTime;
        this.pvpTime = pvpTime;
        this.borderTime = borderTime;
        this.startInventory = startInventory;
        this.activateTeams = activateTeams;
        this.infiniteTeams = infiniteTeams;
        this.whiteTeam = whiteTeam;
        this.orangeTeam = orangeTeam;
        this.magentaTeam = magentaTeam;
        this.lightBlueTeam = lightBlueTeam;
        this.yellowTeam = yellowTeam;
        this.limeTeam = limeTeam;
        this.pinkTeam = pinkTeam;
        this.grayTeam = grayTeam;
        this.lightGrayTeam = lightGrayTeam;
        this.cyanTeam = cyanTeam;
        this.purpleTeam = purpleTeam;
        this.blueTeam = blueTeam;
        this.brownTeam = brownTeam;
        this.greenTeam = greenTeam;
        this.redTeam = redTeam;
        this.blackTeam = blackTeam;
        this.preBorder = preBorder;
        this.postBorder = postBorder;
        this.reductionTime = reductionTime;
        this.itemsLimits = itemsLimits;
        this.leatherLimit = leatherLimit;
        this.ironLimit = ironLimit;
        this.chainLimit = chainLimit;
        this.goldLimit = goldLimit;
        this.diamondLimit = diamondLimit;
        this.diamondProtecLimit = diamondProtecLimit;
        this.ironProteclimit = ironProteclimit;
        this.diamondSharpLimit = diamondSharpLimit;
        this.ironSharpLimit = ironSharpLimit;
        this.globalChat = globalChat;
        this.anonymGlobalChat = anonymGlobalChat;
        this.teamChat = teamChat;
        this.anonymTeamChat = anonymTeamChat;
        this.afficheTimers = afficheTimers;
        this.afficheBorder = afficheBorder;
        this.afficheKiller = afficheKiller;
        this.afficheHealth = afficheHealth;
        this.saveName = saveName;
        this.gameScenarios = gameScenarios;
        this.customCrafts = customCrafts;
    }

    public void load(BetterUHC main) {

        main.gameVariables.graceTime = graceTime;
        main.gameVariables.pvpTime = pvpTime;
        main.gameVariables.borderTime = borderTime;
        main.gameVariables.startInventory = startInventory;
        main.gameVariables.activateTeams = activateTeams;
        main.gameVariables.infiniteTeams = infiniteTeams;
        main.gameVariables.whiteTeam = whiteTeam;
        main.gameVariables.orangeTeam = orangeTeam;
        main.gameVariables.magentaTeam = magentaTeam;
        main.gameVariables.lightBlueTeam = lightBlueTeam;
        main.gameVariables.yellowTeam = yellowTeam;
        main.gameVariables.limeTeam = limeTeam;
        main.gameVariables.pinkTeam = pinkTeam;
        main.gameVariables.grayTeam = grayTeam;
        main.gameVariables.lightGrayTeam = lightGrayTeam;
        main.gameVariables.cyanTeam = cyanTeam;
        main.gameVariables.purpleTeam = purpleTeam;
        main.gameVariables.blueTeam = blueTeam;
        main.gameVariables.brownTeam = brownTeam;
        main.gameVariables.greenTeam = greenTeam;
        main.gameVariables.redTeam = redTeam;
        main.gameVariables.blackTeam = blackTeam;
        main.gameVariables.preBorder = preBorder;
        main.gameVariables.postBorder = postBorder;
        main.gameVariables.reductionTime = reductionTime;
        main.gameVariables.itemsLimits = itemsLimits;
        main.gameVariables.leatherLimit = leatherLimit;
        main.gameVariables.ironLimit = ironLimit;
        main.gameVariables.chainLimit = chainLimit;
        main.gameVariables.goldLimit = goldLimit;
        main.gameVariables.diamondLimit = diamondLimit;
        main.gameVariables.diamondProtecLimit = diamondProtecLimit;
        main.gameVariables.ironProteclimit = ironProteclimit;
        main.gameVariables.diamondSharpLimit = diamondSharpLimit;
        main.gameVariables.ironSharpLimit = ironSharpLimit;
        main.gameVariables.globalChat = globalChat;
        main.gameVariables.anonymGlobalChat = anonymGlobalChat;
        main.gameVariables.teamChat = teamChat;
        main.gameVariables.anonymTeamChat = anonymTeamChat;
        main.gameVariables.afficheTimers = afficheTimers;
        main.gameVariables.afficheBorder = afficheBorder;
        main.gameVariables.afficheKiller = afficheKiller;
        main.gameVariables.afficheHealth = afficheHealth;
        main.gameScenariosManager.setScenarios(gameScenarios);
        main.customCraftManager.setCustomCrafts(customCrafts);
    }
}

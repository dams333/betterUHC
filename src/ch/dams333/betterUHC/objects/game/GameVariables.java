package ch.dams333.betterUHC.objects.game;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameVariables {

    public int graceTime;
    public int pvpTime;
    public int borderTime;

    public List<ItemStack> startInventory;

    public boolean activateTeams;
    public boolean infiniteTeams;
    public int whiteTeam;
    public int orangeTeam;
    public int magentaTeam;
    public int lightBlueTeam;
    public int yellowTeam;
    public int limeTeam;
    public int pinkTeam;
    public int grayTeam;
    public int lightGrayTeam;
    public int cyanTeam;
    public int purpleTeam;
    public int blueTeam;
    public int brownTeam;
    public int greenTeam;
    public int redTeam;
    public int blackTeam;

    public int preBorder;
    public int postBorder;
    public int reductionTime;

    public Map<Material, Integer> itemsLimits;

    public int leatherLimit;
    public int ironLimit;
    public int chainLimit;
    public int goldLimit;
    public int diamondLimit;

    public int diamondProtecLimit;
    public int ironProteclimit;
    public int diamondSharpLimit;
    public int ironSharpLimit;

    public boolean globalChat;
    public boolean anonymGlobalChat;
    public boolean teamChat;
    public boolean anonymTeamChat;

    public boolean afficheTimers;
    public boolean afficheBorder;
    public boolean afficheKiller;
    public boolean afficheHealth;

    public GameVariables() {
        graceTime = 60;
        pvpTime = 1200;
        borderTime = 3600;

        startInventory = new ArrayList<>();

        activateTeams = false;
        infiniteTeams = false;
        whiteTeam = 0;
        orangeTeam = 0;
        magentaTeam = 0;
        lightBlueTeam = 0;
        yellowTeam = 0;
        limeTeam = 0;
        pinkTeam = 0;
        grayTeam = 0;
        lightGrayTeam = 0;
        cyanTeam = 0;
        purpleTeam = 0;
        blueTeam = 0;
        brownTeam = 0;
        greenTeam = 0;
        redTeam = 0;
        blackTeam = 0;

        preBorder = 1000;
        postBorder = 50;
        reductionTime = 900;

        itemsLimits = new HashMap<>();

        leatherLimit = 4;
        ironLimit = 4;
        chainLimit  = 4;
        goldLimit = 4;
        diamondLimit = 4;

        diamondProtecLimit = 5;
        ironProteclimit = 5;
        diamondSharpLimit = 5;
        ironSharpLimit = 5;

        globalChat = true;
        teamChat = true;
        anonymGlobalChat = false;
        anonymTeamChat = false;

        afficheBorder = true;
        afficheHealth = true;
        afficheKiller = true;
        afficheTimers = true;
    }

    public String getTimeIntoString(int seconds){
        int sec = seconds % 60;
        int hour = seconds / 60;
        int min = hour % 60;
        hour = hour/60;

        String secSTR = "";
        String minSTR = "";
        String hourSTR = "";
        if(sec < 10){
            secSTR = "0" + String.valueOf(sec);
        }else{
            secSTR = String.valueOf(sec);
        }
        if(min < 10){
            minSTR = "0" + String.valueOf(min);
        }else{
            minSTR = String.valueOf(min);
        }
        if(hour < 10){
            hourSTR = "0" + String.valueOf(hour);
        }else{
            hourSTR = String.valueOf(hour);
        }

        return hourSTR + ":" + minSTR + ":" + secSTR;
    }

    public String getTimeIntoStringWithoutHour(int seconds){
        int min = (seconds % 3600) / 60;
        int sec = seconds % 60;

        String secSTR = "";
        String minSTR = "";
        if(sec < 10){
            secSTR = "0" + String.valueOf(sec);
        }else{
            secSTR = String.valueOf(sec);
        }
        if(min < 10){
            minSTR = "0" + String.valueOf(min);
        }else{
            minSTR = String.valueOf(min);
        }

        return minSTR + ":" + secSTR;
    }


}

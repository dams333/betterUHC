package ch.dams333.betterUHC.objects.teams;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TeamsManager {
    BetterUHC main;
    public List<Player> white;
    public List<Player> orange;
    public List<Player> magenta;
    public List<Player> lightblue;
    public List<Player> yellow;
    public List<Player> lime;
    public List<Player> pink;
    public List<Player> gray;
    public List<Player> lightgray;
    public List<Player> cyan;
    public List<Player> purple;
    public List<Player> blue;
    public List<Player> brown;
    public List<Player> green;
    public List<Player> red;
    public List<Player> black;

    public TeamsManager(BetterUHC betterUHC) {
        this.main = betterUHC;
        white = new ArrayList<>();
        orange = new ArrayList<>();
        magenta = new ArrayList<>();
        lightblue = new ArrayList<>();
        yellow = new ArrayList<>();
        lime = new ArrayList<>();
        pink = new ArrayList<>();
        gray = new ArrayList<>();
        lightgray = new ArrayList<>();
        cyan = new ArrayList<>();
        purple = new ArrayList<>();
        blue = new ArrayList<>();
        brown = new ArrayList<>();
        green = new ArrayList<>();
        red = new ArrayList<>();
        black = new ArrayList<>();
    }

    public void activateTeams() {
        for(Player p : Bukkit.getOnlinePlayers()){
            p.getInventory().setItem(0, main.API.itemStackManager.create(Material.WHITE_BANNER, ChatColor.GOLD + "Sélecteur d'équipe"));
        }
    }

    public void desactivateTeams() {
        for(Player p : Bukkit.getOnlinePlayers()){
            p.getInventory().setItem(0, null);
        }
    }

    public boolean isInTeam(Player p, String team){
        if(team.equalsIgnoreCase("white")) return white.contains(p);
        if(team.equalsIgnoreCase("orange")) return orange.contains(p);
        if(team.equalsIgnoreCase("magenta")) return magenta.contains(p);
        if(team.equalsIgnoreCase("lightblue")) return lightblue.contains(p);
        if(team.equalsIgnoreCase("yellow")) return yellow.contains(p);
        if(team.equalsIgnoreCase("lime")) return lime.contains(p);
        if(team.equalsIgnoreCase("pink")) return pink.contains(p);
        if(team.equalsIgnoreCase("gray")) return gray.contains(p);
        if(team.equalsIgnoreCase("lightgray")) return lightgray.contains(p);
        if(team.equalsIgnoreCase("cyan")) return cyan.contains(p);
        if(team.equalsIgnoreCase("purple")) return purple.contains(p);
        if(team.equalsIgnoreCase("blue")) return blue.contains(p);
        if(team.equalsIgnoreCase("brown")) return brown.contains(p);
        if(team.equalsIgnoreCase("green")) return green.contains(p);
        if(team.equalsIgnoreCase("red")) return red.contains(p);
        if(team.equalsIgnoreCase("black")) return black.contains(p);
        return false;
    }

    public boolean isInTeam(Player p){
        if(isInTeam(p, "white")) return true;
        if(isInTeam(p, "orange")) return true;
        if(isInTeam(p, "magenta")) return true;
        if(isInTeam(p, "lightblue")) return true;
        if(isInTeam(p, "yellow")) return true;
        if(isInTeam(p, "lime")) return true;
        if(isInTeam(p, "pink")) return true;
        if(isInTeam(p, "gray")) return true;
        if(isInTeam(p, "lightgray")) return true;
        if(isInTeam(p, "cyan")) return true;
        if(isInTeam(p, "purple")) return true;
        if(isInTeam(p, "blue")) return true;
        if(isInTeam(p, "brown")) return true;
        if(isInTeam(p, "green")) return true;
        if(isInTeam(p, "red")) return true;
        if(isInTeam(p, "black")) return true;
        return false;
    }

    public void removeFromTeam(Player p){
        if(isInTeam(p, "white")) white.remove(p);
        if(isInTeam(p, "orange")) orange.remove(p);
        if(isInTeam(p, "magenta")) magenta.remove(p);
        if(isInTeam(p, "lightblue")) lightblue.remove(p);
        if(isInTeam(p, "yellow")) yellow.remove(p);
        if(isInTeam(p, "lime")) lime.remove(p);
        if(isInTeam(p, "pink")) pink.remove(p);
        if(isInTeam(p, "gray")) gray.remove(p);
        if(isInTeam(p, "lightgray")) lightgray.remove(p);
        if(isInTeam(p, "cyan")) cyan.remove(p);
        if(isInTeam(p, "purple")) purple.remove(p);
        if(isInTeam(p, "blue")) blue.remove(p);
        if(isInTeam(p, "red")) red.remove(p);
        if(isInTeam(p, "black")) black.remove(p);
        if(isInTeam(p, "brown")) brown.remove(p);
        if(isInTeam(p, "green")) green.remove(p);
    }

    public void addInTeam(Player p, String team){
        if(team.equalsIgnoreCase("white")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                white.add(p);
                p.setDisplayName(ChatColor.WHITE + p.getName());
                p.setPlayerListName(ChatColor.WHITE + p.getName());
            }else{
                if(white.size() < main.gameVariables.whiteTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    white.add(p);
                    p.setDisplayName(ChatColor.WHITE + p.getName());
                    p.setPlayerListName(ChatColor.WHITE + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("orange")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                orange.add(p);
                p.setDisplayName(ChatColor.GOLD + p.getName());
                p.setPlayerListName(ChatColor.GOLD + p.getName());
            }else{
                if(orange.size() < main.gameVariables.orangeTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    orange.add(p);
                    p.setDisplayName(ChatColor.GOLD + p.getName());
                    p.setPlayerListName(ChatColor.GOLD + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("magenta")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                magenta.add(p);
                p.setDisplayName(ChatColor.DARK_RED + p.getName());
                p.setPlayerListName(ChatColor.DARK_RED + p.getName());
            }else{
                if(magenta.size() < main.gameVariables.magentaTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    magenta.add(p);
                    p.setDisplayName(ChatColor.DARK_RED + p.getName());
                    p.setPlayerListName(ChatColor.DARK_RED + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("lightblue")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                lightblue.add(p);
                p.setDisplayName(ChatColor.AQUA + p.getName());
                p.setPlayerListName(ChatColor.AQUA + p.getName());
            }else{
                if(lightblue.size() < main.gameVariables.lightBlueTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    lightblue.add(p);
                    p.setDisplayName(ChatColor.AQUA + p.getName());
                    p.setPlayerListName(ChatColor.AQUA + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("yellow")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                yellow.add(p);
                p.setDisplayName(ChatColor.YELLOW + p.getName());
                p.setPlayerListName(ChatColor.YELLOW + p.getName());
            }else{
                if(yellow.size() < main.gameVariables.yellowTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    yellow.add(p);
                    p.setDisplayName(ChatColor.YELLOW + p.getName());
                    p.setPlayerListName(ChatColor.YELLOW + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("lime")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                lime.add(p);
                p.setDisplayName(ChatColor.GREEN + p.getName());
                p.setPlayerListName(ChatColor.GREEN + p.getName());
            }else{
                if(lime.size() < main.gameVariables.limeTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    lime.add(p);
                    p.setDisplayName(ChatColor.GREEN + p.getName());
                    p.setPlayerListName(ChatColor.GREEN + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("pink")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                pink.add(p);
                p.setDisplayName(ChatColor.LIGHT_PURPLE + p.getName());
                p.setPlayerListName(ChatColor.LIGHT_PURPLE + p.getName());
            }else{
                if(pink.size() < main.gameVariables.pinkTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    pink.add(p);
                    p.setDisplayName(ChatColor.LIGHT_PURPLE + p.getName());
                    p.setPlayerListName(ChatColor.LIGHT_PURPLE + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("gray")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                gray.add(p);
                p.setDisplayName(ChatColor.DARK_GRAY + p.getName());
                p.setPlayerListName(ChatColor.DARK_GRAY + p.getName());
            }else{
                if(gray.size() < main.gameVariables.grayTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    gray.add(p);
                    p.setDisplayName(ChatColor.DARK_GRAY + p.getName());
                    p.setPlayerListName(ChatColor.DARK_GRAY + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("lightgray")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                lightgray.add(p);
                p.setDisplayName(ChatColor.GRAY + p.getName());
                p.setPlayerListName(ChatColor.GRAY + p.getName());
            }else{
                if(lightgray.size() < main.gameVariables.lightGrayTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    lightgray.add(p);
                    p.setDisplayName(ChatColor.GRAY + p.getName());
                    p.setPlayerListName(ChatColor.GRAY + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("cyan")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                cyan.add(p);
                p.setDisplayName(ChatColor.DARK_AQUA + p.getName());
                p.setPlayerListName(ChatColor.DARK_AQUA + p.getName());
            }else{
                if(cyan.size() < main.gameVariables.cyanTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    cyan.add(p);
                    p.setDisplayName(ChatColor.DARK_AQUA + p.getName());
                    p.setPlayerListName(ChatColor.DARK_AQUA + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("purple")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                purple.add(p);
                p.setDisplayName(ChatColor.DARK_PURPLE + p.getName());
                p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName());
            }else{
                if(purple.size() < main.gameVariables.purpleTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    purple.add(p);
                    p.setDisplayName(ChatColor.DARK_PURPLE + p.getName());
                    p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("blue")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                blue.add(p);
                p.setDisplayName(ChatColor.BLUE + p.getName());
                p.setPlayerListName(ChatColor.BLUE + p.getName());
            }else{
                if(blue.size() < main.gameVariables.blueTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    blue.add(p);
                    p.setDisplayName(ChatColor.BLUE + p.getName());
                    p.setPlayerListName(ChatColor.BLUE + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("brown")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                brown.add(p);
                p.setDisplayName(ChatColor.DARK_BLUE + p.getName());
                p.setPlayerListName(ChatColor.DARK_BLUE + p.getName());
            }else{
                if(brown.size() < main.gameVariables.brownTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    brown.add(p);
                    p.setDisplayName(ChatColor.DARK_BLUE + p.getName());
                    p.setPlayerListName(ChatColor.DARK_BLUE + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("green")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                green.add(p);
                p.setDisplayName(ChatColor.DARK_GREEN + p.getName());
                p.setPlayerListName(ChatColor.DARK_GREEN + p.getName());
            }else{
                if(green.size() < main.gameVariables.greenTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    green.add(p);
                    p.setDisplayName(ChatColor.DARK_GREEN + p.getName());
                    p.setPlayerListName(ChatColor.DARK_GREEN + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("red")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                red.add(p);
                p.setDisplayName(ChatColor.RED + p.getName());
                p.setPlayerListName(ChatColor.RED + p.getName());
            }else{
                if(red.size() < main.gameVariables.redTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    red.add(p);
                    p.setDisplayName(ChatColor.RED + p.getName());
                    p.setPlayerListName(ChatColor.RED + p.getName());
                }
            }
        }
        if(team.equalsIgnoreCase("black")){
            if(main.gameVariables.infiniteTeams){
                if(isInTeam(p)) removeFromTeam(p);
                black.add(p);
                p.setDisplayName(ChatColor.BLACK + p.getName());
                p.setPlayerListName(ChatColor.BLACK + p.getName());
            }else{
                if(black.size() < main.gameVariables.blackTeam) {
                    if (isInTeam(p)) removeFromTeam(p);
                    black.add(p);
                    p.setDisplayName(ChatColor.BLACK + p.getName());
                    p.setPlayerListName(ChatColor.BLACK + p.getName());
                }
            }
        }
    }

    public void joinTeam(Player p, Material mat) {
        if(mat == Material.WHITE_WOOL) addInTeam(p, "white");
        if(mat == Material.ORANGE_WOOL) addInTeam(p, "orange");
        if(mat == Material.MAGENTA_WOOL) addInTeam(p, "magenta");
        if(mat == Material.LIGHT_BLUE_WOOL) addInTeam(p, "lightblue");
        if(mat == Material.YELLOW_WOOL) addInTeam(p, "yellow");
        if(mat == Material.LIME_WOOL) addInTeam(p, "lime");
        if(mat == Material.PINK_WOOL) addInTeam(p, "pink");
        if(mat == Material.GRAY_WOOL) addInTeam(p, "gray");
        if(mat == Material.LIGHT_GRAY_WOOL) addInTeam(p, "lightgray");
        if(mat == Material.CYAN_WOOL) addInTeam(p, "cyan");
        if(mat == Material.PURPLE_WOOL) addInTeam(p, "purple");
        if(mat == Material.BLUE_WOOL) addInTeam(p, "blue");
        if(mat == Material.BROWN_WOOL) addInTeam(p, "brown");
        if(mat == Material.GREEN_WOOL) addInTeam(p, "green");
        if(mat == Material.RED_WOOL) addInTeam(p, "red");
        if(mat == Material.BLACK_WOOL) addInTeam(p, "black");
    }
}

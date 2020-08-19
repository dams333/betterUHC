package ch.dams333.betterUHC.objects.teams;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class TeamsManager {

    private BetterUHC main;
    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public TeamsManager(BetterUHC main) {
        this.main = main;
        teams = new ArrayList<>();


        teams.add(new Team(false, "Rouge ♥", ChatColor.RED, Material.RED_BANNER));
        teams.add(new Team(false, "Dorée ♥", ChatColor.GOLD, Material.ORANGE_BANNER));
        teams.add(new Team(false, "Jaune ♥", ChatColor.YELLOW, Material.YELLOW_BANNER));
        teams.add(new Team(false, "Verte claire ♥", ChatColor.GREEN, Material.LIME_BANNER));
        teams.add(new Team(false, "Verte ♥", ChatColor.DARK_GREEN, Material.GREEN_BANNER));
        teams.add(new Team(false, "Bleue claire ♥", ChatColor.AQUA, Material.CYAN_BANNER));
        teams.add(new Team(false, "Bleue ♥", ChatColor.DARK_AQUA, Material.LIGHT_BLUE_BANNER));
        teams.add(new Team(false, "Bleue foncée ♥", ChatColor.BLUE, Material.BLUE_BANNER));
        teams.add(new Team(false, "Rose ♥", ChatColor.LIGHT_PURPLE, Material.PINK_BANNER));
        teams.add(new Team(false, "Violette ♥", ChatColor.DARK_PURPLE, Material.MAGENTA_BANNER));
        teams.add(new Team(false, "Blanche ♥", ChatColor.WHITE, Material.WHITE_BANNER));
        teams.add(new Team(false, "Grise ♥", ChatColor.DARK_GRAY, Material.GRAY_BANNER));
        teams.add(new Team(false, "Grise claire ♥", ChatColor.GRAY, Material.LIGHT_GRAY_BANNER));

        teams.add(new Team(false, "Rouge ★", ChatColor.RED, Material.RED_BANNER));
        teams.add(new Team(false, "Dorée ★", ChatColor.GOLD, Material.ORANGE_BANNER));
        teams.add(new Team(false, "Jaune ★", ChatColor.YELLOW, Material.YELLOW_BANNER));
        teams.add(new Team(false, "Verte claire ★", ChatColor.GREEN, Material.LIME_BANNER));
        teams.add(new Team(false, "Verte ★", ChatColor.DARK_GREEN, Material.GREEN_BANNER));
        teams.add(new Team(false, "Bleue claire ★", ChatColor.AQUA, Material.CYAN_BANNER));
        teams.add(new Team(false, "Bleue ★", ChatColor.DARK_AQUA, Material.LIGHT_BLUE_BANNER));
        teams.add(new Team(false, "Bleue foncée ★", ChatColor.BLUE, Material.BLUE_BANNER));
        teams.add(new Team(false, "Rose ★", ChatColor.LIGHT_PURPLE, Material.PINK_BANNER));
        teams.add(new Team(false, "Violette ★", ChatColor.DARK_PURPLE, Material.MAGENTA_BANNER));
        teams.add(new Team(false, "Blanche ★", ChatColor.WHITE, Material.WHITE_BANNER));
        teams.add(new Team(false, "Grise ★", ChatColor.DARK_GRAY, Material.GRAY_BANNER));
        teams.add(new Team(false, "Grise claire ★", ChatColor.GRAY, Material.LIGHT_GRAY_BANNER));

        teams.add(new Team(false, "Rouge ♫", ChatColor.RED, Material.RED_BANNER));
        teams.add(new Team(false, "Dorée ♫", ChatColor.GOLD, Material.ORANGE_BANNER));
        teams.add(new Team(false, "Jaune ♫", ChatColor.YELLOW, Material.YELLOW_BANNER));
        teams.add(new Team(false, "Verte claire ♫", ChatColor.GREEN, Material.LIME_BANNER));
        teams.add(new Team(false, "Verte ♫", ChatColor.DARK_GREEN, Material.GREEN_BANNER));
        teams.add(new Team(false, "Bleue claire ♫", ChatColor.AQUA, Material.CYAN_BANNER));
        teams.add(new Team(false, "Bleue ♫", ChatColor.DARK_AQUA, Material.LIGHT_BLUE_BANNER));
        teams.add(new Team(false, "Bleue foncée ♫", ChatColor.BLUE, Material.BLUE_BANNER));
        teams.add(new Team(false, "Rose ♫", ChatColor.LIGHT_PURPLE, Material.PINK_BANNER));
        teams.add(new Team(false, "Violette ♫", ChatColor.DARK_PURPLE, Material.MAGENTA_BANNER));
        teams.add(new Team(false, "Blanche ♫", ChatColor.WHITE, Material.WHITE_BANNER));
        teams.add(new Team(false, "Grise ♫", ChatColor.DARK_GRAY, Material.GRAY_BANNER));
        teams.add(new Team(false, "Grise claire ♫", ChatColor.GRAY, Material.LIGHT_GRAY_BANNER));

        teams.add(new Team(false, "Rouge ☺", ChatColor.RED, Material.RED_BANNER));
        teams.add(new Team(false, "Dorée ☺", ChatColor.GOLD, Material.ORANGE_BANNER));
        teams.add(new Team(false, "Jaune ☺", ChatColor.YELLOW, Material.YELLOW_BANNER));
        teams.add(new Team(false, "Verte claire ☺", ChatColor.GREEN, Material.LIME_BANNER));
        teams.add(new Team(false, "Verte ☺", ChatColor.DARK_GREEN, Material.GREEN_BANNER));
        teams.add(new Team(false, "Bleue claire ☺", ChatColor.AQUA, Material.CYAN_BANNER));
        teams.add(new Team(false, "Bleue ☺", ChatColor.DARK_AQUA, Material.LIGHT_BLUE_BANNER));
        teams.add(new Team(false, "Bleue foncée ☺", ChatColor.BLUE, Material.BLUE_BANNER));
        teams.add(new Team(false, "Rose ☺", ChatColor.LIGHT_PURPLE, Material.PINK_BANNER));
        teams.add(new Team(false, "Violette ☺", ChatColor.DARK_PURPLE, Material.MAGENTA_BANNER));
        teams.add(new Team(false, "Blanche ☺", ChatColor.WHITE, Material.WHITE_BANNER));

    }

    public void switchTeam(String displayName) {
        for(Team team : this.teams){
            if((team.getChatColor() + team.getName()).equals(displayName) || team.getName().equals(displayName)){
                int index = this.teams.indexOf(team);
                team.switchActivate();
                this.teams.set(index, team);
                return;
            }
        }
    }

    public int getActivateTeams() {
        int activate = 0;
        for(Team team : this.teams){
            if(team.isActivated()){
                activate += 1;
            }
        }
        return activate;
    }

    public boolean isInTeam(Player p) {
        for(Team team : this.teams){
            if(team.getPlayers().contains(p)){
                return true;
            }
        }
        return false;
    }

    public ItemStack getTeamBanner(Player p) {
        for(Team team : this.teams){
            if(team.getPlayers().contains(p)){
                return new ItemStack(team.getBanner());
            }
        }
        return null;
    }

    public void chooseTeam(String displayName, Player p) {
        if(isInTeam(p)){
            for(Team team : this.teams){
                if(team.getPlayers().contains(p)){
                    int index = this.teams.indexOf(team);
                    team.removePlayer(p);
                    this.teams.set(index, team);
                    break;
                }
            }
        }

        for(Team team : this.teams) {
            if ((team.getChatColor() + team.getName()).equals(displayName) || team.getName().equals(displayName)) {
                int index = this.teams.indexOf(team);
                team.addPlayer(p);
                this.teams.set(index, team);

                p.setDisplayName(team.getChatColor() + team.getSymbol() + " " + p.getName());
                p.setPlayerListName(team.getChatColor() + team.getSymbol() + " " + p.getName());

                break;
            }
        }
    }

    public void removePlayer(Player p) {
        for(Team team : this.teams){
            if(team.getPlayers().contains(p)){
                int index = this.teams.indexOf(team);
                team.removePlayer(p);
                this.teams.set(index, team);
            }
        }
    }

    public void reco(Player p) {
        for(Team team : this.teams){
            for(Player pl : team.getPlayers()){
                if(pl.getUniqueId().equals(p.getUniqueId())){
                    int index = this.teams.indexOf(team);
                    team.removePlayer(pl);
                    team.addPlayer(p);
                    this.teams.set(index, team);
                    return;
                }
            }
        }
    }
}

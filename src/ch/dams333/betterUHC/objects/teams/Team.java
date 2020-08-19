package ch.dams333.betterUHC.objects.teams;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private boolean activated;
    private String name;
    private ChatColor chatColor;
    private Material banner;
    private List<Player> players;

    public boolean isActivated() {
        return activated;
    }

    public String getName() {
        return name;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public Material getBanner() {
        return banner;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player p ){
        this.players.add(p);
    }

    public void removePlayer(Player p){
        this.players.remove(p);
    }

    public String getSymbol(){
        return name.substring(name.length() - 1);
    }

    public Team(boolean activated, String name, ChatColor chatColor, Material banner) {

        this.activated = activated;
        this.name = name;
        this.chatColor = chatColor;
        this.banner = banner;
        this.players = new ArrayList<>();
    }

    public void switchActivate() {
        this.activated = !this.activated;
    }
}

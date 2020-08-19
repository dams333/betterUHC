package ch.dams333.betterUHC.listener.chat;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.teams.Team;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {
    BetterUHC main;
    public ChatEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void chat(AsyncPlayerChatEvent e){
            e.setCancelled(true);
            if (main.teamsManager.getActivateTeams() == 0) {
                if(main.gameVariables.globalChat) {
                    if (!main.gameVariables.anonymGlobalChat) {
                        Bukkit.broadcastMessage(e.getPlayer().getDisplayName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                    } else {
                        StringBuilder name = new StringBuilder(ChatColor.MAGIC + "");
                        for (int i = 1; i < main.API.random(5, 12); i++) {
                            name.append("a");
                        }
                        Bukkit.broadcastMessage(name.toString() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                    }
                }
            } else {
                if (main.gameVariables.globalChat && !main.gameVariables.teamChat) {
                    if(!main.gameVariables.anonymGlobalChat) {
                        Bukkit.broadcastMessage(e.getPlayer().getDisplayName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                    }else{
                        StringBuilder name = new StringBuilder(ChatColor.MAGIC + "");
                        for(int i = 1; i < main.API.random(4, 8); i++){
                            name.append("a");
                        }
                        Bukkit.broadcastMessage(name.toString() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                    }
                }
                if (main.gameVariables.globalChat && main.gameVariables.teamChat) {
                    if (e.getMessage().startsWith("!")) {
                        if (!main.gameVariables.anonymGlobalChat) {
                            Bukkit.broadcastMessage(e.getPlayer().getDisplayName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage().replaceFirst("!", ""));
                        } else {
                            StringBuilder name = new StringBuilder(ChatColor.MAGIC + "");
                            for (int i = 1; i < main.API.random(4, 8); i++) {
                                name.append("a");
                            }
                            Bukkit.broadcastMessage(name.toString() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage().replaceFirst("!", ""));
                        }
                    } else {
                        for (Team team : main.teamsManager.getTeams()) {
                            if (team.getPlayers().contains(e.getPlayer())) {
                                for (Player p : team.getPlayers()) {
                                    p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                                }
                            }
                        }
                    }
                    if (!main.gameVariables.globalChat && main.gameVariables.teamChat) {
                        for (Team team : main.teamsManager.getTeams()) {
                            if (team.getPlayers().contains(e.getPlayer())) {
                                for (Player p : team.getPlayers()) {
                                    p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                                }
                            }
                        }
                    }
                }
            }
        }

}

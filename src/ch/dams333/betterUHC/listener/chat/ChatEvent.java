package ch.dams333.betterUHC.listener.chat;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.gameStep.GameStep;
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
        if(main.gameStepManager.isStep(GameStep.GAME)) {
            e.setCancelled(true);
            if (!main.gameVariables.activateTeams) {
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
                        if(!main.gameVariables.anonymGlobalChat) {
                            Bukkit.broadcastMessage(e.getPlayer().getDisplayName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage().replaceFirst("!", ""));
                        }else{
                            StringBuilder name = new StringBuilder(ChatColor.MAGIC + "");
                            for(int i = 1; i < main.API.random(4, 8); i++){
                                name.append("a");
                            }
                            Bukkit.broadcastMessage(name.toString() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage().replaceFirst("!", ""));
                        }
                    } else {
                        if(main.teamsManager.isInTeam(e.getPlayer(), "white")){
                            for(Player p : main.teamsManager.white){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        }
                        if(main.teamsManager.isInTeam(e.getPlayer(), "orange")){
                            for(Player p : main.teamsManager.orange){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        }
                        if(main.teamsManager.isInTeam(e.getPlayer(), "magenta")){
                            for(Player p : main.teamsManager.magenta){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        }
                        if(main.teamsManager.isInTeam(e.getPlayer(), "lightblue")){
                            for(Player p : main.teamsManager.lightblue){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        }
                        if(main.teamsManager.isInTeam(e.getPlayer(), "lime")){
                            for(Player p : main.teamsManager.lime){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        }
                        if(main.teamsManager.isInTeam(e.getPlayer(), "pink")){
                            for(Player p : main.teamsManager.pink){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        } if(main.teamsManager.isInTeam(e.getPlayer(), "gray")){
                            for(Player p : main.teamsManager.gray){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        } if(main.teamsManager.isInTeam(e.getPlayer(), "lightgray")){
                            for(Player p : main.teamsManager.lightgray){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        } if(main.teamsManager.isInTeam(e.getPlayer(), "cyan")){
                            for(Player p : main.teamsManager.cyan){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        } if(main.teamsManager.isInTeam(e.getPlayer(), "purple")){
                            for(Player p : main.teamsManager.purple){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        } if(main.teamsManager.isInTeam(e.getPlayer(), "blue")){
                            for(Player p : main.teamsManager.blue){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        } if(main.teamsManager.isInTeam(e.getPlayer(), "brown")){
                            for(Player p : main.teamsManager.brown){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        } if(main.teamsManager.isInTeam(e.getPlayer(), "green")){
                            for(Player p : main.teamsManager.green){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        } if(main.teamsManager.isInTeam(e.getPlayer(), "red")){
                            for(Player p : main.teamsManager.red){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        } if(main.teamsManager.isInTeam(e.getPlayer(), "black")){
                            for(Player p : main.teamsManager.black){
                                p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                            }
                        }
                    }
                }
                if (!main.gameVariables.globalChat && main.gameVariables.teamChat) {
                    if(main.teamsManager.isInTeam(e.getPlayer(), "white")){
                        for(Player p : main.teamsManager.white){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    }
                    if(main.teamsManager.isInTeam(e.getPlayer(), "orange")){
                        for(Player p : main.teamsManager.orange){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    }
                    if(main.teamsManager.isInTeam(e.getPlayer(), "magenta")){
                        for(Player p : main.teamsManager.magenta){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    }
                    if(main.teamsManager.isInTeam(e.getPlayer(), "lightblue")){
                        for(Player p : main.teamsManager.lightblue){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    }
                    if(main.teamsManager.isInTeam(e.getPlayer(), "lime")){
                        for(Player p : main.teamsManager.lime){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    }
                    if(main.teamsManager.isInTeam(e.getPlayer(), "pink")){
                        for(Player p : main.teamsManager.pink){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    } if(main.teamsManager.isInTeam(e.getPlayer(), "gray")){
                        for(Player p : main.teamsManager.gray){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    } if(main.teamsManager.isInTeam(e.getPlayer(), "lightgray")){
                        for(Player p : main.teamsManager.lightgray){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    } if(main.teamsManager.isInTeam(e.getPlayer(), "cyan")){
                        for(Player p : main.teamsManager.cyan){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    } if(main.teamsManager.isInTeam(e.getPlayer(), "purple")){
                        for(Player p : main.teamsManager.purple){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    } if(main.teamsManager.isInTeam(e.getPlayer(), "blue")){
                        for(Player p : main.teamsManager.blue){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    } if(main.teamsManager.isInTeam(e.getPlayer(), "brown")){
                        for(Player p : main.teamsManager.brown){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    } if(main.teamsManager.isInTeam(e.getPlayer(), "green")){
                        for(Player p : main.teamsManager.green){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    } if(main.teamsManager.isInTeam(e.getPlayer(), "red")){
                        for(Player p : main.teamsManager.red){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    } if(main.teamsManager.isInTeam(e.getPlayer(), "black")){
                        for(Player p : main.teamsManager.black){
                            p.sendMessage(ChatColor.GOLD + "[Equipe] " + ChatColor.WHITE + e.getPlayer().getName() + ChatColor.GOLD + " > " + ChatColor.GRAY + e.getMessage());
                        }
                    }
                }
            }
        }
    }

}

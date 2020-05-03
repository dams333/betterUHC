package ch.dams333.betterUHC.commands.command;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReviveCommand implements CommandExecutor {
    BetterUHC main;
    public ReviveCommand(BetterUHC main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            if(args.length == 1){
                String pseudo = args[0];
                if(Bukkit.getPlayer(pseudo) != null){
                    if(main.gameManager.death.containsKey(Bukkit.getPlayer(pseudo))){
                        Player p = Bukkit.getPlayer(pseudo);
                        main.gameManager.revive.add(p);
                        Location tp = main.gameManager.death.get(p);
                        tp.setY(250);
                        p.teleport(tp);
                        main.gameManager.inGamePlayers.add(p);
                        main.gameManager.death.remove(p);
                        p.setGameMode(GameMode.SURVIVAL);
                        p.setHealth(p.getMaxHealth());
                        p.setFoodLevel(20);
                        p.sendMessage(ChatColor.LIGHT_PURPLE + "Vous avez été revive");
                        sender.sendMessage(ChatColor.GREEN + pseudo + " a été revive");
                        return true;
                    }
                    sender.sendMessage(ChatColor.RED + pseudo + " n'est pas mort");
                    return true;
                }
                sender.sendMessage(ChatColor.RED + pseudo + " n'est pas en ligne");
                return true;
            }
            sender.sendMessage(ChatColor.RED + "/revive <pseudo>");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Il faut être connecté sur le serveur pour faire cela");
        return false;
    }
}

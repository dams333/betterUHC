package ch.dams333.betterUHC.commands.command;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    BetterUHC main;
    public HealCommand(BetterUHC main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            for(Player p : Bukkit.getOnlinePlayers()){
                p.setHealth(p.getMaxHealth());
            }
            sender.sendMessage(ChatColor.GREEN + "Tout le monde a été soigné");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Il faut être connecté sur le serveur pour faire cela");
        return false;
    }
}

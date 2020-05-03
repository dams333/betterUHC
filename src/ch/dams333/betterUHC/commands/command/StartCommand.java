package ch.dams333.betterUHC.commands.command;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.gameStep.GameStep;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {
    BetterUHC main;
    public StartCommand(BetterUHC main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(main.gameStepManager.isStep(GameStep.PREGAME)){
                main.gameManager.startGame();
                return true;
            }
            p.sendMessage(ChatColor.RED + "Ce n'est pas le moment de démarrer la partie");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Il faut être connecté sur le serveur");
        return false;
    }
}

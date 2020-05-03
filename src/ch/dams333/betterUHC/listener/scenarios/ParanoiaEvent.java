package ch.dams333.betterUHC.listener.scenarios;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ParanoiaEvent implements Listener {
    BetterUHC main;
    public ParanoiaEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void paranoia(BlockBreakEvent e){
        if(main.gameScenariosManager.isScenarioActivate("paranoia")){
            if(e.isCancelled()) return;
            if(e.getBlock().getType() == Material.DIAMOND_ORE){
                Bukkit.broadcastMessage(e.getPlayer().getDisplayName() + ChatColor.GRAY + " a miné du " + ChatColor.AQUA + "diamant " + ChatColor.GRAY + "en x=" + ChatColor.RED + Math.round(e.getPlayer().getLocation().getX()) + ChatColor.GRAY + ", y=" + ChatColor.RED + Math.round(e.getPlayer().getLocation().getY())+ ChatColor.GRAY + ", z=" + ChatColor.RED + Math.round(e.getPlayer().getLocation().getZ()));
            }
            if(e.getBlock().getType() == Material.GOLD_ORE){
                Bukkit.broadcastMessage(e.getPlayer().getDisplayName() + ChatColor.GRAY + " a miné de l'" + ChatColor.YELLOW + "or " + ChatColor.GRAY + "en x=" + ChatColor.RED + Math.round(e.getPlayer().getLocation().getX()) + ChatColor.GRAY + ", y=" + ChatColor.RED + Math.round(e.getPlayer().getLocation().getY())+ ChatColor.GRAY + ", z=" + ChatColor.RED + Math.round(e.getPlayer().getLocation().getZ()));
            }
        }
    }

}

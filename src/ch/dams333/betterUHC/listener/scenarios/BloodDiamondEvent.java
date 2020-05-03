package ch.dams333.betterUHC.listener.scenarios;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BloodDiamondEvent implements Listener {
    BetterUHC main;
    public BloodDiamondEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void breck(BlockBreakEvent e){
        if(main.gameScenariosManager.isScenarioActivate("blood diamond")) {
            Player p = e.getPlayer();
            if(e.isCancelled()) return;
            if (e.getBlock().getType() == Material.DIAMOND_ORE) {
                if (p.getHealth() > 1) {
                    p.setHealth(p.getHealth() - 1);
                } else {
                    e.setCancelled(true);
                    p.sendMessage(ChatColor.RED + "Cela vous tuerait");
                }
            }
        }
    }

}

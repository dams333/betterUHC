package ch.dams333.betterUHC.listener.scenarios;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class NetherLessEvent implements Listener {
    BetterUHC main;
    public NetherLessEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void changeDimension(PlayerTeleportEvent e){
        if(main.gameScenariosManager.isScenarioActivate("netherless")){
            if(e.getTo().getWorld().getName().equalsIgnoreCase("world_nether")){
                e.setCancelled(true);
            }
        }
    }

}

package ch.dams333.betterUHC.listener.spawn;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitiesSpawnEvent implements Listener {
    BetterUHC main;
    public EntitiesSpawnEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void spawn(EntitySpawnEvent e){
        if(e.getEntity().getType() == EntityType.PHANTOM){
            e.setCancelled(true);
        }
    }

}

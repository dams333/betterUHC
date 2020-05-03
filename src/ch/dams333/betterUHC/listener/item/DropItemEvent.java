package ch.dams333.betterUHC.listener.item;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.gameStep.GameStep;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItemEvent implements Listener {
    BetterUHC main;
    public DropItemEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void dropItem(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        if(main.gameStepManager.isStep(GameStep.PREGAME)){
            e.setCancelled(true);
        }
    }
}

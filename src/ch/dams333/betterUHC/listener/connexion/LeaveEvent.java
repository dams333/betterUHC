package ch.dams333.betterUHC.listener.connexion;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {
    BetterUHC main;
    public LeaveEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void leave(PlayerQuitEvent e){
        if(main.gameManager.inGamePlayers.contains(e.getPlayer())){
            main.diconnected.add(e.getPlayer().getUniqueId());
        }
    }

}

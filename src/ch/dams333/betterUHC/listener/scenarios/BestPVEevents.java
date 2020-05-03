package ch.dams333.betterUHC.listener.scenarios;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class BestPVEevents implements Listener {
    BetterUHC main;
    public BestPVEevents(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void damage(EntityDamageEvent e){
        if(e.isCancelled()) return;
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            if(main.gameScenariosManager.isScenarioActivate("best pve")){
                if(main.gameManager.bestPVE.contains(p)){
                    main.gameManager.bestPVE.remove(p);
                }
            }
        }
    }

    @EventHandler
    public void damagebyEntity(EntityDamageByEntityEvent e){
        if(e.isCancelled()) return;
        if(e.getEntity() instanceof Player && !(e.getDamager() instanceof Player)){
            Player p = (Player) e.getEntity();
            if(main.gameScenariosManager.isScenarioActivate("best pve")){
                if(main.gameManager.bestPVE.contains(p)){
                    main.gameManager.bestPVE.remove(p);
                }
            }
        }
    }

}

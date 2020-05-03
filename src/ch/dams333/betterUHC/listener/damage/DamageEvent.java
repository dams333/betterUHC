package ch.dams333.betterUHC.listener.damage;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.gameStep.GameStep;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent implements Listener {
    BetterUHC main;
    public DamageEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void damage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (main.gameStepManager.isStep(GameStep.PREGAME)) {
                e.setCancelled(true);
            }else{
                if(main.gameManager.revive.contains(p)){
                    main.gameManager.revive.remove(p);
                    if(e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                        e.setCancelled(true);
                    }
                }else {
                    if (main.gameManager.getGameTime() < main.gameVariables.graceTime) {
                        e.setCancelled(true);
                    } else {
                        if (main.gameManager.noFall.contains(p)) {
                            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                                e.setCancelled(true);
                            }
                        }else {
                            if(e.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                                if (p.getHealth() <= e.getFinalDamage()) {
                                    e.setCancelled(true);
                                    main.gameManager.killPlayer(p);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

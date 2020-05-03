package ch.dams333.betterUHC.listener.damage;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.gameStep.GameStep;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageByEntityEvent implements Listener {
    BetterUHC main;
    public DamageByEntityEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void damageEntity(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (main.gameStepManager.isStep(GameStep.PREGAME)) {
                e.setCancelled(true);
            }else{
                if(main.gameManager.getGameTime() < main.gameVariables.graceTime){
                    e.setCancelled(true);
                }else{
                    if(e.getDamager() instanceof Player){
                        Player damager = (Player) e.getDamager();
                        if(main.gameManager.getGameTime() < main.gameVariables.pvpTime){
                            e.setCancelled(true);
                        }
                        if(p.getHealth() <= e.getFinalDamage()){
                            e.setCancelled(true);
                            main.gameManager.killPlayerByPlayer(p, damager);
                        }
                    }else{
                        if (e.getDamager() instanceof Arrow) {
                            if (e.getEntity() instanceof Player) {
                                if (((Arrow) e.getDamager()).getShooter() instanceof Player) {
                                    if (((Player) e.getEntity()).getHealth() <= e.getFinalDamage()) {
                                        Player shooted = (Player) e.getEntity();
                                        Player shooter = (Player) ((Arrow) e.getDamager()).getShooter();
                                        e.setCancelled(true);
                                        main.gameManager.killPlayerByPlayer(shooted, shooter);
                                    }
                                }
                            }
                        }else {
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

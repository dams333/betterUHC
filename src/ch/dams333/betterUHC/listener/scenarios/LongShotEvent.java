package ch.dams333.betterUHC.listener.scenarios;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class LongShotEvent implements Listener {
    BetterUHC main;
    public LongShotEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void shoot(EntityDamageByEntityEvent e){
        if(main.gameScenariosManager.isScenarioActivate("longshot")) {
            if (e.getDamager() instanceof Arrow){
                if(e.getEntity() instanceof Player){
                    if(((Arrow) e.getDamager()).getShooter() instanceof Player){
                        Player shooted = (Player) e.getEntity();
                        Player shooter = (Player) ((Arrow) e.getDamager()).getShooter();
                        if(shooted.getLocation().distance(shooter.getLocation()) >= 75){
                            Bukkit.broadcastMessage(shooter.getDisplayName() + ChatColor.GREEN + " a fait un longshot de " + shooted.getLocation().distance(shooter.getLocation()) + " blocs");
                            if(shooter.getHealth() <= (shooter.getMaxHealth() - 2)){
                                shooter.setHealth(shooter.getHealth() + 2);
                            }else{
                                shooter.setHealth(shooter.getMaxHealth());
                            }
                        }
                    }
                }
            }
        }
        if(main.gameScenariosManager.isScenarioActivate("switchheroes")) {
            if (e.getDamager() instanceof Arrow){
                if(e.getEntity() instanceof Player){
                    if(((Arrow) e.getDamager()).getShooter() instanceof Player){
                        Player shooted = (Player) e.getEntity();
                        Player shooter = (Player) ((Arrow) e.getDamager()).getShooter();
                        if(main.API.random(1, 100) <= 10){
                            Location tp1 = shooted.getLocation();
                            Location tp2 = shooter.getLocation();
                            shooted.teleport(tp2);
                            shooter.teleport(tp1);
                        }
                    }
                }
            }
        }
        if(main.gameScenariosManager.isScenarioActivate("bowinfos")) {
            if(!e.isCancelled()) {
                if (e.getDamager() instanceof Arrow) {
                    if (e.getEntity() instanceof Player) {
                        if (((Arrow) e.getDamager()).getShooter() instanceof Player) {
                            Player shooted = (Player) e.getEntity();
                            Player shooter = (Player) ((Arrow) e.getDamager()).getShooter();
                            shooter.sendMessage(ChatColor.GOLD + "Tu as touché " + shooted.getDisplayName() + ChatColor.GOLD + ", il lui reste " + ChatColor.RED + String.valueOf(shooted.getHealth() - e.getFinalDamage()) + "❤");
                        }
                    }
                }
            }
        }
    }

}

package ch.dams333.betterUHC.listener.connexion;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.gameStep.GameStep;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;

public class JoinEvent implements Listener {
    BetterUHC main;
    public JoinEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.getAttribute(org.bukkit.attribute.Attribute.GENERIC_ATTACK_SPEED).setBaseValue(16.0D);

        if(main.diconnected.contains(p.getUniqueId())){
            main.diconnected.remove(p.getUniqueId());

            main.rejoin(p);
        }

        if(main.gameStepManager.isStep(GameStep.PREGAME)){
            if(new Location(Bukkit.getWorld("world"), 0, 149, 0).getBlock().getType() != Material.BARRIER){
                for(int x = -25; x < 25; x++){
                    for(int z = -25; z < 25; z++){
                        new Location(Bukkit.getWorld("world"), x, 149, z).getBlock().setType(Material.BARRIER);
                    }
                }
            }
            p.setMaxHealth(20);
            p.setHealth(20);
            p.setFoodLevel(20);
            p.getInventory().clear();
            p.teleport(new Location(Bukkit.getWorld("world"), 0, 150, 0));
            p.setLevel(0);

            for(PotionEffect potionEffect : p.getActivePotionEffects()){
                p.removePotionEffect(potionEffect.getType());
            }

            if(main.teamsManager.getActivateTeams() > 0){
                p.getInventory().setItem(0, main.API.itemStackManager.create(Material.WHITE_BANNER, ChatColor.GOLD + "Sélecteur d'équipe"));
            }
            if(!p.hasPermission("betterUHC.admin")) {
                p.setGameMode(GameMode.ADVENTURE);
            }else{
                p.setGameMode(GameMode.CREATIVE);
                p.getInventory().setItem(4, main.API.itemStackManager.create(Material.BOOK, ChatColor.LIGHT_PURPLE + "Configuration de la partie"));
            }
        }else{
            p.setGameMode(GameMode.SPECTATOR);
            p.teleport(new Location(Bukkit.getWorld("world"), 0, 150, 0));
        }

    }

}

package ch.dams333.betterUHC.listener.actions;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ClickOnItemEvent implements Listener {
    BetterUHC main;
    public ClickOnItemEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void interact(PlayerInteractEvent e){
        Player p = e.getPlayer();
        ItemStack it = e.getItem();
        Action action = e.getAction();

        if(it != null && it.getType() != Material.AIR){
            if(it.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Configuration de la partie")){
                main.adminInventoriesGenerator.openMenuInventory(p);
            }
            if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Sélecteur d'équipe")){
                main.teamInventoriesGenerator.openMenuInventory(p);
                e.setCancelled(true);
            }
        }
    }

}

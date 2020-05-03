package ch.dams333.betterUHC.listener.block;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.gameStep.GameStep;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceBlockEvent implements Listener {
    BetterUHC main;
    public PlaceBlockEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void blockPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(main.gameStepManager.isStep(GameStep.PREGAME)){
            e.setCancelled(true);
        }
        if(e.getBlockPlaced().getType() == Material.DIRT) {
            if (e.getPlayer().getInventory().getItemInMainHand() != null && e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {
                if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Terre infinie")) {
                    e.getPlayer().getInventory().setItemInMainHand(main.API.itemStackManager.create(Material.DIRT, 5, ChatColor.GOLD + "Terre infinie"));
                    e.getPlayer().updateInventory();
                }
            }
            if (e.getPlayer().getInventory().getItemInOffHand() != null && e.getPlayer().getInventory().getItemInOffHand().hasItemMeta()) {
                if (e.getPlayer().getInventory().getItemInOffHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Terre infinie")) {
                    e.getPlayer().getInventory().setItemInOffHand(main.API.itemStackManager.create(Material.DIRT, 5, ChatColor.GOLD + "Terre infinie"));
                    e.getPlayer().updateInventory();
                }
            }
        }
    }

    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent event){
        Block block = event.getBlock();
        if(main.gameScenariosManager.isScenarioActivate("skyhigh")) {
            if (block.getType() == Material.ICE) {
                block.setType(Material.WATER);
            }
        }
    }

}

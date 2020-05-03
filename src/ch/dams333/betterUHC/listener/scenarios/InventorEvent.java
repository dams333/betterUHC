package ch.dams333.betterUHC.listener.scenarios;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

import java.util.ArrayList;
import java.util.List;

public class InventorEvent implements Listener {
    BetterUHC main;
    public InventorEvent(BetterUHC main) {
        this.main = main;
    }

    private List<Material> crafted = new ArrayList<>();

    @EventHandler
    public void onCraft(CraftItemEvent e){
        if(!e.isCancelled()) {
            if (main.gameScenariosManager.isScenarioActivate("inventor paranoia")) {
                if (!crafted.contains(e.getRecipe().getResult().getType())) {
                    crafted.add(e.getRecipe().getResult().getType());
                    Bukkit.broadcastMessage(((Player) e.getWhoClicked()).getDisplayName() + ChatColor.GOLD + " a crafté " + e.getRecipe().getResult().getType().name() + " pour la première fois en "
                            + ChatColor.WHITE + "X: " + ChatColor.GREEN + Math.round(e.getWhoClicked().getLocation().getX()) + ChatColor.GRAY + " | "
                            + ChatColor.WHITE + "Y: " + ChatColor.GREEN + Math.round(e.getWhoClicked().getLocation().getY()) + ChatColor.GRAY + " | "
                            + ChatColor.WHITE + "Z: " + ChatColor.GREEN + Math.round(e.getWhoClicked().getLocation().getZ()) + ChatColor.GRAY + " | "
                    );
                }
            }
        }
    }

}

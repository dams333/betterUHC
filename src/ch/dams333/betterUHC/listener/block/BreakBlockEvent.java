package ch.dams333.betterUHC.listener.block;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.gameStep.GameStep;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class BreakBlockEvent implements Listener {
    BetterUHC main;
    public BreakBlockEvent(BetterUHC main) {
        this.main = main;
    }

    private List<Material> breaked = new ArrayList<>();

    @EventHandler
    public void blockBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(main.gameStepManager.isStep(GameStep.PREGAME)){
            e.setCancelled(true);
        }
        if(main.gameScenariosManager.isScenarioActivate("skyhigh")){
            if(e.getBlock().getType() == Material.DIRT){
                Block b = e.getBlock();
                b.setType(Material.AIR);
                b.getState().update();
            }
        }
        if(!e.isCancelled()){
            if(main.gameScenariosManager.isScenarioActivate("blockrush")){
                if(!breaked.contains(e.getBlock().getType())){
                    e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT, Integer.parseInt(String.valueOf(main.gameScenariosManager.getScenarioArgument("blockrush", "Nombre de lingots")))));
                    breaked.add(e.getBlock().getType());
                    Bukkit.broadcastMessage(e.getPlayer().getDisplayName() + ChatColor.GOLD + " a cassé " + ChatColor.BOLD + e.getBlock().getType().name() + ChatColor.RESET + "" + ChatColor.GOLD + " pour la première fois");
                }
            }
        }
    }

}

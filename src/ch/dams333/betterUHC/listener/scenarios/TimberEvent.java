package ch.dams333.betterUHC.listener.scenarios;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.*;

public class TimberEvent implements Listener {
    BetterUHC main;
    public TimberEvent(BetterUHC main) {
        this.main = main;
        validLogMaterials = new ArrayList<>();
        validLogMaterials.add(Material.ACACIA_LOG);
        validLogMaterials.add(Material.BIRCH_LOG);
        validLogMaterials.add(Material.OAK_LOG);
        validLogMaterials.add(Material.DARK_OAK_LOG);
        validLogMaterials.add(Material.SPRUCE_LOG);
        validLogMaterials.add(Material.JUNGLE_LOG);
    }

    private List<Material> validLogMaterials;

    @EventHandler(priority=EventPriority.MONITOR)
    public void onBlockBreak(BlockBreakEvent e)
    {
        if(main.gameScenariosManager.isScenarioActivate("timber")) {
            Player player = e.getPlayer();

            Block block = e.getBlock();
            if (validLogMaterials.contains(block.getType())) {
                cutDownTree(block.getLocation());
            }
        }
    }

    private void cutDownTree(Location location)
    {
        LinkedList<Block> blocks = new LinkedList();
        Location l;
        for (int i = location.getBlockY(); i < location.getWorld().getHighestBlockYAt(location.getBlockX(),
                location.getBlockZ());)
        {
            l = location.add(0.0D, 1.0D, 0.0D);
            Block block = l.getBlock();
            if (!validLogMaterials.contains(block.getType())) {
                break;
            }
            blocks.add(l.getBlock());
            l = null;
            i++;
        }
        for(Block block : blocks){
            block.breakNaturally();
        }
        blocks = null;
    }

}

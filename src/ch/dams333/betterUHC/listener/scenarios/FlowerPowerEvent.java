package ch.dams333.betterUHC.listener.scenarios;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlowerPowerEvent implements Listener {
    BetterUHC main;
    public FlowerPowerEvent(BetterUHC main) {
        this.main = main;
        flowers = new ArrayList<>();

        flowers.add(Material.DANDELION);
        flowers.add(Material.POPPY);
        flowers.add(Material.BLUE_ORCHID);
        flowers.add(Material.ALLIUM);
        flowers.add(Material.AZURE_BLUET);
        flowers.add(Material.RED_TULIP);
        flowers.add(Material.ORANGE_TULIP);
        flowers.add(Material.WHITE_TULIP);
        flowers.add(Material.PINK_TULIP);
        flowers.add(Material.OXEYE_DAISY);
        flowers.add(Material.CORNFLOWER);
        flowers.add(Material.LILY_OF_THE_VALLEY);
        flowers.add(Material.LILAC);
        flowers.add(Material.ROSE_BUSH);
        flowers.add(Material.PEONY);
    }

    private List<Material> flowers;

    @EventHandler
    public void breakBlock(BlockBreakEvent e) {
        if (main.gameScenariosManager.isScenarioActivate("FlowerPower")) {
            if (flowers.contains(e.getBlock().getType())) {
                e.setDropItems(false);
                Material mat = Material.values()[new Random().nextInt(Material.values().length)];
                e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(mat, 1));
            }
        }
    }

}

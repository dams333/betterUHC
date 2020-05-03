package ch.dams333.betterUHC.listener.scenarios;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class HasteyBoysEvent implements Listener {
    BetterUHC main;
    public HasteyBoysEvent(BetterUHC main) {
        this.main = main;
        itemsToAddEnchant = new ArrayList<>();
        itemsToAddEnchant.add(Material.WOODEN_AXE);
        itemsToAddEnchant.add(Material.WOODEN_SHOVEL);
        itemsToAddEnchant.add(Material.WOODEN_PICKAXE);
        itemsToAddEnchant.add(Material.STONE_AXE);
        itemsToAddEnchant.add(Material.STONE_SHOVEL);
        itemsToAddEnchant.add(Material.STONE_PICKAXE);
        itemsToAddEnchant.add(Material.IRON_AXE);
        itemsToAddEnchant.add(Material.IRON_SHOVEL);
        itemsToAddEnchant.add(Material.IRON_PICKAXE);
        itemsToAddEnchant.add(Material.GOLDEN_AXE);
        itemsToAddEnchant.add(Material.GOLDEN_SHOVEL);
        itemsToAddEnchant.add(Material.GOLDEN_PICKAXE);
        itemsToAddEnchant.add(Material.DIAMOND_AXE);
        itemsToAddEnchant.add(Material.DIAMOND_SHOVEL);
        itemsToAddEnchant.add(Material.DIAMOND_PICKAXE);
    }

    private List<Material> itemsToAddEnchant;

    @EventHandler
    public void onCraft(PrepareItemCraftEvent e){
        if(main.gameScenariosManager.isScenarioActivate("HasteyBoys")) {
            if (itemsToAddEnchant.contains(e.getInventory().getResult().getType())) {
                ItemStack it = new ItemStack(e.getInventory().getResult().getType());
                it.addUnsafeEnchantment(Enchantment.DIG_SPEED, 3);
                e.getInventory().setResult(it);
            }
        }
    }

}

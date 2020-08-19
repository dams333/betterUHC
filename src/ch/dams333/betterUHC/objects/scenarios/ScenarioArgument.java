package ch.dams333.betterUHC.objects.scenarios;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ScenarioArgument {

    private String name;
    private Double value;
    private Material it;
    private Double increment;

    public Double getIncrement() {
        return increment;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getName() {

        return name;
    }

    public Double getValue() {
        return value;
    }

    public ScenarioArgument(String name, Double value, Material it, Double increment) {
        this.it = it;
        this.name = name;
        this.value = value;
        this.increment = increment;
    }

    public ItemStack getItem() {
        ItemStack item = new ItemStack(it);
        ItemMeta m = item.getItemMeta();
        m.setDisplayName(ChatColor.GOLD + name + ": " + ChatColor.GRAY + value);
        m.setLore(Arrays.asList(ChatColor.GREEN + "Clique gauche pour augmenter", ChatColor.RED + "Clique droit pour diminuer"));
        item.setItemMeta(m);
        return item;
    }
}

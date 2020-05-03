package ch.dams333.betterUHC.listener.item;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.ItemStack;

public class EnchantEvent implements Listener {
    BetterUHC main;
    public EnchantEvent(BetterUHC main) {
        this.main = main;
    }

    private boolean isIron(ItemStack it){
        if(it.getType() == Material.IRON_HELMET) return true;
        if(it.getType() == Material.IRON_CHESTPLATE) return true;
        if(it.getType() == Material.IRON_LEGGINGS) return true;
        if(it.getType() == Material.IRON_BOOTS) return true;
        return false;
    }

    private boolean isDiamond(ItemStack it){
        if(it.getType() == Material.DIAMOND_HELMET) return true;
        if(it.getType() == Material.DIAMOND_CHESTPLATE) return true;
        if(it.getType() == Material.DIAMOND_LEGGINGS) return true;
        if(it.getType() == Material.DIAMOND_BOOTS) return true;
        return false;
    }

    @EventHandler
    public void enchantEvent(EnchantItemEvent e){
        if(e.getItem().getType() != Material.AIR){
            if(isIron(e.getItem())) {
                for (Enchantment enchantment : e.getEnchantsToAdd().keySet()) {
                    if(enchantment.getName().equals("PROTECTION_ENVIRONMENTAL")){
                        if(e.getEnchantsToAdd().get(enchantment) > main.gameVariables.ironProteclimit){
                            e.setCancelled(true);
                            e.getEnchanter().sendMessage(ChatColor.RED + "Tu ne peut pas mettre un niveau de protection supérieur à " + main.gameVariables.ironProteclimit + " sur du fer");
                        }
                    }
                }
            }
            if(isDiamond(e.getItem())){
                for (Enchantment enchantment : e.getEnchantsToAdd().keySet()) {
                    if(enchantment.getName().equals("PROTECTION_ENVIRONMENTAL")){
                        if(e.getEnchantsToAdd().get(enchantment) > main.gameVariables.diamondProtecLimit){
                            e.setCancelled(true);
                            e.getEnchanter().sendMessage(ChatColor.RED + "Tu ne peut pas mettre un niveau de protection supérieur à " + main.gameVariables.diamondProtecLimit + " sur du diamant");
                        }
                    }
                }
            }
            if(e.getItem().getType() == Material.IRON_SWORD){
                for (Enchantment enchantment : e.getEnchantsToAdd().keySet()) {
                    if(enchantment.getName().equals("DAMAGE_ALL")){
                        if(e.getEnchantsToAdd().get(enchantment) > main.gameVariables.ironSharpLimit){
                            e.setCancelled(true);
                            e.getEnchanter().sendMessage(ChatColor.RED + "Tu ne peut pas mettre un niveau de tranchant supérieur à " + main.gameVariables.ironSharpLimit + " sur du fer");
                        }
                    }
                }
            }
            if(e.getItem().getType() == Material.DIAMOND_SWORD){
                for (Enchantment enchantment : e.getEnchantsToAdd().keySet()) {
                    if(enchantment.getName().equals("DAMAGE_ALL")){
                        if(e.getEnchantsToAdd().get(enchantment) > main.gameVariables.diamondSharpLimit){
                            e.setCancelled(true);
                            e.getEnchanter().sendMessage(ChatColor.RED + "Tu ne peut pas mettre un niveau de tranchant supérieur à " + main.gameVariables.diamondSharpLimit + " sur du diamant");
                        }
                    }
                }
            }
        }
    }

}

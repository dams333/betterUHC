package ch.dams333.betterUHC.listener.item;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;

public class AnvilEvent implements Listener {
    BetterUHC main;
    public AnvilEvent(BetterUHC main) {
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
    public void anvil(PrepareAnvilEvent e){
        if(e.getResult() != null){
            if(isIron(e.getResult())){
                for(Enchantment enchantment : e.getResult().getEnchantments().keySet()){
                    if(enchantment.getName().equals("PROTECTION_ENVIRONMENTAL")){
                        if(e.getResult().getEnchantments().get(enchantment) > main.gameVariables.ironProteclimit){
                            for(HumanEntity pl : e.getViewers()){
                                Player p = (Player) pl;
                                p.closeInventory();
                                p.sendMessage(ChatColor.RED + "Vous ne pouvez pas atteindre ce niveau d'enchantement !");
                            }
                        }
                    }
                }
            }
            if(isDiamond(e.getResult())){
                for(Enchantment enchantment : e.getResult().getEnchantments().keySet()){
                    if(enchantment.getName().equals("PROTECTION_ENVIRONMENTAL")){
                        if(e.getResult().getEnchantments().get(enchantment) > main.gameVariables.diamondProtecLimit){
                            for(HumanEntity pl : e.getViewers()){
                                Player p = (Player) pl;
                                p.closeInventory();
                                p.sendMessage(ChatColor.RED + "Vous ne pouvez pas atteindre ce niveau d'enchantement !");
                            }
                        }
                    }
                }
            }
            if(e.getResult().getType() == Material.IRON_SWORD){
                for(Enchantment enchantment : e.getResult().getEnchantments().keySet()){
                    if(enchantment.getName().equals("DAMAGE_ALL")){
                        if(e.getResult().getEnchantments().get(enchantment) > main.gameVariables.ironSharpLimit){
                            for(HumanEntity pl : e.getViewers()){
                                Player p = (Player) pl;
                                p.closeInventory();
                                p.sendMessage(ChatColor.RED + "Vous ne pouvez pas atteindre ce niveau d'enchantement !");
                            }
                        }
                    }
                }
            }
            if(e.getResult().getType() == Material.DIAMOND_SWORD){
                for(Enchantment enchantment : e.getResult().getEnchantments().keySet()){
                    if(enchantment.getName().equals("DAMAGE_ALL")){
                        if(e.getResult().getEnchantments().get(enchantment) > main.gameVariables.diamondSharpLimit){
                            for(HumanEntity pl : e.getViewers()){
                                Player p = (Player) pl;
                                p.closeInventory();
                                p.sendMessage(ChatColor.RED + "Vous ne pouvez pas atteindre ce niveau d'enchantement !");
                            }
                        }
                    }
                }
            }
        }
    }

}

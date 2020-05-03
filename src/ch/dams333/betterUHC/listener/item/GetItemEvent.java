package ch.dams333.betterUHC.listener.item;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class GetItemEvent implements Listener {
    BetterUHC main;
    public GetItemEvent(BetterUHC main) {
        this.main = main;
    }

    @EventHandler
    public void getItem(PlayerPickupItemEvent e){
        Player p = e.getPlayer();
        e.getItem();
        if(e.getItem().getItemStack().getType() != Material.AIR){
            ItemStack it = e.getItem().getItemStack();
            if(main.gameVariables.itemsLimits.keySet().contains(it.getType())){
                ItemLimit itemLimit = main.gameManager.getItemLimit(p, it.getType());
                if(itemLimit.getCount() + it.getAmount() > itemLimit.getLimit()){
                    if(itemLimit.getCount() < itemLimit.getLimit()){
                        ItemStack newIT = it.clone();
                        newIT.setAmount(itemLimit.getLimit() - itemLimit.getCount());
                        it.setAmount(it.getAmount() - (itemLimit.getLimit() - itemLimit.getCount()));
                        p.getInventory().addItem(newIT);
                        itemLimit.setCount(itemLimit.getLimit());
                        main.gameManager.updateItemLimit(itemLimit);
                    }
                    e.setCancelled(true);
                    p.sendMessage(ChatColor.RED + "Vous ne pouvez pas récolté plus de " + itemLimit.getLimit() + " " + it.getType().name());
                }else{
                    itemLimit.setCount(itemLimit.getCount() + it.getAmount());
                    main.gameManager.updateItemLimit(itemLimit);
                }
            }
        }
    }

}

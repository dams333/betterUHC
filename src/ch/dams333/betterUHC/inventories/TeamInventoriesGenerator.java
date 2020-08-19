package ch.dams333.betterUHC.inventories;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.teams.Team;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TeamInventoriesGenerator {
    BetterUHC main;
    public TeamInventoriesGenerator(BetterUHC betterUHC) {
        this.main = betterUHC;
    }

    public void openMenuInventory(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GREEN + "Choisir une équipe");

        for(Team team : main.teamsManager.getTeams()){
            if(team.isActivated()) {
                ItemStack it = main.API.itemStackManager.create(team.getBanner(), team.getChatColor() + team.getName());
                inv.addItem(it);
            }
        }
        p.openInventory(inv);
    }
}

package ch.dams333.betterUHC.listener.actions;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class ClickInInventoryEvent implements Listener {
    BetterUHC main;
    public ClickInInventoryEvent(BetterUHC main) {
        this.main = main;
    }


    @EventHandler
    public void click(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        ItemStack it = e.getCurrentItem();

        if(it != null && it.getType() != Material.AIR){
            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration")){
                e.setCancelled(true);

                if(it.getType() == Material.CLOCK){
                   main.adminInventoriesGenerator.openTimerInventory(p);
                }
                if(it.getType() == Material.CHEST){
                    main.adminInventoriesGenerator.openStartInventoryInventory(p);
                }
                if(it.getType() == Material.WHITE_BANNER){
                    main.adminInventoriesGenerator.openTeamsInventory(p);
                }
                if(it.getType() == Material.BARRIER){
                    main.adminInventoriesGenerator.openBoderInventory(p);
                }
                if(it.getType() == Material.DIAMOND){
                    main.adminInventoriesGenerator.openItemsLimitsInventory(p);
                }
                if(it.getType() == Material.DIAMOND_CHESTPLATE){
                    main.adminInventoriesGenerator.openArmorLimitsInventory(p);
                }
                if(it.getType() == Material.ENCHANTED_BOOK){
                    main.adminInventoriesGenerator.openEnchantmentLimitsInventory(p);
                }
                if(it.getType() == Material.OAK_SIGN){
                    main.adminInventoriesGenerator.openChatInventory(p);
                }
                if(it.getType() == Material.BEACON){
                    main.adminInventoriesGenerator.openAffichageInventory(p);
                }
                if(it.getType() == Material.ENDER_CHEST){
                    main.adminInventoriesGenerator.openScenariosInventory(p);
                }
                if(it.getType() == Material.CRAFTING_TABLE){
                    main.adminInventoriesGenerator.openCraftInventory(p);
                }

            }
            if (e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Crafts")) {

                    if (it.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Configuration de la partie")) {
                        e.setCancelled(true);
                    }
                    if (it.getType() == Material.WHITE_STAINED_GLASS_PANE && it.getItemMeta().getDisplayName().equals(" ")) {
                        e.setCancelled(true);
                    }
                    if (it.getType() == Material.CHEST && it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Liste des crafts")) {
                        e.setCancelled(true);
                        main.adminInventoriesGenerator.openCraftsListInventory(p);
                    }
                    if (it.getType() == Material.EMERALD_BLOCK && it.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Valider le craft")) {
                        e.setCancelled(true);
                        if(main.customCraftManager.addCraft(e.getInventory())){
                            main.adminInventoriesGenerator.openCraftsListInventory(p);
                            p.sendMessage(ChatColor.LIGHT_PURPLE + "Craft enregistré avec succès");
                        }else{
                            p.sendMessage(ChatColor.LIGHT_PURPLE + "Le craft n'est pas assez complet pour être enregistré");
                        }
                    }
                    if (it.getType() == Material.ARROW && it.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Revenir en arrière")) {
                        e.setCancelled(true);
                        main.adminInventoriesGenerator.openMenuInventory(p);
                    }
            }
            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Crafts > Liste")) {
                e.setCancelled(true);
                if (it.getType() == Material.ARROW && it.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Revenir en arrière")) {
                    e.setCancelled(true);
                    main.adminInventoriesGenerator.openCraftInventory(p);
                }else{
                    if(e.getAction() == InventoryAction.PICKUP_HALF){
                        net.minecraft.server.v1_15_R1.ItemStack nms = CraftItemStack.asNMSCopy(it);
                        if(nms.getTag().get("uuid") != null){
                            UUID uuid = UUID.fromString(nms.getTag().getString("uuid"));
                            main.customCraftManager.removeCraft(uuid);
                        }
                    }
                    main.adminInventoriesGenerator.openCraftsListInventory(p);
                }
            }
            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Scénarios")) {
                e.setCancelled(true);
                if (it.getType() == Material.ARROW && it.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Revenir en arrière")) {
                    main.adminInventoriesGenerator.openMenuInventory(p);
                } else {

                    main.gameScenariosManager.changeScenarioStatu(it);

                    main.adminInventoriesGenerator.openScenariosInventory(p);
                }
            }
            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Choisir une équipe")){
                e.setCancelled(true);
                main.teamsManager.chooseTeam(it.getItemMeta().getDisplayName(), p);
                p.closeInventory();

                ItemStack it2 = main.teamsManager.getTeamBanner(p);
                ItemMeta m = it2.getItemMeta();
                m.setDisplayName(ChatColor.GOLD + "Sélecteur d'équipe");
                it2.setItemMeta(m);
                p.getInventory().setItem(0, it2);
            }
            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Affichage")) {
                e.setCancelled(true);
                if (it.getType() == Material.ARROW) {
                    main.adminInventoriesGenerator.openMenuInventory(p);
                } else {
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Affichage des timers: activé")) main.gameVariables.afficheTimers = false;
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Affichage des timers: désactivé")) main.gameVariables.afficheTimers = true;
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Affichage des coordonées de la bordure: activé")) main.gameVariables.afficheBorder = false;
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Affichage des coordonées de la bordure: désactivé")) main.gameVariables.afficheBorder = true;
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Affichage de la vie dans le tab: activé")) main.gameVariables.afficheHealth = false;
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Affichage de la vie dans le tab: désactivé")) main.gameVariables.afficheHealth = true;
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Affichage du tueur: activé")) main.gameVariables.afficheKiller = false;
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Affichage du tueur: désactivé")) main.gameVariables.afficheKiller = true;
                    main.adminInventoriesGenerator.openAffichageInventory(p);
                }
            }
            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Chat")){
                e.setCancelled(true);
                if(it.getType() == Material.ARROW){
                    main.adminInventoriesGenerator.openMenuInventory(p);
                }else{
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Chat général activé")) main.gameVariables.globalChat = false;
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Chat général désactivé")) main.gameVariables.globalChat = true;
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Chat d'équipe activé")) main.gameVariables.teamChat = false;
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Chat d'équipe désactivé")) main.gameVariables.teamChat = true;
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Chat général anonyme")) main.gameVariables.anonymGlobalChat = false;
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Chat général avec pseudos")) main.gameVariables.anonymGlobalChat = true;
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Chat d'équipe anonyme")) main.gameVariables.anonymTeamChat = false;
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Chat d'équipe avec pseudos")) main.gameVariables.anonymTeamChat = true;
                    main.adminInventoriesGenerator.openChatInventory(p);
                }
            }
            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Limites d'enchantement")){
                e.setCancelled(true);
                if(it.getType() == Material.ARROW){
                    main.adminInventoriesGenerator.openMenuInventory(p);
                }else{
                    if(it.getType() == Material.IRON_CHESTPLATE){
                        if(e.getAction() == InventoryAction.PICKUP_ALL){
                            if(main.gameVariables.ironProteclimit < 5) main.gameVariables.ironProteclimit = main.gameVariables.ironProteclimit + 1;
                        }
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            if(main.gameVariables.ironProteclimit > 1) main.gameVariables.ironProteclimit = main.gameVariables.ironProteclimit - 1;
                        }
                    }
                    if(it.getType() == Material.IRON_SWORD){
                        if(e.getAction() == InventoryAction.PICKUP_ALL){
                            if(main.gameVariables.ironSharpLimit < 5) main.gameVariables.ironSharpLimit = main.gameVariables.ironSharpLimit + 1;
                        }
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            if(main.gameVariables.ironSharpLimit > 1) main.gameVariables.ironSharpLimit = main.gameVariables.ironSharpLimit - 1;
                        }
                    }
                    if(it.getType() == Material.DIAMOND_CHESTPLATE){
                        if(e.getAction() == InventoryAction.PICKUP_ALL){
                            if(main.gameVariables.diamondProtecLimit < 5) main.gameVariables.diamondProtecLimit = main.gameVariables.diamondProtecLimit + 1;
                        }
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            if(main.gameVariables.diamondProtecLimit > 1) main.gameVariables.diamondProtecLimit = main.gameVariables.diamondProtecLimit - 1;
                        }
                    }
                    if(it.getType() == Material.DIAMOND_SWORD){
                        if(e.getAction() == InventoryAction.PICKUP_ALL){
                            if(main.gameVariables.diamondSharpLimit < 5) main.gameVariables.diamondSharpLimit = main.gameVariables.diamondSharpLimit + 1;
                        }
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            if(main.gameVariables.diamondSharpLimit > 1) main.gameVariables.diamondSharpLimit = main.gameVariables.diamondSharpLimit - 1;
                        }
                    }
                    main.adminInventoriesGenerator.openEnchantmentLimitsInventory(p);
                }
            }
            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Limites d'armure")){
                e.setCancelled(true);
                if(it.getType() == Material.ARROW){
                    main.adminInventoriesGenerator.openMenuInventory(p);
                }else {
                    if (it.getType() == Material.LEATHER_CHESTPLATE) {
                        if(e.getAction() == InventoryAction.PICKUP_ALL){
                            if(main.gameVariables.leatherLimit < 4) main.gameVariables.leatherLimit = main.gameVariables.leatherLimit + 1;
                        }
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            if(main.gameVariables.leatherLimit > 1) main.gameVariables.leatherLimit = main.gameVariables.leatherLimit - 1;
                        }
                    }
                    if (it.getType() == Material.CHAINMAIL_CHESTPLATE) {
                        if(e.getAction() == InventoryAction.PICKUP_ALL){
                            if(main.gameVariables.chainLimit < 4) main.gameVariables.chainLimit = main.gameVariables.chainLimit + 1;
                        }
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            if(main.gameVariables.chainLimit > 1) main.gameVariables.chainLimit = main.gameVariables.chainLimit - 1;
                        }
                    }
                    if (it.getType() == Material.IRON_CHESTPLATE) {
                        if(e.getAction() == InventoryAction.PICKUP_ALL){
                            if(main.gameVariables.ironLimit < 4) main.gameVariables.ironLimit = main.gameVariables.ironLimit + 1;
                        }
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            if(main.gameVariables.ironLimit > 1) main.gameVariables.ironLimit = main.gameVariables.ironLimit - 1;
                        }
                    }
                    if (it.getType() == Material.GOLDEN_CHESTPLATE) {
                        if(e.getAction() == InventoryAction.PICKUP_ALL){
                            if(main.gameVariables.goldLimit < 4) main.gameVariables.goldLimit = main.gameVariables.goldLimit + 1;
                        }
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            if(main.gameVariables.goldLimit > 1) main.gameVariables.goldLimit = main.gameVariables.goldLimit - 1;
                        }
                    } if (it.getType() == Material.DIAMOND_CHESTPLATE) {
                        if(e.getAction() == InventoryAction.PICKUP_ALL){
                            if(main.gameVariables.diamondLimit < 4) main.gameVariables.diamondLimit = main.gameVariables.diamondLimit + 1;
                        }
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            if(main.gameVariables.diamondLimit > 1) main.gameVariables.diamondLimit = main.gameVariables.diamondLimit - 1;
                        }
                    }

                    main.adminInventoriesGenerator.openArmorLimitsInventory(p);
                }
            }
            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Limites d'items")){
                if(it.getType() == Material.BLACK_STAINED_GLASS_PANE || it.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Configuration de la partie")){
                    e.setCancelled(true);
                }else if(it.getType() == Material.ARROW && it.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Revenir en arrière [Sauvegarder]")){
                    e.setCancelled(true);
                    Map<Material, Integer> limits = new HashMap<>();
                    for(int i = 0; i < 27; i++){
                        if(e.getInventory().getContents()[i] != null && e.getInventory().getContents()[i].getType() != Material.AIR){
                            limits.put(e.getInventory().getContents()[i].getType(), e.getInventory().getContents()[i].getAmount());
                        }
                    }
                    main.gameVariables.itemsLimits = limits;
                    main.adminInventoriesGenerator.openMenuInventory(p);
                }
            }
            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Bordure")){
                e.setCancelled(true);

                if(it.getType() == Material.ARROW){
                    main.adminInventoriesGenerator.openMenuInventory(p);
                }else{

                    if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Bordure avant la réduction")){
                        if(e.getAction() == InventoryAction.PICKUP_ALL){
                            main.gameVariables.preBorder = main.gameVariables.preBorder + 50;
                        }
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            if(main.gameVariables.preBorder < 50){
                                main.gameVariables.preBorder = 0;
                            }else{
                                main.gameVariables.preBorder = main.gameVariables.preBorder - 50;
                            }
                        }
                    }
                    if(it.getType() == Material.CLOCK){
                        if(e.getAction() == InventoryAction.PICKUP_ALL){
                            main.gameVariables.reductionTime = main.gameVariables.reductionTime + 30;
                        }
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            if(main.gameVariables.reductionTime < 30){
                                main.gameVariables.reductionTime = 0;
                            }else{
                                main.gameVariables.reductionTime = main.gameVariables.reductionTime - 30;
                            }
                        }
                    }
                    if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Bordure après la réduction")){
                        if(e.getAction() == InventoryAction.PICKUP_ALL){
                            main.gameVariables.postBorder = main.gameVariables.postBorder + 50;
                        }
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            if(main.gameVariables.postBorder <= 50){
                                if(main.gameVariables.postBorder < 5) {
                                    main.gameVariables.postBorder = 0;
                                }else{
                                    main.gameVariables.postBorder = main.gameVariables.postBorder - 5;
                                }
                            }else{
                                main.gameVariables.postBorder = main.gameVariables.postBorder - 50;
                            }
                        }
                    }

                    main.adminInventoriesGenerator.openBoderInventory(p);
                }
            }

            if(e.getView().getTitle().startsWith(ChatColor.DARK_GREEN + "Configuration > Equipes")){
                e.setCancelled(true);
                if (it.getType() == Material.ARROW) {
                    main.adminInventoriesGenerator.openMenuInventory(p);
                }else if(it.getType() != Material.BLACK_STAINED_GLASS_PANE){
                    main.teamsManager.switchTeam(it.getItemMeta().getDisplayName());
                    main.adminInventoriesGenerator.openTeamsInventory(p);
                }
            }

            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Inventaire de départ")){
                if(it.getType() == Material.BLACK_STAINED_GLASS_PANE || it.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Configuration de la partie")){
                    e.setCancelled(true);
                }else if(it.getType() == Material.ARROW && it.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Revenir en arrière [Sauvegarder]")){
                    e.setCancelled(true);
                    List<ItemStack> items = new ArrayList<>();
                    for(int i = 0; i < 27; i++){
                        if(e.getInventory().getContents()[i] != null && e.getInventory().getContents()[i].getType() != Material.AIR){
                            items.add(e.getInventory().getContents()[i]);
                        }
                    }
                    main.gameVariables.startInventory = items;
                    main.adminInventoriesGenerator.openMenuInventory(p);
                }
            }
            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Timers")){
                e.setCancelled(true);

                if(it.getType() == Material.ARROW){
                    main.adminInventoriesGenerator.openMenuInventory(p);
                }
                if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Temps avant la fin de l'invincibilité:")){
                    main.adminInventoriesGenerator.openModifyTimerInventory(p, "grace");
                }
                if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Temps avant le PVP:")){
                    main.adminInventoriesGenerator.openModifyTimerInventory(p, "pvp");
                }
                if(it.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Temps avant la réduction de la bordure:")){
                    main.adminInventoriesGenerator.openModifyTimerInventory(p, "border");
                }

            }
            if(e.getView().getTitle().startsWith(ChatColor.DARK_GREEN + "Configuration > Timers > ")) {
                e.setCancelled(true);

                if (it.getType() == Material.ARROW) {
                    main.adminInventoriesGenerator.openTimerInventory(p);
                }

                if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Timers > Invincibilité")){
                    if(it.getItemMeta().getDisplayName().contains("- 1min")){
                        if(main.gameVariables.graceTime > 60){
                            main.gameVariables.graceTime = main.gameVariables.graceTime - 60;
                        }else{
                            main.gameVariables.graceTime = 0;
                        }
                    }
                    if(it.getItemMeta().getDisplayName().contains("- 30sec")){
                        if(main.gameVariables.graceTime > 30){
                            main.gameVariables.graceTime = main.gameVariables.graceTime - 30;
                        }else{
                            main.gameVariables.graceTime = 0;
                        }
                    }
                    if(it.getItemMeta().getDisplayName().contains("- 10sec")){
                        if(main.gameVariables.graceTime > 10){
                            main.gameVariables.graceTime = main.gameVariables.graceTime - 10;
                        }else{
                            main.gameVariables.graceTime = 0;
                        }
                    }
                    if(it.getItemMeta().getDisplayName().contains("+ 10sec")){
                        main.gameVariables.graceTime = main.gameVariables.graceTime + 10;
                    }
                    if(it.getItemMeta().getDisplayName().contains("+ 30sec")){
                        main.gameVariables.graceTime = main.gameVariables.graceTime + 30;
                    }
                    if(it.getItemMeta().getDisplayName().contains("+ 1min")){
                        main.gameVariables.graceTime = main.gameVariables.graceTime + 60;
                    }
                    if(it.getType() != Material.CLOCK && it.getType() != Material.ARROW){
                        main.adminInventoriesGenerator.openModifyTimerInventory(p, "grace");
                    }
                }
                if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Timers > PVP")){
                    if(it.getItemMeta().getDisplayName().contains("- 20min")){
                        if(main.gameVariables.pvpTime > 1200){
                            main.gameVariables.pvpTime = main.gameVariables.pvpTime - 1200;
                        }else{
                            main.gameVariables.pvpTime = 0;
                        }
                    }
                    if(it.getItemMeta().getDisplayName().contains("- 10min")){
                        if(main.gameVariables.pvpTime > 600){
                            main.gameVariables.pvpTime = main.gameVariables.pvpTime - 600;
                        }else{
                            main.gameVariables.pvpTime = 0;
                        }
                    }
                    if(it.getItemMeta().getDisplayName().contains("- 1min")){
                        if(main.gameVariables.pvpTime > 60){
                            main.gameVariables.pvpTime = main.gameVariables.pvpTime - 60;
                        }else{
                            main.gameVariables.pvpTime = 0;
                        }
                    }
                    if(it.getItemMeta().getDisplayName().contains("+ 1min")){
                        main.gameVariables.pvpTime = main.gameVariables.pvpTime + 60;
                    }
                    if(it.getItemMeta().getDisplayName().contains("+ 10min")){
                        main.gameVariables.pvpTime = main.gameVariables.pvpTime + 600;
                    }
                    if(it.getItemMeta().getDisplayName().contains("+ 20min")){
                        main.gameVariables.pvpTime = main.gameVariables.pvpTime + 1200;
                    }
                    if(it.getType() != Material.CLOCK && it.getType() != Material.ARROW){
                        main.adminInventoriesGenerator.openModifyTimerInventory(p, "pvp");
                    }
                }
                if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Timers > Bordure")){
                    if(it.getItemMeta().getDisplayName().contains("- 30min")){
                        if(main.gameVariables.borderTime > 1800){
                            main.gameVariables.borderTime = main.gameVariables.borderTime - 1800;
                        }else{
                            main.gameVariables.borderTime = 0;
                        }
                    }
                    if(it.getItemMeta().getDisplayName().contains("- 15min")){
                        if(main.gameVariables.borderTime > 900){
                            main.gameVariables.borderTime = main.gameVariables.borderTime - 900;
                        }else{
                            main.gameVariables.borderTime = 0;
                        }
                    }
                    if(it.getItemMeta().getDisplayName().contains("- 5min")){
                        if(main.gameVariables.borderTime > 300){
                            main.gameVariables.borderTime = main.gameVariables.borderTime - 300;
                        }else{
                            main.gameVariables.borderTime = 0;
                        }
                    }
                    if(it.getItemMeta().getDisplayName().contains("+ 5min")){
                        main.gameVariables.borderTime = main.gameVariables.borderTime + 300;
                    }
                    if(it.getItemMeta().getDisplayName().contains("+ 15min")){
                        main.gameVariables.borderTime = main.gameVariables.borderTime + 900;
                    }
                    if(it.getItemMeta().getDisplayName().contains("+ 30min")){
                        main.gameVariables.borderTime = main.gameVariables.borderTime + 1800;
                    }
                    if(it.getType() != Material.CLOCK && it.getType() != Material.ARROW){
                        main.adminInventoriesGenerator.openModifyTimerInventory(p, "border");
                    }
                }
            }
        }
    }

}

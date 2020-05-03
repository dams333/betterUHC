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
                if(it.getType() == Material.WHITE_STAINED_GLASS){
                    main.adminInventoriesGenerator.openSaveInventory(p);
                }
                if(it.getType() == Material.COMMAND_BLOCK){
                    main.adminInventoriesGenerator.openLoadInventory(p);
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
            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Charger")) {
                e.setCancelled(true);
                if (it.getType() == Material.ARROW && it.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Revenir en arrière")) {
                    main.adminInventoriesGenerator.openMenuInventory(p);
                } else {
                    if(e.getAction() == InventoryAction.PICKUP_ALL) {
                        main.savesManager.loadSave(it.getItemMeta().getDisplayName().replaceAll("§6", ""), p);
                    }
                    if(e.getAction() == InventoryAction.PICKUP_HALF){
                        main.savesManager.removeSave(it.getItemMeta().getDisplayName().replaceAll("§6", ""), p);
                        main.adminInventoriesGenerator.openLoadInventory(p);
                    }
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
            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Sélection d'une équipe")) {
                e.setCancelled(true);

                main.teamsManager.joinTeam(p, it.getType());

                main.teamInventoriesGenerator.openMenuInventory(p);
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
            if(e.getView().getTitle().equals(ChatColor.DARK_GREEN + "Configuration > Equipes")){
                e.setCancelled(true);
                if(it.getType() == Material.ARROW){
                    main.adminInventoriesGenerator.openMenuInventory(p);
                }else{

                    if(it.getType() == Material.REDSTONE_BLOCK){
                        main.gameVariables.activateTeams = true;
                        main.teamsManager.activateTeams();
                    }
                    if(it.getType() == Material.EMERALD_BLOCK){
                        main.gameVariables.activateTeams = false;
                        main.teamsManager.desactivateTeams();
                    }
                    if(it.getType() == Material.REDSTONE){
                        main.gameVariables.infiniteTeams = true;
                    }
                    if(it.getType() == Material.EMERALD){
                        main.gameVariables.infiniteTeams = false;
                        if(main.gameVariables.whiteTeam < 0) main.gameVariables.whiteTeam = 0;
                        if(main.gameVariables.orangeTeam < 0) main.gameVariables.orangeTeam = 0;
                        if(main.gameVariables.magentaTeam < 0) main.gameVariables.magentaTeam = 0;
                        if(main.gameVariables.lightBlueTeam < 0) main.gameVariables.lightBlueTeam = 0;
                        if(main.gameVariables.yellowTeam < 0) main.gameVariables.yellowTeam = 0;
                        if(main.gameVariables.limeTeam < 0) main.gameVariables.limeTeam = 0;
                        if(main.gameVariables.pinkTeam < 0) main.gameVariables.pinkTeam = 0;
                        if(main.gameVariables.grayTeam < 0) main.gameVariables.grayTeam = 0;
                        if(main.gameVariables.lightGrayTeam < 0) main.gameVariables.lightGrayTeam = 0;
                        if(main.gameVariables.cyanTeam < 0) main.gameVariables.cyanTeam = 0;
                        if(main.gameVariables.purpleTeam < 0) main.gameVariables.purpleTeam = 0;
                        if(main.gameVariables.blueTeam < 0) main.gameVariables.blueTeam = 0;
                        if(main.gameVariables.brownTeam < 0) main.gameVariables.brownTeam = 0;
                        if(main.gameVariables.greenTeam < 0) main.gameVariables.greenTeam = 0;
                        if(main.gameVariables.redTeam < 0) main.gameVariables.redTeam = 0;
                        if(main.gameVariables.blackTeam < 0) main.gameVariables.blackTeam = 0;
                    }
                    if(main.gameVariables.activateTeams) {
                        if (it.getType() == Material.WHITE_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.whiteTeam == 0){
                                    main.gameVariables.whiteTeam = -1;
                                }else{
                                    main.gameVariables.whiteTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.whiteTeam = main.gameVariables.whiteTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.whiteTeam < 1) {
                                        main.gameVariables.whiteTeam = 0;
                                    } else {
                                        main.gameVariables.whiteTeam = main.gameVariables.whiteTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.ORANGE_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.orangeTeam == 0){
                                    main.gameVariables.orangeTeam = -1;
                                }else{
                                    main.gameVariables.orangeTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.orangeTeam = main.gameVariables.orangeTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.orangeTeam < 1) {
                                        main.gameVariables.orangeTeam = 0;
                                    } else {
                                        main.gameVariables.orangeTeam = main.gameVariables.orangeTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.MAGENTA_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.magentaTeam == 0){
                                    main.gameVariables.magentaTeam = -1;
                                }else{
                                    main.gameVariables.magentaTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.magentaTeam = main.gameVariables.magentaTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.magentaTeam < 1) {
                                        main.gameVariables.magentaTeam = 0;
                                    } else {
                                        main.gameVariables.magentaTeam = main.gameVariables.magentaTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.LIGHT_BLUE_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.lightBlueTeam == 0){
                                    main.gameVariables.lightBlueTeam = -1;
                                }else{
                                    main.gameVariables.lightBlueTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.lightBlueTeam = main.gameVariables.lightBlueTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.lightBlueTeam < 1) {
                                        main.gameVariables.lightBlueTeam = 0;
                                    } else {
                                        main.gameVariables.lightBlueTeam = main.gameVariables.lightBlueTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.YELLOW_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.yellowTeam == 0){
                                    main.gameVariables.yellowTeam = -1;
                                }else{
                                    main.gameVariables.yellowTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.yellowTeam = main.gameVariables.yellowTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.yellowTeam < 1) {
                                        main.gameVariables.yellowTeam = 0;
                                    } else {
                                        main.gameVariables.yellowTeam = main.gameVariables.yellowTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.LIME_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.limeTeam == 0){
                                    main.gameVariables.limeTeam = -1;
                                }else{
                                    main.gameVariables.limeTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.limeTeam = main.gameVariables.limeTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.limeTeam < 1) {
                                        main.gameVariables.limeTeam = 0;
                                    } else {
                                        main.gameVariables.limeTeam = main.gameVariables.limeTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.PINK_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.pinkTeam == 0){
                                    main.gameVariables.pinkTeam = -1;
                                }else{
                                    main.gameVariables.pinkTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.pinkTeam = main.gameVariables.pinkTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.pinkTeam < 1) {
                                        main.gameVariables.pinkTeam = 0;
                                    } else {
                                        main.gameVariables.pinkTeam = main.gameVariables.pinkTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.GRAY_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.grayTeam == 0){
                                    main.gameVariables.grayTeam = -1;
                                }else{
                                    main.gameVariables.grayTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.grayTeam = main.gameVariables.grayTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.grayTeam < 1) {
                                        main.gameVariables.grayTeam = 0;
                                    } else {
                                        main.gameVariables.grayTeam = main.gameVariables.grayTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.LIGHT_GRAY_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.lightGrayTeam == 0){
                                    main.gameVariables.lightGrayTeam = -1;
                                }else{
                                    main.gameVariables.lightGrayTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.lightGrayTeam = main.gameVariables.lightGrayTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.lightGrayTeam < 1) {
                                        main.gameVariables.lightGrayTeam = 0;
                                    } else {
                                        main.gameVariables.lightGrayTeam = main.gameVariables.lightGrayTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.CYAN_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.cyanTeam == 0){
                                    main.gameVariables.cyanTeam = -1;
                                }else{
                                    main.gameVariables.cyanTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.cyanTeam = main.gameVariables.cyanTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.cyanTeam < 1) {
                                        main.gameVariables.cyanTeam = 0;
                                    } else {
                                        main.gameVariables.cyanTeam = main.gameVariables.cyanTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.PURPLE_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.purpleTeam == 0){
                                    main.gameVariables.purpleTeam = -1;
                                }else{
                                    main.gameVariables.purpleTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.purpleTeam = main.gameVariables.purpleTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.purpleTeam < 1) {
                                        main.gameVariables.purpleTeam = 0;
                                    } else {
                                        main.gameVariables.purpleTeam = main.gameVariables.purpleTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.BLUE_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.blueTeam == 0){
                                    main.gameVariables.blueTeam = -1;
                                }else{
                                    main.gameVariables.blueTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.blueTeam = main.gameVariables.blueTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.blueTeam < 1) {
                                        main.gameVariables.blueTeam = 0;
                                    } else {
                                        main.gameVariables.blueTeam = main.gameVariables.blueTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.BROWN_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.brownTeam == 0){
                                    main.gameVariables.brownTeam = -1;
                                }else{
                                    main.gameVariables.brownTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.brownTeam = main.gameVariables.brownTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.brownTeam < 1) {
                                        main.gameVariables.brownTeam = 0;
                                    } else {
                                        main.gameVariables.brownTeam = main.gameVariables.brownTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.GREEN_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.greenTeam == 0){
                                    main.gameVariables.greenTeam = -1;
                                }else{
                                    main.gameVariables.greenTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.greenTeam = main.gameVariables.greenTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.greenTeam < 1) {
                                        main.gameVariables.greenTeam = 0;
                                    } else {
                                        main.gameVariables.greenTeam = main.gameVariables.greenTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.RED_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.redTeam == 0){
                                    main.gameVariables.redTeam = -1;
                                }else{
                                    main.gameVariables.redTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.redTeam = main.gameVariables.redTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.redTeam < 1) {
                                        main.gameVariables.redTeam = 0;
                                    } else {
                                        main.gameVariables.redTeam = main.gameVariables.redTeam - 1;
                                    }
                                }
                            }
                        }
                        if (it.getType() == Material.BLACK_WOOL) {
                            if (main.gameVariables.infiniteTeams) {
                                if(main.gameVariables.blackTeam == 0){
                                    main.gameVariables.blackTeam = -1;
                                }else{
                                    main.gameVariables.blackTeam = 0;
                                }
                            } else {
                                if (e.getAction() == InventoryAction.PICKUP_ALL) {
                                    main.gameVariables.blackTeam = main.gameVariables.blackTeam + 1;
                                }
                                if (e.getAction() == InventoryAction.PICKUP_HALF) {
                                    if (main.gameVariables.blackTeam < 1) {
                                        main.gameVariables.blackTeam = 0;
                                    } else {
                                        main.gameVariables.blackTeam = main.gameVariables.blackTeam - 1;
                                    }
                                }
                            }
                        }
                    }
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

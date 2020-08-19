package ch.dams333.betterUHC.inventories;

import ch.dams333.betterUHC.BetterUHC;
import ch.dams333.betterUHC.objects.craft.CustomCraft;
import ch.dams333.betterUHC.objects.scenarios.GameScenario;
import ch.dams333.betterUHC.objects.teams.Team;
import net.minecraft.server.v1_15_R1.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class AdminInventoriesGenerator {
    BetterUHC main;
    public AdminInventoriesGenerator(BetterUHC betterUHC) {
        this.main = betterUHC;
    }

    public void openMenuInventory(Player p){
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GREEN + "Configuration");

        inv.setItem(2, main.API.itemStackManager.create(Material.CLOCK, ChatColor.GOLD + "Timers"));
        inv.setItem(4, main.API.itemStackManager.create(Material.WHITE_BANNER, ChatColor.LIGHT_PURPLE + "Equipes"));
        inv.setItem(6, main.API.itemStackManager.create(Material.BARRIER, ChatColor.DARK_RED + "Bordure du monde"));
        inv.setItem(22, main.API.itemStackManager.create(Material.CHEST, ChatColor.BLUE + "Inventaire de départ"));
        inv.setItem(29, main.API.itemStackManager.create(Material.CRAFTING_TABLE, ChatColor.DARK_BLUE + "Crafts customisés"));
        inv.setItem(33, main.API.itemStackManager.create(Material.ENDER_CHEST, ChatColor.DARK_PURPLE + "Scénarios"));
        inv.setItem(47, main.API.itemStackManager.create(Material.DIAMOND, ChatColor.RED + "Limites d'items"));
        inv.setItem(49, main.API.itemStackManager.create(Material.DIAMOND_CHESTPLATE, ChatColor.RED + "Limites d'armures"));
        inv.setItem(51, main.API.itemStackManager.create(Material.ENCHANTED_BOOK, ChatColor.RED + "Limites d'enchantements"));
        inv.setItem(45, main.API.itemStackManager.create(Material.OAK_SIGN, ChatColor.AQUA + "Gérer le chat"));
        inv.setItem(53, main.API.itemStackManager.create(Material.BEACON, ChatColor.GRAY + "Affichage"));

        p.openInventory(inv);
    }

    public void openTimerInventory(Player p){
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Configuration > Timers");

        inv.setItem(1, main.API.itemStackManager.create(Material.CLOCK, ChatColor.GOLD + "Temps avant la fin de l'invincibilité:", Arrays.asList(ChatColor.GRAY + main.gameVariables.getTimeIntoString(main.gameVariables.graceTime))));
        inv.setItem(3, main.API.itemStackManager.create(Material.CLOCK, ChatColor.GOLD + "Temps avant le PVP:", Arrays.asList(ChatColor.GRAY + main.gameVariables.getTimeIntoString(main.gameVariables.pvpTime))));
        inv.setItem(5, main.API.itemStackManager.create(Material.CLOCK, ChatColor.GOLD + "Temps avant la réduction de la bordure:", Arrays.asList(ChatColor.GRAY + main.gameVariables.getTimeIntoString(main.gameVariables.borderTime))));
        inv.setItem(8, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière"));

        p.openInventory(inv);
    }

    public void openModifyTimerInventory(Player p, String grace) {

        Inventory inv = null;
        if(grace.equals("grace")){
            inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Configuration > Timers > Invincibilité");
            inv.setItem(0, main.API.itemStackManager.create(Material.REDSTONE, ChatColor.RED + "- 1min"));
            inv.setItem(1, main.API.itemStackManager.create(Material.REDSTONE, ChatColor.RED + "- 30sec"));
            inv.setItem(2, main.API.itemStackManager.create(Material.REDSTONE, ChatColor.RED + "- 10sec"));
            inv.setItem(3, main.API.itemStackManager.create(Material.CLOCK, ChatColor.GOLD + "Temps avant la fin de l'invincibilité:", Arrays.asList(ChatColor.GRAY + main.gameVariables.getTimeIntoString(main.gameVariables.graceTime))));
            inv.setItem(4, main.API.itemStackManager.create(Material.EMERALD, ChatColor.GREEN + "+ 10sec"));
            inv.setItem(5, main.API.itemStackManager.create(Material.EMERALD, ChatColor.GREEN + "+ 30sec"));
            inv.setItem(6, main.API.itemStackManager.create(Material.EMERALD, ChatColor.GREEN + "+ 1min"));
        }
        if(grace.equals("pvp")){
            inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Configuration > Timers > PVP");
            inv.setItem(0, main.API.itemStackManager.create(Material.REDSTONE, ChatColor.RED + "- 20min"));
            inv.setItem(1, main.API.itemStackManager.create(Material.REDSTONE, ChatColor.RED + "- 10min"));
            inv.setItem(2, main.API.itemStackManager.create(Material.REDSTONE, ChatColor.RED + "- 1min"));
            inv.setItem(3, main.API.itemStackManager.create(Material.CLOCK, ChatColor.GOLD + "Temps avant le PVP:", Arrays.asList(ChatColor.GRAY + main.gameVariables.getTimeIntoString(main.gameVariables.pvpTime))));
            inv.setItem(4, main.API.itemStackManager.create(Material.EMERALD, ChatColor.GREEN + "+ 1min"));
            inv.setItem(5, main.API.itemStackManager.create(Material.EMERALD, ChatColor.GREEN + "+ 10min"));
            inv.setItem(6, main.API.itemStackManager.create(Material.EMERALD, ChatColor.GREEN + "+ 20min"));
        }
        if(grace.equals("border")){
            inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Configuration > Timers > Bordure");
            inv.setItem(0, main.API.itemStackManager.create(Material.REDSTONE, ChatColor.RED + "- 30min"));
            inv.setItem(1, main.API.itemStackManager.create(Material.REDSTONE, ChatColor.RED + "- 15min"));
            inv.setItem(2, main.API.itemStackManager.create(Material.REDSTONE, ChatColor.RED + "- 5min"));
            inv.setItem(3, main.API.itemStackManager.create(Material.CLOCK, ChatColor.GOLD + "Temps avant la réduction de la bordure:", Arrays.asList(ChatColor.GRAY + main.gameVariables.getTimeIntoString(main.gameVariables.borderTime))));
            inv.setItem(4, main.API.itemStackManager.create(Material.EMERALD, ChatColor.GREEN + "+ 5min"));
            inv.setItem(5, main.API.itemStackManager.create(Material.EMERALD, ChatColor.GREEN + "+ 15min"));
            inv.setItem(6, main.API.itemStackManager.create(Material.EMERALD, ChatColor.GREEN + "+ 30min"));
        }


        inv.setItem(8, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière"));
        p.openInventory(inv);
    }

    public void openStartInventoryInventory(Player p) {
        Inventory inv = Bukkit.createInventory(null, 36, ChatColor.DARK_GREEN + "Configuration > Inventaire de départ");

        for(ItemStack it : main.gameVariables.startInventory){
            inv.addItem(it);
        }

        for(int i = 27; i <35; i++){
            inv.setItem(i, main.API.itemStackManager.create(Material.BLACK_STAINED_GLASS_PANE, ""));
        }
        inv.setItem(35, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière [Sauvegarder]"));

        p.openInventory(inv);
    }

    public void openTeamsInventory(Player p) {

            int activate = main.teamsManager.getActivateTeams();
            int teams = main.teamsManager.getTeams().size();

            Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GREEN + "Configuration > Equipes (" + activate + "/" + teams + ")");
            int slot = 0;
            for(Team team : main.teamsManager.getTeams()){
                if(!team.isActivated()){
                    inv.addItem(main.API.itemStackManager.create(team.getBanner(), team.getChatColor() + team.getName()));
                }else{
                    ItemStack it = main.API.itemStackManager.create(team.getBanner(), team.getChatColor() + team.getName());
                    ItemMeta m = it.getItemMeta();
                    m.setLore(Arrays.asList(ChatColor.GREEN + "Activée"));
                    it.setItemMeta(m);
                    inv.addItem(it);
                }
                slot = slot + 1;
                if(team.getChatColor().equals(ChatColor.GRAY)){
                    inv.setItem(slot, main.API.itemStackManager.create(Material.BLACK_STAINED_GLASS_PANE, " "));
                    slot = slot + 1;
                }
            }
            inv.setItem(53, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière"));
            p.openInventory(inv);

    }

    public void openBoderInventory(Player p) {

        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Configuration > Bordure");

        inv.setItem(1, main.API.itemStackManager.create(Material.BARRIER, ChatColor.GOLD + "Bordure avant la réduction", Arrays.asList(ChatColor.GRAY + "+" + main.gameVariables.preBorder + " / -" + main.gameVariables.preBorder, ChatColor.GREEN + "Clique gauche pour augmenter", ChatColor.RED + "Clique droit pour diminuer")));
        inv.setItem(3, main.API.itemStackManager.create(Material.CLOCK, ChatColor.GOLD + "Temps de réduction", Arrays.asList(ChatColor.GRAY + main.gameVariables.getTimeIntoString(main.gameVariables.reductionTime) + "(" + (Math.round(Math.round(main.gameVariables.preBorder - main.gameVariables.postBorder)/main.gameVariables.reductionTime)) + "blocks/sec)", ChatColor.GREEN + "Clique gauche pour augmenter", ChatColor.RED + "Clique droit pour diminuer")));
        inv.setItem(5, main.API.itemStackManager.create(Material.BARRIER, ChatColor.GOLD + "Bordure après la réduction", Arrays.asList(ChatColor.GRAY + "+" + main.gameVariables.postBorder + " / -" + main.gameVariables.postBorder, ChatColor.GREEN + "Clique gauche pour augmenter", ChatColor.RED + "Clique droit pour diminuer")));

        inv.setItem(8, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière"));
        p.openInventory(inv);

    }

    public void openItemsLimitsInventory(Player p) {
        Inventory inv = Bukkit.createInventory(null, 36, ChatColor.DARK_GREEN + "Configuration > Limites d'items");

        for(Material mat : main.gameVariables.itemsLimits.keySet()){
            ItemStack it = new ItemStack(mat, main.gameVariables.itemsLimits.get(mat));
            inv.addItem(it);
        }

        for(int i = 27; i <35; i++){
            inv.setItem(i, main.API.itemStackManager.create(Material.BLACK_STAINED_GLASS_PANE, ""));
        }
        inv.setItem(35, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière [Sauvegarder]"));

        p.openInventory(inv);
    }

    public void openArmorLimitsInventory(Player p){

        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Configuration > Limites d'armure");

        inv.setItem(1, main.API.itemStackManager.create(Material.LEATHER_CHESTPLATE, main.gameVariables.leatherLimit, ChatColor.GOLD + "Pièces en cuir autorisées: " + main.gameVariables.leatherLimit, Arrays.asList(ChatColor.GREEN + "Clique gauche pour augmenter", ChatColor.RED + "Clique droit pour baisser")));
        inv.setItem(2, main.API.itemStackManager.create(Material.CHAINMAIL_CHESTPLATE, main.gameVariables.chainLimit, ChatColor.GOLD + "Pièces en chaîne autorisées: " + main.gameVariables.chainLimit, Arrays.asList(ChatColor.GREEN + "Clique gauche pour augmenter", ChatColor.RED + "Clique droit pour baisser")));
        inv.setItem(3, main.API.itemStackManager.create(Material.IRON_CHESTPLATE, main.gameVariables.ironLimit, ChatColor.GOLD + "Pièces en fer autorisées: " + main.gameVariables.ironLimit, Arrays.asList(ChatColor.GREEN + "Clique gauche pour augmenter", ChatColor.RED + "Clique droit pour baisser")));
        inv.setItem(4, main.API.itemStackManager.create(Material.GOLDEN_CHESTPLATE, main.gameVariables.goldLimit, ChatColor.GOLD + "Pièces en or autorisées: " + main.gameVariables.goldLimit, Arrays.asList(ChatColor.GREEN + "Clique gauche pour augmenter", ChatColor.RED + "Clique droit pour baisser")));
        inv.setItem(5, main.API.itemStackManager.create(Material.DIAMOND_CHESTPLATE, main.gameVariables.diamondLimit, ChatColor.GOLD + "Pièces en diamant autorisées: " + main.gameVariables.diamondLimit, Arrays.asList(ChatColor.GREEN + "Clique gauche pour augmenter", ChatColor.RED + "Clique droit pour baisser")));

        inv.setItem(8, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière"));
        p.openInventory(inv);

    }

    public void openEnchantmentLimitsInventory(Player p){
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Configuration > Limites d'enchantement");

        inv.setItem(2, main.API.itemStackManager.create(Material.IRON_CHESTPLATE, ChatColor.GOLD + "Limite de Protection: " + main.gameVariables.ironProteclimit, Arrays.asList(ChatColor.GREEN + "Clique gauche pour augmenter", ChatColor.RED + "Clique droit pour baisser")));
        inv.setItem(3, main.API.itemStackManager.create(Material.DIAMOND_CHESTPLATE, ChatColor.GOLD + "Limite de Protection: " + main.gameVariables.diamondProtecLimit, Arrays.asList(ChatColor.GREEN + "Clique gauche pour augmenter", ChatColor.RED + "Clique droit pour baisser")));
        inv.setItem(4, main.API.itemStackManager.create(Material.IRON_SWORD, ChatColor.GOLD + "Limite de Sharpness: " + main.gameVariables.ironSharpLimit, Arrays.asList(ChatColor.GREEN + "Clique gauche pour augmenter", ChatColor.RED + "Clique droit pour baisser")));
        inv.setItem(5, main.API.itemStackManager.create(Material.DIAMOND_SWORD, ChatColor.GOLD + "Limite de Sharpness: " + main.gameVariables.diamondSharpLimit, Arrays.asList(ChatColor.GREEN + "Clique gauche pour augmenter", ChatColor.RED + "Clique droit pour baisser")));

        inv.setItem(8, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière"));
        p.openInventory(inv);
    }

    public void openChatInventory(Player p) {

        Inventory inv = Bukkit.createInventory(null, 18, ChatColor.DARK_GREEN + "Configuration > Chat");

        if(main.gameVariables.globalChat){
            inv.setItem(2, main.API.itemStackManager.create(Material.EMERALD_BLOCK, ChatColor.GOLD + "Chat général activé", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
            if(main.gameVariables.anonymGlobalChat){
                inv.setItem(11, main.API.itemStackManager.create(Material.EMERALD, ChatColor.YELLOW + "Chat général anonyme", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
            }else{
                inv.setItem(11, main.API.itemStackManager.create(Material.REDSTONE, ChatColor.YELLOW + "Chat général avec pseudos", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
            }
        }else{
            inv.setItem(2, main.API.itemStackManager.create(Material.REDSTONE_BLOCK, ChatColor.GOLD + "Chat général désactivé", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
        }

        if(main.gameVariables.teamChat){
            inv.setItem(6, main.API.itemStackManager.create(Material.EMERALD_BLOCK, ChatColor.GOLD + "Chat d'équipe activé", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
            if(main.gameVariables.anonymTeamChat){
                inv.setItem(15, main.API.itemStackManager.create(Material.EMERALD, ChatColor.YELLOW + "Chat d'équipe anonyme", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
            }else{
                inv.setItem(15, main.API.itemStackManager.create(Material.REDSTONE, ChatColor.YELLOW + "Chat d'équipe avec pseudos", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
            }
        }else{
            inv.setItem(6, main.API.itemStackManager.create(Material.REDSTONE_BLOCK, ChatColor.GOLD + "Chat d'équipe désactivé", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
        }

        inv.setItem(17, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière"));
        p.openInventory(inv);
    }

    public void openAffichageInventory(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Configuration > Affichage");

        if(main.gameVariables.afficheTimers) {
            inv.setItem(2, main.API.itemStackManager.create(Material.CLOCK, ChatColor.GOLD + "Affichage des timers: activé", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
        }else{
            inv.setItem(2, main.API.itemStackManager.create(Material.CLOCK, ChatColor.GOLD + "Affichage des timers: désactivé", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
        }
        if(main.gameVariables.afficheBorder) {
            inv.setItem(3, main.API.itemStackManager.create(Material.BARRIER, ChatColor.GOLD + "Affichage des coordonées de la bordure: activé", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
        }else{
            inv.setItem(3, main.API.itemStackManager.create(Material.BARRIER, ChatColor.GOLD + "Affichage des coordonées de la bordure: désactivé", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
        }
        if(main.gameVariables.afficheHealth) {
            inv.setItem(4, main.API.itemStackManager.create(Material.GLISTERING_MELON_SLICE, ChatColor.GOLD + "Affichage de la vie dans le tab: activé", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
        }else{
            inv.setItem(4, main.API.itemStackManager.create(Material.GLISTERING_MELON_SLICE, ChatColor.GOLD + "Affichage de la vie dans le tab: désactivé", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
        }
        if(main.gameVariables.afficheKiller) {
            inv.setItem(5, main.API.itemStackManager.create(Material.DIAMOND_SWORD, ChatColor.GOLD + "Affichage du tueur: activé", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
        }else{
            inv.setItem(5, main.API.itemStackManager.create(Material.DIAMOND_SWORD, ChatColor.GOLD + "Affichage du tueur: désactivé", Arrays.asList(ChatColor.GRAY + "Cliquer pour modifier")));
        }

        inv.setItem(8, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière"));
        p.openInventory(inv);
    }

    public void openScenariosInventory(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GREEN + "Configuration > Scénarios");

        for(GameScenario gameScenario : main.gameScenariosManager.getGameScenarios()){
            if(!gameScenario.isActivated()) {
                inv.addItem(main.API.itemStackManager.create(gameScenario.getMaterial(), ChatColor.GOLD + gameScenario.getName() + ": Désactivé", gameScenario.getLore()));
            } else{
                ItemStack it = main.API.itemStackManager.create(gameScenario.getMaterial(), ChatColor.GOLD + gameScenario.getName() + ": Activé" , gameScenario.getLore());
                it.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                ItemMeta itM = it.getItemMeta();
                itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                it.setItemMeta(itM);
                inv.addItem(it);
            }
        }

        inv.setItem(53, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière"));
        p.openInventory(inv);
    }

         public void openCraftInventory(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GREEN + "Configuration > Crafts");

        for(int i = 0; i < 54; i++){
            inv.setItem(i, main.API.itemStackManager.create(Material.WHITE_STAINED_GLASS_PANE, " "));
        }

        inv.setItem(10, null);
        inv.setItem(11, null);
        inv.setItem(12, null);
        inv.setItem(19, null);
        inv.setItem(20, null);
        inv.setItem(21, null);
        inv.setItem(28, null);
        inv.setItem(29, null);
        inv.setItem(30, null);
        inv.setItem(24, null);

        inv.setItem(26, main.API.itemStackManager.create(Material.EMERALD_BLOCK, ChatColor.GREEN + "Valider le craft"));

        inv.setItem(49, main.API.itemStackManager.create(Material.CHEST, ChatColor.GOLD + "Liste des crafts"));

        inv.setItem(53, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière"));
        p.openInventory(inv);
    }

    public void openCraftsListInventory(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GREEN + "Configuration > Crafts > Liste");

        for(CustomCraft customCraft : main.customCraftManager.getCustomCrafts()){
            ItemStack it = customCraft.getResult().clone();

            ArrayList<String> lore = new ArrayList<>();

            lore.add(ChatColor.GRAY + "| " + customCraft.getAa().getType().name() + " | " + customCraft.getAb().getType().name() + " | " + customCraft.getAc().getType().name() + " |");
            lore.add(ChatColor.GRAY + "| " + customCraft.getBa().getType().name() + " | " + customCraft.getBb().getType().name() + " | " + customCraft.getBc().getType().name() + " |");
            lore.add(ChatColor.GRAY + "| " + customCraft.getCa().getType().name() + " | " + customCraft.getCb().getType().name() + " | " + customCraft.getCc().getType().name() + " |");
            lore.add(" ");
            lore.add(ChatColor.RED + "Clique droit pour supprimer");

            ItemMeta itM = it.getItemMeta();
            itM.setDisplayName(ChatColor.GOLD + "Recette customisée");
            itM.setLore(lore);
            it.setItemMeta(itM);

            net.minecraft.server.v1_15_R1.ItemStack nms = CraftItemStack.asNMSCopy(it);
            NBTTagCompound com = nms.getTag() != null ? nms.getTag() : new NBTTagCompound();
            com.setString("uuid", customCraft.getUuid().toString());
            nms.setTag(com);
            it = CraftItemStack.asCraftMirror(nms);

            inv.addItem(it);
        }

        inv.setItem(53, main.API.itemStackManager.create(Material.ARROW, ChatColor.GRAY + "Revenir en arrière"));
        p.openInventory(inv);
    }
}

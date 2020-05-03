package ch.dams333.betterUHC.inventories;

import ch.dams333.betterUHC.BetterUHC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TeamInventoriesGenerator {
    BetterUHC main;
    public TeamInventoriesGenerator(BetterUHC betterUHC) {
        this.main = betterUHC;
    }

    public void openMenuInventory(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GREEN + "Sélection d'une équipe");
        if(main.gameVariables.infiniteTeams){
            if(main.gameVariables.whiteTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.white){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "white")){
                    ItemStack i = main.API.itemStackManager.create(Material.WHITE_WOOL, ChatColor.GOLD + "Equipe blanche", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(11, i);
                }else {
                    inv.setItem(11, main.API.itemStackManager.create(Material.WHITE_WOOL, ChatColor.GOLD + "Equipe blanche", players));
                }
            }
            if(main.gameVariables.orangeTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.orange){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "orange")){
                    ItemStack i = main.API.itemStackManager.create(Material.ORANGE_WOOL, ChatColor.GOLD + "Equipe orange", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(12, i);
                }else {
                    inv.setItem(12, main.API.itemStackManager.create(Material.ORANGE_WOOL, ChatColor.GOLD + "Equipe orange", players));
                }
            }
            if(main.gameVariables.magentaTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.magenta){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "magenta")){
                    ItemStack i = main.API.itemStackManager.create(Material.MAGENTA_WOOL, ChatColor.GOLD + "Equipe magenta", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(13, i);
                }else {
                    inv.setItem(13, main.API.itemStackManager.create(Material.MAGENTA_WOOL, ChatColor.GOLD + "Equipe magenta", players));
                }
            }
            if(main.gameVariables.lightBlueTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.lightblue){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "lightblue")){
                    ItemStack i = main.API.itemStackManager.create(Material.LIGHT_BLUE_WOOL, ChatColor.GOLD + "Equipe bleue clair", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(14, i);
                }else {
                    inv.setItem(14, main.API.itemStackManager.create(Material.LIGHT_BLUE_WOOL, ChatColor.GOLD + "Equipe bleue clair", players));
                }
            }
            if(main.gameVariables.yellowTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.yellow){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "yellow")){
                    ItemStack i = main.API.itemStackManager.create(Material.YELLOW_WOOL, ChatColor.GOLD + "Equipe jaune", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(15, i);
                }else {
                    inv.setItem(15, main.API.itemStackManager.create(Material.YELLOW_WOOL, ChatColor.GOLD + "Equipe jaune", players));
                }
            }
            if(main.gameVariables.limeTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.lime){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "lime")){
                    ItemStack i = main.API.itemStackManager.create(Material.LIME_WOOL, ChatColor.GOLD + "Equipe verte clair", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(20, i);
                }else {
                    inv.setItem(20, main.API.itemStackManager.create(Material.LIME_WOOL, ChatColor.GOLD + "Equipe verte clair", players));
                }
            }
            if(main.gameVariables.pinkTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.pink){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "pink")){
                    ItemStack i = main.API.itemStackManager.create(Material.PINK_WOOL, ChatColor.GOLD + "Equipe rose", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(21, i);
                }else {
                    inv.setItem(21, main.API.itemStackManager.create(Material.PINK_WOOL, ChatColor.GOLD + "Equipe rose", players));
                }
            }
            if(main.gameVariables.grayTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.gray){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "gray")){
                    ItemStack i = main.API.itemStackManager.create(Material.GRAY_WOOL, ChatColor.GOLD + "Equipe grise", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(22, i);
                }else {
                    inv.setItem(22, main.API.itemStackManager.create(Material.GRAY_WOOL, ChatColor.GOLD + "Equipe grise", players));
                }
            }
            if(main.gameVariables.lightGrayTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.lightgray){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "lightgray")){
                    ItemStack i = main.API.itemStackManager.create(Material.LIGHT_GRAY_WOOL, ChatColor.GOLD + "Equipe grise clair", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(23, i);
                }else {
                    inv.setItem(23, main.API.itemStackManager.create(Material.LIGHT_GRAY_WOOL, ChatColor.GOLD + "Equipe grise clair", players));
                }
            }
            if(main.gameVariables.cyanTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.cyan){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "cyan")){
                    ItemStack i = main.API.itemStackManager.create(Material.CYAN_WOOL, ChatColor.GOLD + "Equipe cyan", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(24, i);
                }else {
                    inv.setItem(24, main.API.itemStackManager.create(Material.CYAN_WOOL, ChatColor.GOLD + "Equipe cyan", players));
                }
            }
            if(main.gameVariables.purpleTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.purple){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "purple")){
                    ItemStack i = main.API.itemStackManager.create(Material.PURPLE_WOOL, ChatColor.GOLD + "Equipe violette", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(29, i);
                }else {
                    inv.setItem(29, main.API.itemStackManager.create(Material.PURPLE_WOOL, ChatColor.GOLD + "Equipe violette", players));
                }
            }
            if(main.gameVariables.blueTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.blue){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "blue")){
                    ItemStack i = main.API.itemStackManager.create(Material.BLUE_WOOL, ChatColor.GOLD + "Equipe bleue", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(30, i);
                }else {
                    inv.setItem(30, main.API.itemStackManager.create(Material.BLUE_WOOL, ChatColor.GOLD + "Equipe bleue", players));
                }
            }
            if(main.gameVariables.brownTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.brown){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "brown")){
                    ItemStack i = main.API.itemStackManager.create(Material.BROWN_WOOL, ChatColor.GOLD + "Equipe brune", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(31, i);
                }else {
                    inv.setItem(31, main.API.itemStackManager.create(Material.BROWN_WOOL, ChatColor.GOLD + "Equipe brune", players));
                }
            }
            if(main.gameVariables.greenTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.green){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "green")){
                    ItemStack i = main.API.itemStackManager.create(Material.GREEN_WOOL, ChatColor.GOLD + "Equipe verte", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(32, i);
                }else {
                    inv.setItem(32, main.API.itemStackManager.create(Material.GREEN_WOOL, ChatColor.GOLD + "Equipe verte", players));
                }
            }
            if(main.gameVariables.redTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.red){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "red")){
                    ItemStack i = main.API.itemStackManager.create(Material.RED_WOOL, ChatColor.GOLD + "Equipe rouge", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(33, i);
                }else {
                    inv.setItem(33, main.API.itemStackManager.create(Material.RED_WOOL, ChatColor.GOLD + "Equipe rouge", players));
                }
            }
            if(main.gameVariables.blackTeam < 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.black){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                if(main.teamsManager.isInTeam(p, "black")){
                    ItemStack i = main.API.itemStackManager.create(Material.BLACK_WOOL, ChatColor.GOLD + "Equipe noire", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(40, i);
                }else {
                    inv.setItem(40, main.API.itemStackManager.create(Material.BLACK_WOOL, ChatColor.GOLD + "Equipe noire", players));
                }
            }



        }else{
            if(main.gameVariables.whiteTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.white){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.whiteTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "white")){
                    ItemStack i = main.API.itemStackManager.create(Material.WHITE_WOOL, ChatColor.GOLD + "Equipe blanche", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(11, i);
                }else {
                    inv.setItem(11, main.API.itemStackManager.create(Material.WHITE_WOOL, ChatColor.GOLD + "Equipe blanche", players));
                }
            }
            if(main.gameVariables.orangeTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.orange){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.orangeTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "orange")){
                    ItemStack i = main.API.itemStackManager.create(Material.ORANGE_WOOL, ChatColor.GOLD + "Equipe orange", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(12, i);
                }else {
                    inv.setItem(12, main.API.itemStackManager.create(Material.ORANGE_WOOL, ChatColor.GOLD + "Equipe blanche", players));
                }
            }
            if(main.gameVariables.magentaTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.magenta){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.magentaTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "magenta")){
                    ItemStack i = main.API.itemStackManager.create(Material.MAGENTA_WOOL, ChatColor.GOLD + "Equipe magenta", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(13, i);
                }else {
                    inv.setItem(13, main.API.itemStackManager.create(Material.MAGENTA_WOOL, ChatColor.GOLD + "Equipe magenta", players));
                }
            }
            if(main.gameVariables.lightBlueTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.lightblue){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.lightBlueTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "lightblue")){
                    ItemStack i = main.API.itemStackManager.create(Material.LIGHT_BLUE_WOOL, ChatColor.GOLD + "Equipe bleue clair", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(14, i);
                }else {
                    inv.setItem(14, main.API.itemStackManager.create(Material.LIGHT_BLUE_WOOL, ChatColor.GOLD + "Equipe bleue clair", players));
                }
            }
            if(main.gameVariables.yellowTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.yellow){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.yellowTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "yellow")){
                    ItemStack i = main.API.itemStackManager.create(Material.YELLOW_WOOL, ChatColor.GOLD + "Equipe jaune", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(15, i);
                }else {
                    inv.setItem(15, main.API.itemStackManager.create(Material.YELLOW_WOOL, ChatColor.GOLD + "Equipe jaune", players));
                }
            }
            if(main.gameVariables.limeTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.lime){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.limeTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "lime")){
                    ItemStack i = main.API.itemStackManager.create(Material.LIME_WOOL, ChatColor.GOLD + "Equipe verte clair", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(20, i);
                }else {
                    inv.setItem(20, main.API.itemStackManager.create(Material.LIME_WOOL, ChatColor.GOLD + "Equipe verte clair", players));
                }
            }
            if(main.gameVariables.pinkTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.pink){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.pinkTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "pink")){
                    ItemStack i = main.API.itemStackManager.create(Material.PINK_WOOL, ChatColor.GOLD + "Equipe rose", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(21, i);
                }else {
                    inv.setItem(21, main.API.itemStackManager.create(Material.PINK_WOOL, ChatColor.GOLD + "Equipe rose", players));
                }
            }
            if(main.gameVariables.grayTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.gray){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.grayTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "gray")){
                    ItemStack i = main.API.itemStackManager.create(Material.GRAY_WOOL, ChatColor.GOLD + "Equipe grise", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(22, i);
                }else {
                    inv.setItem(22, main.API.itemStackManager.create(Material.GRAY_WOOL, ChatColor.GOLD + "Equipe grise", players));
                }
            }
            if(main.gameVariables.lightGrayTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.lightgray){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.lightGrayTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "lightgray")){
                    ItemStack i = main.API.itemStackManager.create(Material.LIGHT_GRAY_WOOL, ChatColor.GOLD + "Equipe grise clair", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(23, i);
                }else {
                    inv.setItem(23, main.API.itemStackManager.create(Material.LIGHT_GRAY_WOOL, ChatColor.GOLD + "Equipe grise clair", players));
                }
            }
            if(main.gameVariables.cyanTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.cyan){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.cyanTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "cyan")){
                    ItemStack i = main.API.itemStackManager.create(Material.CYAN_WOOL, ChatColor.GOLD + "Equipe cyan", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(24, i);
                }else {
                    inv.setItem(24, main.API.itemStackManager.create(Material.CYAN_WOOL, ChatColor.GOLD + "Equipe cyan", players));
                }
            }
            if(main.gameVariables.purpleTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.purple){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.purpleTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "purple")){
                    ItemStack i = main.API.itemStackManager.create(Material.PURPLE_WOOL, ChatColor.GOLD + "Equipe violette", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(29, i);
                }else {
                    inv.setItem(29, main.API.itemStackManager.create(Material.PURPLE_WOOL, ChatColor.GOLD + "Equipe violette", players));
                }
            }
            if(main.gameVariables.blueTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.blue){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.blueTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "blue")){
                    ItemStack i = main.API.itemStackManager.create(Material.BLUE_WOOL, ChatColor.GOLD + "Equipe bleue", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(30, i);
                }else {
                    inv.setItem(30, main.API.itemStackManager.create(Material.BLUE_WOOL, ChatColor.GOLD + "Equipe bleue", players));
                }
            }
            if(main.gameVariables.brownTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.brown){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.brownTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "brown")){
                    ItemStack i = main.API.itemStackManager.create(Material.BROWN_WOOL, ChatColor.GOLD + "Equipe brune", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(31, i);
                }else {
                    inv.setItem(31, main.API.itemStackManager.create(Material.BROWN_WOOL, ChatColor.GOLD + "Equipe brune", players));
                }
            }
            if(main.gameVariables.greenTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.green){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.greenTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "green")){
                    ItemStack i = main.API.itemStackManager.create(Material.GREEN_WOOL, ChatColor.GOLD + "Equipe verte", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(32, i);
                }else {
                    inv.setItem(32, main.API.itemStackManager.create(Material.GREEN_WOOL, ChatColor.GOLD + "Equipe verte", players));
                }
            }
            if(main.gameVariables.redTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.red){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.redTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "red")){
                    ItemStack i = main.API.itemStackManager.create(Material.RED_WOOL, ChatColor.GOLD + "Equipe rouge", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(33, i);
                }else {
                    inv.setItem(33, main.API.itemStackManager.create(Material.RED_WOOL, ChatColor.GOLD + "Equipe rouge", players));
                }
            }
            if(main.gameVariables.blackTeam > 0){
                List<String> players = new ArrayList<>();
                for(Player pl : main.teamsManager.black){
                    players.add(ChatColor.GRAY + "- " + pl.getName());
                }
                for(int i = main.gameVariables.blackTeam - players.size(); i > 0; i--){
                    players.add(ChatColor.GRAY + "- [Espace vide]");
                }
                if(main.teamsManager.isInTeam(p, "black")){
                    ItemStack i = main.API.itemStackManager.create(Material.BLACK_WOOL, ChatColor.GOLD + "Equipe noire", players);
                    i.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                    ItemMeta iM = i.getItemMeta();
                    iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    i.setItemMeta(iM);
                    inv.setItem(40, i);
                }else {
                    inv.setItem(40, main.API.itemStackManager.create(Material.BLACK_WOOL, ChatColor.GOLD + "Equipe noire", players));
                }
            }
        }
        p.openInventory(inv);
    }
}

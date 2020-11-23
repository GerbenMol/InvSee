package com.InvSeeCreatedByGerben.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class InvSeeCommand implements CommandExecutor {
    public static Inventory gui;
    public static Player p;
    public static Player target;
    private static int counter = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        p = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players may execute this command!!");
            return true;
        }
        if (!(args.length == 1)){
            p.sendMessage(ChatColor.RED+"Wrong usage: /invsee [player]");
            return false;
        } else if (!(p.hasPermission("Invsee.Others"))) {
            p.sendMessage(ChatColor.RED+"You dont have the permissions to run this command!");
            return false;
        }
        target = (Player) Bukkit.getPlayer(args[0]);
        if (target == null){
            p.sendMessage(ChatColor.RED+"The player is not online or is not spelled correctly!");
            return false;
        }
        if (target == p) {
            p.sendMessage(ChatColor.RED+"You cannot check your own inventory");
            return false;
        }
        if (target.hasPermission("invsee.prevent")){
            p.sendMessage(ChatColor.RED+"You cannot open this inventory because the player has the permissions to prevent it!");
            return false;
        }

        gui = Bukkit.createInventory(p, 54,"Inventory of: "+target.getName());
        ItemStack[] targetinv = target.getInventory().getContents();
        gui.setContents(targetinv);

        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemStack offhand = new ItemStack(Material.SHIELD);

        ItemMeta helmet_meta = helmet.getItemMeta();
        ItemMeta chestplate_meta = chestplate.getItemMeta();
        ItemMeta leggings_meta = leggings.getItemMeta();
        ItemMeta boots_meta = boots.getItemMeta();
        ItemMeta offhand_meta = offhand.getItemMeta();

        helmet_meta.setDisplayName(ChatColor.GOLD+"Helmet");
        chestplate_meta.setDisplayName(ChatColor.GOLD+"Chestplate");
        leggings_meta.setDisplayName(ChatColor.GOLD+"Leggings");
        boots_meta.setDisplayName(ChatColor.GOLD+"Boots");
        offhand_meta.setDisplayName(ChatColor.GOLD+"Offhand");

        ArrayList<String> helmet_lore = new ArrayList<>();
        ArrayList<String> chestplate_lore = new ArrayList<>();
        ArrayList<String> leggings_lore = new ArrayList<>();
        ArrayList<String> boots_lore = new ArrayList<>();
        ArrayList<String> offhand_lore = new ArrayList<>();

        helmet_lore.add(ChatColor.BLUE+"The slot above this slot is the");
        helmet_lore.add(ChatColor.BLUE+"helmet slot of "+target.getDisplayName());
        chestplate_lore.add(ChatColor.BLUE+"The slot above this slot is the");
        chestplate_lore.add(ChatColor.BLUE+"chestplate slot of "+target.getDisplayName());
        leggings_lore.add(ChatColor.BLUE+"The slot above this slot is the"+target.getDisplayName());
        leggings_lore.add(ChatColor.BLUE+"leggings slot of "+target.getDisplayName());
        boots_lore.add(ChatColor.BLUE+"The slot above this slot is the"+target.getDisplayName());
        boots_lore.add(ChatColor.BLUE+"boots slot of "+target.getDisplayName());
        offhand_lore.add(ChatColor.BLUE+"The slot above this slot is the"+target.getDisplayName());
        offhand_lore.add(ChatColor.BLUE+"offhand slot of "+target.getDisplayName());
        offhand_lore.add(ChatColor.BLUE+"To add an item here right click the item");

        helmet_meta.setLore(helmet_lore);
        chestplate_meta.setLore(chestplate_lore);
        leggings_meta.setLore(leggings_lore);
        boots_meta.setLore(boots_lore);
        offhand_meta.setLore(offhand_lore);

        helmet_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        helmet_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        helmet_meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        helmet_meta.addItemFlags(ItemFlag.HIDE_DYE);
        helmet_meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        helmet_meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        helmet_meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        chestplate_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        chestplate_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        chestplate_meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        chestplate_meta.addItemFlags(ItemFlag.HIDE_DYE);
        chestplate_meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        chestplate_meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        chestplate_meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        leggings_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        leggings_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        leggings_meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        leggings_meta.addItemFlags(ItemFlag.HIDE_DYE);
        leggings_meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        leggings_meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        leggings_meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        boots_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        boots_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        boots_meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        boots_meta.addItemFlags(ItemFlag.HIDE_DYE);
        boots_meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        boots_meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        boots_meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        offhand_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        offhand_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        offhand_meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        offhand_meta.addItemFlags(ItemFlag.HIDE_DYE);
        offhand_meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        offhand_meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        offhand_meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        offhand_meta.addEnchant(Enchantment.LUCK, 1, false);
        helmet_meta.addEnchant(Enchantment.LUCK, 1, false);
        chestplate_meta.addEnchant(Enchantment.LUCK, 1, false);
        leggings_meta.addEnchant(Enchantment.LUCK, 1, false);
        boots_meta.addEnchant(Enchantment.LUCK, 1, true);

        helmet.setItemMeta(helmet_meta);
        chestplate.setItemMeta(chestplate_meta);
        leggings.setItemMeta(leggings_meta);
        boots.setItemMeta(boots_meta);
        offhand.setItemMeta(offhand_meta);

        gui.setItem(41, new ItemStack(Material.RED_STAINED_GLASS_PANE));
        gui.setItem(42, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
        gui.setItem(43, new ItemStack(Material.RED_STAINED_GLASS_PANE));
        gui.setItem(44, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
        gui.setItem(50, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
        gui.setItem(51, new ItemStack(Material.RED_STAINED_GLASS_PANE));
        gui.setItem(52, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
        gui.setItem(53, new ItemStack(Material.RED_STAINED_GLASS_PANE));

        gui.setItem(45, boots);
        gui.setItem(46, leggings);
        gui.setItem(47, chestplate);
        gui.setItem(48, helmet);
        gui.setItem(49, offhand);

        p.openInventory(gui);
        return false;
    }
}


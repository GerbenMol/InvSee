package com.InvSeeCreatedByGerben.Events;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class InvSeeEvent implements Listener {
    private static Inventory gui;
    private static Player p;
    private static Player target;
    private static String title;
    private static ItemStack[] targetinv;
    private static ItemStack clickeditem = null;
    private static String name;
    private static String targettitle;
    private static Inventory guilive;
    private static int click1 = 0;

    @EventHandler
    public void onClick(InventoryClickEvent e) throws IOException, InterruptedException {
        try{
            click1 = e.getSlot();

            try {
                title = e.getView().getTitle();
                targettitle = title.substring(14);
                target = (Player) Bukkit.getPlayer(targettitle);
                if(target == null){
                    e.setCancelled(true);
                }
            } catch(StringIndexOutOfBoundsException ignored){

            }
            if (!(p.hasPermission("invsee.others"))){
                p.closeInventory();
                p.sendMessage(ChatColor.RED+"You can no longer open this inventory because your permissions to do this have been revoked!");
                e.setCancelled(true);
            }
            if (target.hasPermission("invsee.prevent")){
                p.closeInventory();
                p.sendMessage(ChatColor.RED+"This players inventory cannot be shown anymore because he got the permissions to prevent this!");
                e.setCancelled(true);
            }
            if (click1 >= 0) {
                if (click1 <= 53) {
                    if (title.equalsIgnoreCase("Inventory of: " + target.getName())) {

                        name = target.getDisplayName();

                        p = (Player) e.getWhoClicked();

                        clickeditem = target.getInventory().getItem(click1);

                        gui = Bukkit.createInventory(target, 54, target.getName());
                        guilive = Bukkit.createInventory(target, 54, "Inventory of: " + target.getName());

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

                        helmet_meta.setDisplayName(ChatColor.GOLD + "Helmet");
                        chestplate_meta.setDisplayName(ChatColor.GOLD + "Chestplate");
                        leggings_meta.setDisplayName(ChatColor.GOLD + "Leggings");
                        boots_meta.setDisplayName(ChatColor.GOLD + "Boots");
                        offhand_meta.setDisplayName(ChatColor.GOLD + "Offhand");

                        ArrayList<String> helmet_lore = new ArrayList<>();
                        ArrayList<String> chestplate_lore = new ArrayList<>();
                        ArrayList<String> leggings_lore = new ArrayList<>();
                        ArrayList<String> boots_lore = new ArrayList<>();
                        ArrayList<String> offhand_lore = new ArrayList<>();

                        helmet_lore.add(ChatColor.BLUE + "The slot above this slot is the");
                        helmet_lore.add(ChatColor.BLUE + "helmet slot of " + target.getDisplayName());
                        chestplate_lore.add(ChatColor.BLUE + "The slot above this slot is the");
                        chestplate_lore.add(ChatColor.BLUE + "chestplate slot of " + target.getDisplayName());
                        leggings_lore.add(ChatColor.BLUE + "The slot above this slot is the" + target.getDisplayName());
                        leggings_lore.add(ChatColor.BLUE + "leggings slot of " + target.getDisplayName());
                        boots_lore.add(ChatColor.BLUE + "The slot above this slot is the" + target.getDisplayName());
                        boots_lore.add(ChatColor.BLUE + "boots slot of " + target.getDisplayName());
                        offhand_lore.add(ChatColor.BLUE + "The slot above this slot is the");
                        offhand_lore.add(ChatColor.BLUE + "offhand slot of " + target.getDisplayName());
                        offhand_lore.add(ChatColor.BLUE + "To add an item here right click the item");

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

                        targetinv = target.getInventory().getContents();

                        gui.setContents(targetinv);
                        guilive.setContents(targetinv);

                        guilive.setItem(41, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                        guilive.setItem(42, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
                        guilive.setItem(43, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                        guilive.setItem(44, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
                        guilive.setItem(50, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
                        guilive.setItem(51, new ItemStack(Material.RED_STAINED_GLASS_PANE));
                        guilive.setItem(52, new ItemStack(Material.GREEN_STAINED_GLASS_PANE));
                        guilive.setItem(53, new ItemStack(Material.RED_STAINED_GLASS_PANE));

                        guilive.setItem(45, boots);
                        guilive.setItem(46, leggings);
                        guilive.setItem(47, chestplate);
                        guilive.setItem(48, helmet);
                        guilive.setItem(49, offhand);

                        p.openInventory(guilive);

                        if (clickeditem == null) {
                            clickeditem = new ItemStack(Material.AIR);
                        }

                        String invcheck1 = String.valueOf(e.getClickedInventory().getItem(1));
                        String targetinvcheck1 = String.valueOf(target.getInventory().getItem(1));
                        String invcheck2 = String.valueOf(e.getClickedInventory().getItem(2));
                        String targetinvcheck2 = String.valueOf(target.getInventory().getItem(2));
                        String invcheck3 = String.valueOf(e.getClickedInventory().getItem(3));
                        String targetinvcheck3 = String.valueOf(target.getInventory().getItem(3));
                        String invcheck4 = String.valueOf(e.getClickedInventory().getItem(4));
                        String targetinvcheck4 = String.valueOf(target.getInventory().getItem(4));
                        String invcheck5 = String.valueOf(e.getClickedInventory().getItem(5));
                        String targetinvcheck5 = String.valueOf(target.getInventory().getItem(5));
                        String invcheck6 = String.valueOf(e.getClickedInventory().getItem(6));
                        String targetinvcheck6 = String.valueOf(target.getInventory().getItem(6));
                        String invcheck7 = String.valueOf(e.getClickedInventory().getItem(7));
                        String targetinvcheck7 = String.valueOf(target.getInventory().getItem(7));
                        String invcheck8 = String.valueOf(e.getClickedInventory().getItem(8));
                        String targetinvcheck8 = String.valueOf(target.getInventory().getItem(8));
                        String invcheck9 = String.valueOf(e.getClickedInventory().getItem(9));
                        String targetinvcheck9 = String.valueOf(target.getInventory().getItem(9));
                        String invcheck10 = String.valueOf(e.getClickedInventory().getItem(10));
                        String targetinvcheck10 = String.valueOf(target.getInventory().getItem(10));
                        String invcheck11 = String.valueOf(e.getClickedInventory().getItem(11));
                        String targetinvcheck11 = String.valueOf(target.getInventory().getItem(11));
                        String invcheck12 = String.valueOf(e.getClickedInventory().getItem(12));
                        String targetinvcheck12 = String.valueOf(target.getInventory().getItem(12));

                        if (invcheck1.equals(targetinvcheck1)) {
                            if (invcheck2.equals(targetinvcheck2)) {
                                if (invcheck3.equals(targetinvcheck3)) {
                                    if (invcheck4.equals(targetinvcheck4)) {
                                        if (invcheck5.equals(targetinvcheck5)) {
                                            if (invcheck6.equals(targetinvcheck6)) {
                                                if (invcheck7.equals(targetinvcheck7)) {
                                                    if (invcheck8.equals(targetinvcheck8)) {
                                                        if (invcheck9.equals(targetinvcheck9)) {
                                                            if (invcheck10.equals(targetinvcheck10)) {
                                                                if (invcheck11.equals(targetinvcheck11)) {
                                                                    if (invcheck12.equals(targetinvcheck12)) {
                                                                        if (click1 == 41) {
                                                                            e.setCancelled(true);
                                                                            Thread.sleep(10);
                                                                            e.setCancelled(false);
                                                                        } else if (click1 == 42) {
                                                                            e.setCancelled(true);
                                                                            Thread.sleep(10);
                                                                            e.setCancelled(false);
                                                                        } else if (click1 == 43) {
                                                                            e.setCancelled(true);
                                                                            Thread.sleep(10);
                                                                            e.setCancelled(false);
                                                                        } else if (click1 == 44) {
                                                                            e.setCancelled(true);
                                                                            Thread.sleep(10);
                                                                            e.setCancelled(false);
                                                                        } else if (click1 == 45) {
                                                                            e.setCancelled(true);
                                                                            Thread.sleep(10);
                                                                            e.setCancelled(false);
                                                                        } else if (click1 == 46) {
                                                                            e.setCancelled(true);
                                                                            Thread.sleep(10);
                                                                            e.setCancelled(false);
                                                                        } else if (click1 == 47) {
                                                                            e.setCancelled(true);
                                                                            Thread.sleep(10);
                                                                            e.setCancelled(false);
                                                                        } else if (click1 == 48) {
                                                                            e.setCancelled(true);
                                                                            Thread.sleep(10);
                                                                            e.setCancelled(false);
                                                                        } else if (click1 == 49) {
                                                                            e.setCancelled(true);
                                                                            Thread.sleep(10);
                                                                            e.setCancelled(false);
                                                                        } else if (click1 == 50) {
                                                                            e.setCancelled(true);
                                                                            Thread.sleep(10);
                                                                            e.setCancelled(false);
                                                                        } else if (click1 == 51) {
                                                                            e.setCancelled(true);
                                                                            Thread.sleep(10);
                                                                            e.setCancelled(false);
                                                                        } else if (click1 == 52) {
                                                                            e.setCancelled(true);
                                                                            Thread.sleep(10);
                                                                            e.setCancelled(false);
                                                                        } else if (click1 == 53) {
                                                                            e.setCancelled(true);
                                                                            Thread.sleep(10);
                                                                            e.setCancelled(false);
                                                                        } else if (click1 == 53) {
                                                                            e.setCancelled(true);
                                                                            Thread.sleep(10);
                                                                            e.setCancelled(false);
                                                                        } else {
                                                                            target.getInventory().setItem(click1, new ItemStack(Material.AIR));
                                                                            p.getInventory().addItem(clickeditem);
                                                                            gui.setItem(click1, new ItemStack(Material.AIR));
                                                                            guilive.setItem(click1, new ItemStack(Material.AIR));
                                                                            p.openInventory(guilive);
                                                                            FileWriter bottom = new FileWriter("bottom.txt");
                                                                            bottom.write("false");
                                                                            bottom.close();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        Path path = Paths.get("bottom.txt");
                        File bottom = new File(String.valueOf(path.toAbsolutePath()));
                        Scanner bottoms = new Scanner(bottom);
                        String bottomss = bottoms.nextLine();
                        String action = String.valueOf(e.getClick());

                        if (!(bottomss.equals("false"))) {
                            clickeditem = p.getInventory().getItem(click1);
                            if (clickeditem == null) {
                                clickeditem = new ItemStack(Material.AIR);
                            } else if (action.equalsIgnoreCase("RIGHT")) {
                                if (String.valueOf(target.getInventory().getItemInOffHand()).equals(String.valueOf(new ItemStack(Material.AIR, 0)))) {
                                    target.getInventory().setItemInOffHand(clickeditem);
                                    p.getInventory().setItem(click1, new ItemStack(Material.AIR));
                                    gui.setItem(40, clickeditem);
                                    guilive.setItem(40, clickeditem);
                                    p.openInventory(guilive);
                                }
                            } else if (String.valueOf(clickeditem.getType()).contains("CHESTPLATE")) {
                                if (target.getInventory().getChestplate() == null) {
                                    target.getInventory().setItem(38, clickeditem);
                                    p.getInventory().setItem(click1, new ItemStack(Material.AIR));
                                    gui.setItem(38, clickeditem);
                                    guilive.setItem(38, clickeditem);
                                    p.openInventory(guilive);
                                }
                            } else if (String.valueOf(clickeditem.getType()).contains("LEGGINGS")) {
                                if (target.getInventory().getLeggings() == null) {
                                    target.getInventory().setItem(37, clickeditem);
                                    p.getInventory().setItem(click1, new ItemStack(Material.AIR));
                                    gui.setItem(37, clickeditem);
                                    guilive.setItem(37, clickeditem);
                                    p.openInventory(guilive);
                                }
                            } else if (String.valueOf(clickeditem.getType()).contains("BOOTS")) {
                                if (target.getInventory().getBoots() == null) {
                                    target.getInventory().setItem(36, clickeditem);
                                    p.getInventory().setItem(click1, new ItemStack(Material.AIR));
                                    gui.setItem(36, clickeditem);
                                    guilive.setItem(36, clickeditem);
                                    p.openInventory(guilive);
                                }
                            } else if (String.valueOf(clickeditem.getType()).contains("HELMET")) {
                                if (target.getInventory().getHelmet() == null) {
                                    target.getInventory().setHelmet(clickeditem);
                                    p.getInventory().setItem(click1, new ItemStack(Material.AIR));
                                    gui.setItem(39, clickeditem);
                                    guilive.setItem(39, clickeditem);
                                    p.openInventory(guilive);
                                }
                            } else {
                                target.getInventory().addItem(clickeditem);
                                p.getInventory().setItem(click1, new ItemStack(Material.AIR));
                                gui.addItem(clickeditem);
                                guilive.addItem(clickeditem);
                                p.openInventory(guilive);
                            }
                        }
                        FileWriter bottomw = new FileWriter("bottom.txt");
                        bottomw.write("justsomething");
                        bottomw.close();
                    }
                }
            }
        }
        catch(NullPointerException event){

        }
    }
}


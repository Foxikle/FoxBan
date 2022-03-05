package me.foxikle.myban;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Ban implements CommandExecutor, Listener {
    public Inventory currentInventory;
    Player Banee;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("ban")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("ban.ban")) {
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have the suitable permisions to use this command.");
                    player.sendMessage(ChatColor.RED + "Please contact a server administrator is you think this is a mistake.");
                    return false;
                }if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "Usage: /ban <player>");
                } else {
                    Banee = Bukkit.getPlayerExact(args[0]);
                    if (Banee != null) {

                        currentInventory = creatinv(Banee);
                        player.openInventory(currentInventory);
                    } else {
                        player.sendMessage(ChatColor.RED + "Could not find that player...");
                    }
                }

                return true;
            }
            else {

                sender.sendMessage("Hey, You cannot do this!");
                return true;
            }
        } else {
            return onCommand(sender, cmd, label, args);
        }
    }

    public Inventory creatinv(Player target) {
        Inventory inv = Bukkit.createInventory(null, 45, ChatColor.BLACK + "You are punishing " + ChatColor.DARK_RED + ""
                + ChatColor.BOLD + target.getDisplayName());

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();


        meta.setDisplayName(ChatColor.BOLD + "Killaura");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(10, item);

        lore.clear();
        item.setType(Material.RED_WOOL);
        meta.setDisplayName(ChatColor.BOLD + "Scafold");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(11, item);

        lore.clear();
        item.setType(Material.COMPASS);
        meta.setDisplayName(ChatColor.BOLD + "Auto Clicker");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(31, item);

        lore.clear();
        item.setType(Material.SUGAR);
        meta.setDisplayName(ChatColor.BOLD + "Speed/B-Hop");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(13, item);

        lore.clear();
        item.setType(Material.IRON_AXE);
        meta.setDisplayName(ChatColor.BOLD + "Criticals");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(14, item);

        lore.clear();
        item.setType(Material.PHANTOM_MEMBRANE);
        meta.setDisplayName(ChatColor.BOLD + "Flying");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(15, item);

        lore.clear();
        item.setType(Material.WATER_BUCKET);
        meta.setDisplayName(ChatColor.BOLD + "Jesus");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(16, item);

        lore.clear();
        item.setType(Material.STICK);
        meta.setDisplayName(ChatColor.BOLD + "Anti-KB");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(12, item);

        lore.clear();
        item.setType(Material.DIAMOND);
        meta.setDisplayName(ChatColor.BOLD + "X-Ray");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(30, item);

        lore.clear();
        item.setType(Material.PISTON);
        meta.setDisplayName(ChatColor.BOLD + "Duping/Bug Abuse");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(32, item);

        lore.clear();
        item.setType(Material.HAY_BLOCK);
        meta.setDisplayName(ChatColor.BOLD + "Other");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(22, item);

        lore.clear();
        item.setType(Material.BARRIER);
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "CLOSE");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(40, item);




        //border
        item.setType(Material.GRAY_STAINED_GLASS_PANE);
        lore.clear();
        meta.setDisplayName(" ");
        lore.add("");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(0, item);
        inv.setItem(1, item);
        inv.setItem(2, item);
        inv.setItem(3, item);
        inv.setItem(4, item);
        inv.setItem(5, item);
        inv.setItem(6, item);
        inv.setItem(7, item);
        inv.setItem(8, item);
        inv.setItem(9, item);
        inv.setItem(17, item);
        inv.setItem(18, item);
        inv.setItem(26, item);
        inv.setItem(27, item);
        inv.setItem(35, item);
        inv.setItem(36, item);
        inv.setItem(44, item);
        inv.setItem(43, item);
        inv.setItem(42, item);
        inv.setItem(41, item);
        inv.setItem(39, item);
        inv.setItem(38, item);
        inv.setItem(37, item);


        return inv;
    }
    public Inventory getCurrentInventory() {
        return currentInventory;
    }

    public Player getBanee() {
        return Banee;
    }
}

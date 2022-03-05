package me.foxikle.myban;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class AuditLog implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("fbanlogs")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (!player.hasPermission("unban.use")) {
                    player.sendMessage(ChatColor.RED + "You do not have the suitable permisions to use this command.");
                    player.sendMessage(ChatColor.RED + "Please contact a server administrator is you think this is a mistake.");
                    return false;

                } else {
                    sender.sendMessage("Opening inv?");
                }
                return true;
            } else {
                return onCommand(sender, cmd, label, args);
            }
        } else {
            return false;
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

        Myban.addBorder(inv);

        return inv;
    }

}

package me.foxikle.myban;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Unban implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("unban")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (!player.hasPermission("fban.unban")) {
                    player.sendMessage(ChatColor.RED + "You do not have the suitable permisions to use this command.");
                    player.sendMessage(ChatColor.RED + "Please contact a server administrator is you think this is a mistake.");
                    return false;
                }
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "Usage: /unban <player>");
                    return false;
                }
                String unbanee;
                try {
                    unbanee = Bukkit.getBanList(BanList.Type.NAME).getBanEntry(args[0]).getTarget();
                } catch (NullPointerException e) {
                    player.sendMessage(ChatColor.RED + "Could not find that player...");
                    return false;
                }
                Bukkit.getBanList(BanList.Type.NAME).pardon(unbanee);
            } else {
                sender.sendMessage("Hey, You cannot do this!");
            }
            return true;
        } else {
            return onCommand(sender, cmd, label, args);
        }
    }
}

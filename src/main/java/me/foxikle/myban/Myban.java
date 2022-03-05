package me.foxikle.myban;

import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.*;
import java.util.logging.Logger;

import static java.util.Objects.hash;


public final class Myban extends JavaPlugin implements Listener {
    private static final int PERMANENT_DURATION = 1000000;

    private Logger log = Bukkit.getLogger();

    public Inventory invLength;
    public Inventory inv7d;
    public Inventory inv30d;
    public Inventory inv60d;
    public Inventory inv180d;
    public Inventory inv270d;
    public Inventory inv360d;
    public Inventory invPerm;
    float v = 1f;
    float p = 0.5f;

    private Ban ban;
    private Unban unban = new Unban();
    private AuditLog auditLog = new AuditLog();

    @Override
    public void onEnable() {

        ban = new Ban();
        this.getServer().getPluginManager().registerEvents(this, this);
        getCommand("fban").setExecutor(ban);

        this.getServer().getPluginManager().registerEvents(this, this);
        getCommand("unban").setExecutor(unban);

        //this.getServer().getPluginManager().registerEvents(this, this);
       // getCommand("auditLog").setExecutor(auditLog);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler()
    public void onClickFirstPage(InventoryClickEvent event) {
        if (!event.getInventory().equals(ban.getCurrentInventory()))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();
        if (event.getSlot() == 10) {
            creatInvLengthPage();
            player.sendMessage(ChatColor.GRAY + "Opening menu..."); // killaura
            player.openInventory(invLength);
        }
        if (event.getSlot() == 11) {
            player.sendMessage(ChatColor.GRAY + "Opening menu..."); // scafold
            creatInvLengthPage();
            player.openInventory(invLength);
        }
        if (event.getSlot() == 12) {
            player.sendMessage(ChatColor.GRAY + "Opening menu..."); // anti kb
            creatInvLengthPage();
            player.openInventory(invLength);
        }
        if (event.getSlot() == 13) {
            player.sendMessage(ChatColor.GRAY + "Opening menu..."); // speed/bhop
            creatInvLengthPage();
            player.openInventory(invLength);
        }
        if (event.getSlot() == 14) {
            player.sendMessage(ChatColor.GRAY + "Opening menu..."); // criticals
            creatInvLengthPage();
            player.openInventory(invLength);
        }
        if (event.getSlot() == 15) {
            player.sendMessage(ChatColor.GRAY + "Opening menu..."); // flying
            creatInvLengthPage();
            player.openInventory(invLength);
        }
        if (event.getSlot() == 16) {
            player.sendMessage(ChatColor.GRAY + "Opening menu..."); // jesus
            creatInvLengthPage();
            player.openInventory(invLength);
        }
        if (event.getSlot() == 22) {
            player.sendMessage(ChatColor.GRAY + "Opening menu..."); // other/misc
            creatInvLengthPage();
            player.openInventory(invLength);
        }
        if (event.getSlot() == 31) {
            player.sendMessage(ChatColor.GRAY + "Opening menu..."); // X-Ray
            creatInvLengthPage();
            player.openInventory(invLength);
        }
        if (event.getSlot() == 30) {
            player.sendMessage(ChatColor.GRAY + "Opening menu..."); // AutoClicker/Macros
            creatInvLengthPage();
            player.openInventory(invLength);
        }
        if (event.getSlot() == 32) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.GRAY + "Opening menu..."); // Bug Abuse/ Duping
            player.playSound(player.getLocation(), Sound.ENCHANT_THORNS_HIT, p, v);
            creatInvLengthPage();
            player.openInventory(invLength);
        }
        if (event.getSlot() == 40) {
            player.sendMessage("How many times does this appear?");
            player.closeInventory();
            player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, p, v);
        }
    }

    public void creatInvLengthPage() {
        invLength = Bukkit.createInventory(null, 27, ChatColor.BLACK + "Select the punishment length ");

        ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();
        addBorder(invLength);


        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "7 Days");
        List<String> lore = new ArrayList<String>();
        item.setType(Material.LIME_CONCRETE);
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        invLength.setItem(10, item);

        lore.clear();
        item.setType(Material.LIME_TERRACOTTA);
        meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "30 Days");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        invLength.setItem(11, item);

        lore.clear();
        item.setType(Material.YELLOW_CONCRETE);
        meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "60 Days");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        invLength.setItem(12, item);

        lore.clear();
        item.setType(Material.YELLOW_TERRACOTTA);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "180 Days");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        invLength.setItem(13, item);

        lore.clear();
        item.setType(Material.ORANGE_TERRACOTTA);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "270 Days");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        invLength.setItem(14, item);

        lore.clear();
        item.setType(Material.RED_CONCRETE);
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "360 days");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        invLength.setItem(15, item);

        lore.clear();
        item.setType(Material.BEDROCK);
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "PERMANANT");
        lore.add(ChatColor.GRAY + "Click here to select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        invLength.setItem(16, item);

        lore.clear();
        item.setType(Material.BARRIER);
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "CLOSE");
        lore.add(ChatColor.GRAY + "Click here to close");
        meta.setLore(lore);
        item.setItemMeta(meta);
        invLength.setItem(22, item);

        lore.clear();
        item.setType(Material.ARROW);
        meta.setDisplayName( ChatColor.BOLD + "Go Back");
        lore.add(ChatColor.GRAY + "Click here to go back!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        invLength.setItem(18, item);

    }

    @EventHandler()
    public void onClickLengthPage(InventoryClickEvent event) {
        if (!event.getInventory().equals(invLength))
            return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();
        if (event.getSlot() == 10) {
            player.sendMessage(ChatColor.GREEN + "Sentence is set to 7 days"); // 1 week
            creatInv7d();
            player.openInventory(inv7d);
        }
        if (event.getSlot() == 11) {
            player.sendMessage(ChatColor.GREEN + "Sentence is set to 30 days"); // 1 month
            creatInv30d();
            player.openInventory(inv30d);
        }
        if (event.getSlot() == 12) {
            player.sendMessage(ChatColor.DARK_GREEN + "Sentence is set to 60 days"); // 3 months
            creatInv60d();
            player.openInventory(inv60d);
        }
        if (event.getSlot() == 13) {
            player.sendMessage(ChatColor.YELLOW + "Sentence is set to 180 days"); // 6 months
            creatInv180d();
            player.openInventory(inv180d);
        }
        if (event.getSlot() == 14) {
            player.sendMessage(ChatColor.GOLD + "Sentence is set to 270 days"); // 9 months
            creatInv270d();
            player.openInventory(inv270d);
        }
        if (event.getSlot() == 15) {
            player.sendMessage(ChatColor.RED + "Sentence is set to 360 days"); // 1 year
            creatInv360d();
            player.openInventory(inv360d);
        }
        if (event.getSlot() == 16) {
            player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Sentence is permanant"); // perm
            creatInvPerm();
            player.openInventory(invPerm);
        }
        if (event.getSlot() == 18) {
            creatInvLengthPage();
            player.openInventory(ban.currentInventory);
        }
        if (event.getSlot() == 22) { //close
            player.closeInventory();
        }
    }

    public void creatInv7d() {
        inv7d = creatInvLength(7);
    }

    @EventHandler()
    public void onClick7d(InventoryClickEvent event) {
        if (!event.getInventory().equals(inv7d)) return;
        onClickDuration(7, event);
    }

    public void creatInv30d() {
        inv30d = creatInvLength(30);
    }

    @EventHandler()
    public void onClick30d(InventoryClickEvent event) {
        if (!event.getInventory().equals(inv30d)) return;

        onClickDuration(30, event);
    }

    public void creatInv60d() {
        inv60d = creatInvLength(60);
    }

    @EventHandler()
    public void onClick60d(InventoryClickEvent event) {
        if (!event.getInventory().equals(inv60d)) return;

        onClickDuration(60, event);
    }

    public void creatInv180d() {
        inv180d = creatInvLength(180);
    }

    @EventHandler()
    public void onClick180d(InventoryClickEvent event) {
        if (!event.getInventory().equals(inv180d)) return;

        onClickDuration(180, event);
    }

    public void creatInv270d() {
        inv270d = creatInvLength(270);
    }

    @EventHandler()
    public void onClick270d(InventoryClickEvent event) {
        if (!event.getInventory().equals(inv270d)) return;

        onClickDuration(270, event);
    }

    public void creatInv360d() {
        inv360d = creatInvLength(360);
    }

    @EventHandler()
    public void onClick360d(InventoryClickEvent event) {
        if (!event.getInventory().equals(inv360d)) return;

        onClickDuration(360, event);
    }

    public void creatInvPerm() {
        invPerm = creatInvLength(PERMANENT_DURATION);
    }

    @EventHandler()
    public void onClickPerm(InventoryClickEvent event) {
        if (!event.getInventory().equals(invPerm)) return;

        onClickDuration(PERMANENT_DURATION, event);
    }

    public Inventory creatInvLength(int duration) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.BLACK + "Please confirm the punishment. ");
        addBorder(inv);

        ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();
        String durStr = duration == PERMANENT_DURATION ? "Permanantly" : duration + " Days";
        meta.setDisplayName(ChatColor.BOLD + durStr);

        List<String> lore = new ArrayList<String>();
        item.setType(Material.ANVIL);
        lore.add(ChatColor.GRAY + "Click here confirm");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(13, item);

        lore.clear();
        item.setType(Material.BARRIER);
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "CLOSE");
        lore.add(ChatColor.GRAY + "Click here to close");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(22, item);

        lore.clear();
        item.setType(Material.SPECTRAL_ARROW);
        meta.setDisplayName(ChatColor.BOLD + "Go Back");
        lore.add(ChatColor.GRAY + "Click here to go back!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(18, item);

        return inv;
    }

    private void onClickDuration(int duration, InventoryClickEvent event) {
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        event.setCancelled(true);

        String durStr = duration == PERMANENT_DURATION ? "permanently" : "for " + duration + " days";
        Player player = (Player) event.getWhoClicked();
        if (event.getSlot() == 13) {

            Date expires = Date.from(new Date().toInstant().plusSeconds(duration * 24 * 60 * 60));
            String reason = "Cheating through the use of unfair game mechanics.";

            Bukkit.getBanList(BanList.Type.NAME).addBan(ban.getBanee().getName(), ChatColor.GOLD + "" + ChatColor.BOLD + "The Ban Hammer Has Spoken!" + ChatColor.AQUA +"\n\n\n\n Reason: " +
                    "Cheating through the use of unfair game mechanics." + ChatColor.LIGHT_PURPLE + "\n Appeal at https://discord.gg/EfGvpXzB28" + ChatColor.WHITE + "" + ChatColor.BOLD + " \n [<" + ChatColor.GOLD + "" + ChatColor.BOLD + "FOX" + ChatColor.RED + "" + ChatColor.BOLD + "BAN" + ChatColor.GOLD + " v1.2" + ChatColor.WHITE + ChatColor.WHITE + "" + ChatColor.BOLD + ">]" , expires, "");
            player.sendMessage(ChatColor.BOLD + "<" + ChatColor.GOLD + "" + ChatColor.BOLD + "FOX" + ChatColor.RED + "" +
                    ChatColor.BOLD + "BAN" + "" + ChatColor.WHITE + ChatColor.BOLD + "> " +
                    ChatColor.DARK_AQUA + "That player was banned " + durStr + ".");
            ban.getBanee().kickPlayer(ChatColor.GOLD + "" + ChatColor.BOLD + "The Ban Hammer Has Spoken!" + ChatColor.RED +" \n You have been banned." + ChatColor.AQUA +"\n\n\n\n Reason: " +
                    reason + ChatColor.LIGHT_PURPLE + "\n Appeal at https://discord.gg/EfGvpXzB28");
            SetupYML(ban.getBanee(), ((Player) event.getWhoClicked()).getPlayer(), duration, reason);
            player.closeInventory();
        }
        if (event.getSlot() == 18) {
            creatInvLengthPage();
            player.openInventory(invLength);
        }
        if (event.getSlot() == 22) { //close
            player.closeInventory();
        }
    }

    public static void addBorder(Inventory inv) {
        ItemStack item = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<String>();

        meta.setDisplayName(" ");
        lore.add("");
        meta.setLore(lore);
        item.setItemMeta(meta);

        for(int x = 0; x < inv.getSize(); x++) {
            if ((x < 9 || x > inv.getSize() - 9 ||
                x % 9 == 0 || (x + 1) % 9 == 0) &&
                inv.getItem(x) == null) {
                inv.setItem(x, item);
            }
        }
    }

    public void SetupYML(Player banee, Player staff, int duration, String reason) {
        String banId = Integer.toString(hash("FoxBan:" + banee.getName() + ":" + Instant.now()), 16).toUpperCase(Locale.ROOT);
        File f = new File("plugins/FoxBan/PlayerBans/" + banee.getName() + "_" + banId + ".yml");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
        yml.addDefault("ban ID: ", banId);
        yml.addDefault("Name: ", banee.getName());
        yml.addDefault("UUID: ", banee.getUniqueId());
        yml.addDefault("Staff Who Punished: ", staff.getName());
        yml.addDefault("Duration: ", duration == PERMANENT_DURATION? "Permanant" : duration + " days");
        yml.addDefault("Reason: ", reason);
        yml.options().copyDefaults(true);
        try {
            yml.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
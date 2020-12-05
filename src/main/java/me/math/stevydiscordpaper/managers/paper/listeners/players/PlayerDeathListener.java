package me.math.stevydiscordpaper.managers.paper.listeners.players;

import me.math.stevydiscordpaper.Main;
import me.math.stevydiscordpaper.utils.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.awt.*;
import java.util.HashMap;

public class PlayerDeathListener implements Listener {
    private final Main plugin;
    private final HashMap<Player, World> deathWorld;
    private final HashMap<Player, Location> deathLocation;

    public PlayerDeathListener(Main plugin) {
        this.plugin = plugin;
        this.deathWorld = new HashMap<>();
        this.deathLocation = new HashMap<>();
    }

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        Location location = event.getEntity().getLocation();
        World world = event.getEntity().getWorld();

        if (player == null)
            return;

        if (Main.getConfigManager().isShowDeathLocationOnDiscordEnabled()) {
            StringBuilder builder = new StringBuilder();
            builder.append("Dernières coordonnées => ");
            switch (world.getEnvironment()) {
                case NORMAL:
                    builder.append("[Overworld] ");
                    break;
                case NETHER:
                    builder.append("[Nether] ");
                    break;
                case THE_END:
                    builder.append("[End] ");
                    break;
                default:
                    builder.append("[DEFAULT] ");
                    break;
            }

            builder.append("x: ").append(location.getBlockX()).append(" / y: ").append(location.getBlockY()).append(" / z: ").append(location.getBlockZ()).append("\n");
            builder.append("Date de la mort: ").append(Util.completeDate());

            Main.getDiscordManager().sendLogMessageToDiscord(player.getName() + " est mort. " + builder.toString(), true, Color.ORANGE);
            deathWorld.put(player, player.getWorld());
            deathLocation.put(player, player.getLocation());
        }

        Main.getDiscordManager().sendListenerMessageToDiscord(player, "%name% est mort. [" + event.getDeathMessage() + "]", Color.RED);
    }

    @EventHandler
    public void onPlayerRespawnEvent(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        if (Main.getConfigManager().isShowDeathLocationOnDiscordEnabled()) {
            World world = deathWorld.get(player);
            Location location = deathLocation.get(player);

            if (world == null || location == null)
                return;

            StringBuilder builder = new StringBuilder();
            builder.append("------- Lieu -------\n\n");

            switch (world.getEnvironment()) {
                case NORMAL:
                    builder.append("§3§lOverworld§r");
                    break;
                case NETHER:
                    builder.append("§3§lNether§r");
                    break;
                case THE_END:
                    builder.append("§3§lEnd§r");
                    break;
                default:
                    builder.append("§4§lInconnu§r");
                    break;
            }

            builder.append("\n\n--- Coordonnées ---\n\n");
            builder.append("§3§lX: ").append(location.getBlockX()).append("\n§r§3§lY: ").append(location.getBlockY()).append("\n§r§3§lZ: ").append(location.getBlockZ()).append("§r\n\n");
            builder.append("-- Date de la mort --\n\n");
            builder.append("§3§l").append(Util.shortDateHour()).append("§r");

            deathLocation.remove(player);
            deathWorld.remove(player);

            ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
            bookMeta.setTitle("Dernière mort - " + Util.shortDateHour());
            bookMeta.setAuthor(player.getDisplayName());
            bookMeta.setPages(builder.toString());
            writtenBook.setItemMeta(bookMeta);
            player.getInventory().addItem(writtenBook);
        }
    }
}

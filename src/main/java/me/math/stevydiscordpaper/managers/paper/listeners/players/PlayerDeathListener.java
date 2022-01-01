package me.math.stevydiscordpaper.managers.paper.listeners.players;

import me.math.stevydiscordpaper.Main;
import me.math.stevydiscordpaper.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitScheduler;

import java.awt.*;
import java.util.UUID;

public class PlayerDeathListener implements Listener {
    private final Main plugin;

    public PlayerDeathListener(Main plugin) {
        this.plugin = plugin;
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

            Main.getDiscordManager().sendLogMessageToDiscord(player.getName() + " est mort. " + builder.toString(), true, java.awt.Color.PINK);
        }

        if (Main.getConfigManager().isHeadDropEnabled()) {
            try {
                Runnable headTask = () -> {
                    Location skullLocation = location.add(0, 1, 0);
                    Block skullBlock = skullLocation.getBlock();
                    skullBlock.setType(Material.PLAYER_HEAD);
                    BlockState state = skullBlock.getState();
                    Skull skull = (Skull) state;
                    UUID uuid = player.getUniqueId();
                    skull.setOwningPlayer(Bukkit.getServer().getOfflinePlayer(uuid));
                    skull.update();

                    Main.getDiscordManager().sendLogMessageToDiscord("La tête de " + player.getName() + " vient de drop à sa mort.", true, Color.PINK);
                };

                BukkitScheduler scheduler = Bukkit.getScheduler();
                scheduler.runTaskLater(plugin, headTask, 60L);
            } catch (Exception e) {
                plugin.getLogger().warning("Could not drop the head of " + player.getName());
                e.printStackTrace();
            }
        }

        Main.getDiscordManager().sendListenerMessageToDiscord(player, "%name% est mort. [" + event.getDeathMessage() + "]", java.awt.Color.RED);
    }
}

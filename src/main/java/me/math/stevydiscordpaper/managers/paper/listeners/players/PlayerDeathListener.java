package me.math.stevydiscordpaper.managers.paper.listeners.players;

import me.math.stevydiscordpaper.Main;
import me.math.stevydiscordpaper.utils.Util;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.awt.*;

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

            Main.getDiscordManager().sendLogMessageToDiscord(player.getName() + " est mort. " + builder.toString(), true, Color.ORANGE);
        }

        Main.getDiscordManager().sendListenerMessageToDiscord(player, "%name% est mort. [" + event.getDeathMessage() + "]", Color.RED);
    }
}

package me.math.stevydiscordpaper.managers.paper.listeners.players;

import me.math.stevydiscordpaper.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

public class PlayerQuitListener implements Listener {
    private final Main plugin;

    public PlayerQuitListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (Main.getConfigManager().isDiscordMessageOnUserLogoutEnabled())
            Main.getDiscordManager().sendListenerMessageToDiscord(player, Main.getConfigManager().discordMessageOnUserLogoutMessage(), Color.GRAY);

        Main.getDiscordManager().forceUpdate();
    }
}

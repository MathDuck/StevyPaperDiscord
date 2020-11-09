package me.math.stevydiscordpaper.managers.paper.listeners;

import me.math.stevydiscordpaper.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.awt.*;

public class PlayerJoinListener implements Listener {
    private final Main plugin;

    public PlayerJoinListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (Main.getConfigManager().isDiscordMessageOnUserLoginEnabled())
            Main.getDiscordManager().sendListenerMessageToDiscord(player, Main.getConfigManager().discordMessageOnUserLoginMessage(), Color.CYAN);

        Main.getDiscordManager().forceUpdate();
    }
}

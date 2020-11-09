package me.math.stevydiscordpaper.managers.paper.listeners;

import me.math.stevydiscordpaper.Main;
import me.math.stevydiscordpaper.managers.DiscordManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.awt.*;

public class PlayerJoinListener implements Listener {
    private Main main;

    public PlayerJoinListener(Main plugin) {
        this.main = plugin;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (Main.getConfigManager().isDiscordMessageOnUserLoginEnabled())
            DiscordManager.sendListenerMessageToDiscord(player, Main.getConfigManager().discordMessageOnUserLoginMessage(), Color.CYAN);

        DiscordManager.forceUpdate();
    }
}

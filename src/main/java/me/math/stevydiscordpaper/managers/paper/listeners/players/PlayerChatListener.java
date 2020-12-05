package me.math.stevydiscordpaper.managers.paper.listeners.players;

import me.math.stevydiscordpaper.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {
    private Main plugin;

    public PlayerChatListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        if (Main.getConfigManager().isShowEmojisNameEnabled())
            message = Main.getDiscordManager().formatMinecraftMessage(event.getMessage());

        Main.getDiscordManager().sendMessageToDiscord(player.getName(), message);
    }
}

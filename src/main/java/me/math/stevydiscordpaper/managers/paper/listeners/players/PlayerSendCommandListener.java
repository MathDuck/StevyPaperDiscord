package me.math.stevydiscordpaper.managers.paper.listeners.players;

import me.math.stevydiscordpaper.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerSendCommandListener implements Listener {
    private Main plugin;

    public PlayerSendCommandListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerSendCommandEvent(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        if (message.length() >= 2) {
            if (Main.getConfigManager().isLogChannelEnabled()) {
                Main.getDiscordManager().sendCommandMessageToDiscord(player.getName() + " a utilisé la commande " + message + ".");
            }
        }
    }
}
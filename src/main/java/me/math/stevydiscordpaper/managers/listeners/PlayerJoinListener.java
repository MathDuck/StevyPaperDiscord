package me.math.stevydiscordpaper.managers.listeners;

import me.math.stevydiscordpaper.Main;
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
            Main.sendListenerMessageToDiscord(player, Main.getConfigManager().discordMessageOnUserLoginMessage(), Color.CYAN);

        Main.forceUpdate();

        event.setJoinMessage("Hey §2§l" + player.getName() + " §rvient de se connecter! Bon jeu à toi!");

        if (player.getName().equals("Istariaa"))
            player.sendMessage("Petit message privé pour te dire coucou Sophie :3");

        if (!Main.getConfigManager().isPvpEnabled())
            player.sendMessage("§4§oLe PvP est actuellement désactivé.");

        if (Main.getConfigManager().isAFKSystemEnabled()) {
            // Reset player's minutes
            Main.getAFKManager().resetTime(player);
        }
    }
}

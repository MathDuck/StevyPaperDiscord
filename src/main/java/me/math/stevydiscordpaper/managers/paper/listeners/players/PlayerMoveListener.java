package me.math.stevydiscordpaper.managers.paper.listeners.players;

import me.math.stevydiscordpaper.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.awt.*;

public class PlayerMoveListener implements Listener {
    private Main main;

    public PlayerMoveListener(Main plugin) {
        this.main = plugin;
    }

    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (Main.getConfigManager().isVoidTeleportEnabled()) {
            if (player.getWorld().getEnvironment() == World.Environment.THE_END) {
                if (event.getTo().getBlockY() <= Main.getConfigManager().getVoidLowestPosition()) {
                    World overWorld = Bukkit.getWorlds().get(0);
                    Location playerLocation = player.getLocation();

                    playerLocation.setWorld(Bukkit.getWorlds().get(0));
                    playerLocation.setX(overWorld.getSpawnLocation().getX());
                    playerLocation.setY(256.0D);
                    playerLocation.setZ(overWorld.getSpawnLocation().getZ());
                    playerLocation.setYaw(playerLocation.getYaw());
                    playerLocation.setPitch(playerLocation.getYaw());

                    player.teleport(playerLocation);

                    Main.getDiscordManager().sendLogMessageToDiscord(player.getName() + " vient de tomber de l'End jusqu'au spawn.", true, Color.PINK);
                }
            }
        }
    }
}

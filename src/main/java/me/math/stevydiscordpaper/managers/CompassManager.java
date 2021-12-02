package me.math.stevydiscordpaper.managers;

import me.math.stevydiscordpaper.Main;
import me.math.stevydiscordpaper.utils.TimeSpan;
import me.math.stevydiscordpaper.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.Timer;
import java.util.TimerTask;

public class CompassManager {

    private Main main;
    private BossBar bossBar;

    public CompassManager(Main plugin) {
        this.main = plugin;
        this.bossBar = Bukkit.createBossBar("title", BarColor.WHITE, BarStyle.SOLID);
    }

    public void init() {
        if (!Main.getConfigManager().isCompassClockEnabled())
            return;

        startTimerCycle();
    }

    private void startTimerCycle() {
        int delay = 1000; // delay for 0.5 sec.
        int period = 200; // repeat every 0.2 sec.
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                long start = System.currentTimeMillis();
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    processUser(player);
                }
                TimeSpan span = new TimeSpan(start, System.currentTimeMillis());
                if (span.toMilliseconds() > 2000) {
                    Bukkit.getLogger().warning("CompassManager => Processing took: " + span.toMilliseconds() + "ms to execute.");
                }
            }
        }, delay, period);
    }

    private void processUser(Player player) {
        bossBar.removePlayer(player);
        if (player.getInventory().contains(Material.CLOCK)) {
            bossBar.removePlayer(player);

            String coords = "XYZ: " + Math.round(player.getLocation().getX()) + " / " + Math.round(player.getLocation().getY()) + " / " + Math.round(player.getLocation().getZ());
            String facing = getCardinalDirection(player);

            bossBar.setTitle(coords + " | " + facing + " | " + Util.getHoursAndMinutes(player.getWorld().getFullTime()));

            BarColor Color = BarColor.WHITE;
            if (player.getWorld().getTime() >= 0 && player.getWorld().getTime() <= 11999)
                Color = BarColor.YELLOW;
            else if (player.getWorld().getTime() >= 12000 && player.getWorld().getTime() <= 12999)
                Color = BarColor.PINK;
            else if (player.getWorld().getTime() >= 13000 && player.getWorld().getTime() <= 22999)
                Color = BarColor.PURPLE;
            else if (player.getWorld().getTime() >= 23000)
                Color = BarColor.BLUE;
            bossBar.setColor(Color);

            double result = (double) player.getWorld().getTime() / 24000;
            bossBar.setProgress(result);

            bossBar.addPlayer(player);
        }
    }

    public static String getCardinalDirection(Player player) {
        double rotation = (player.getLocation().getYaw() - 180) % 360;
        if (rotation < 0) {
            rotation += 360.0;
        }
        if (0 <= rotation && rotation < 22.5) {
            return "N";
        } else if (22.5 <= rotation && rotation < 67.5) {
            return "NE";
        } else if (67.5 <= rotation && rotation < 112.5) {
            return "E";
        } else if (112.5 <= rotation && rotation < 157.5) {
            return "SE";
        } else if (157.5 <= rotation && rotation < 202.5) {
            return "S";
        } else if (202.5 <= rotation && rotation < 247.5) {
            return "SW";
        } else if (247.5 <= rotation && rotation < 292.5) {
            return "W";
        } else if (292.5 <= rotation && rotation < 337.5) {
            return "NW";
        } else if (337.5 <= rotation && rotation < 360.0) {
            return "N";
        } else {
            return null;
        }
    }

    public void dispose() {
        this.bossBar = null;
    }
}

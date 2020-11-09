package me.math.stevydiscordpaper.managers;

import me.math.stevydiscordpaper.Main;

public class DiscordManager {
    private Main main;

    public DiscordManager(Main plugin) {
        this.main = plugin;
    }

    public void init() {
        //sendLogMessageToDiscord("Le serveur (" + getConfigManager().getServerHost() + ") est en ligne.", true, Color.GREEN);
    }

    public void dispose() {
        //sendLogMessageToDiscord("Le serveur est maintenant hors-ligne.", true, Color.RED);
    }
}

package me.math.stevydiscordpaper.managers;

import me.math.stevydiscordpaper.Main;
import me.math.stevydiscordpaper.managers.paper.listeners.players.*;
import org.bukkit.plugin.PluginManager;

public class EventManager {
    private final Main plugin;

    public EventManager(Main plugin) {
        this.plugin = plugin;
    }

    public void init() {
        registerEvents();
    }

    private void registerEvents() {
        PluginManager pm = plugin.getServer().getPluginManager();

        pm.registerEvents(new PlayerJoinListener(plugin), plugin);
        pm.registerEvents(new PlayerQuitListener(plugin), plugin);
        pm.registerEvents(new PlayerChatListener(plugin), plugin);
        pm.registerEvents(new PlayerDeathListener(plugin), plugin);
        pm.registerEvents(new PlayerSendCommandListener(plugin), plugin);
        pm.registerEvents(new PlayerMoveListener(plugin), plugin);

        pm.registerEvents(new PlayerAdvancementDoneListener(plugin), plugin);
    }
}

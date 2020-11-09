package me.math.stevydiscordpaper.managers;

import me.math.stevydiscordpaper.Main;
import me.math.stevydiscordpaper.managers.paper.commands.ReloadConfigCommand;
import me.math.stevydiscordpaper.managers.paper.commands.ReloadDiscordCommand;

public class CommandManager {
    private final Main plugin;

    public CommandManager(Main plugin) {
        this.plugin = plugin;
    }

    public void init() {
        registerCommands();
    }

    private void registerCommands() {
        plugin.getCommand("reloadconfig").setExecutor(new ReloadConfigCommand(plugin));
        plugin.getCommand("discord").setExecutor(new ReloadDiscordCommand(plugin));
    }
}

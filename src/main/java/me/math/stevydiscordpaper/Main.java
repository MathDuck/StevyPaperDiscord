package me.math.stevydiscordpaper;

import me.math.stevydiscordpaper.managers.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;

public final class Main extends JavaPlugin {
    private static ConfigManager configManager;
    private static TextManager textManager;
    private static DiscordManager discordManager;
    private static EventManager eventManager;
    private static CommandManager commandManager;
    private static ClockManager clockManager;

    public static ConfigManager getConfigManager() {
        return configManager;
    }

    public static DiscordManager getDiscordManager() {
        return discordManager;
    }

    public static TextManager getTextManager() {
        return textManager;
    }

    public static EventManager getEventManager() {
        return eventManager;
    }

    public static CommandManager getCommandManager() {
        return commandManager;
    }

    public static ClockManager getClockManager() {
        return clockManager;
    }

    @Override
    public void onEnable() {
        //Init Config
        configManager = new ConfigManager(this);
        configManager.init();

        if (configManager.isInDebugMode())
            FallbackLoggerConfiguration.setDebug(true);

        //Init Managers
        eventManager = new EventManager(this);
        eventManager.init();
        commandManager = new CommandManager(this);
        commandManager.init();
        textManager = new TextManager();
        textManager.init();
        discordManager = new DiscordManager(this);
        discordManager.init();
        clockManager = new ClockManager(this);
        clockManager.init();
    }

    @Override
    public void onDisable() {
        configManager.dispose();
        textManager.dispose();
        discordManager.dispose();
        clockManager.dispose();
    }
}

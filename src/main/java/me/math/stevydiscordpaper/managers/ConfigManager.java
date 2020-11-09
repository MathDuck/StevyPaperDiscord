package me.math.stevydiscordpaper.managers;

import me.math.stevydiscordpaper.Main;
import me.math.stevydiscordpaper.logging.Logger;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    private final Main plugin;
    private Configuration config;

    private String discordToken, discordToMCTemplateMessage, MCToDiscordTemplateMessage, discordMessageOnUserLoginMessage, discordMessageOnUserLogoutMessage, discordPrefix, serverHost;
    private long defaultChannelId, chatChannelId, logChannelId;
    private boolean logChannelEnabled, discordMessageOnUserLogin, discordMessageOnUserLogout, useEmbedDiscordMessage, isDebugging, showEmojisName;

    public ConfigManager(Main plugin) {
        this.plugin = plugin;
    }

    public void init() {
        getDefaultConfig();
        plugin.getLogger().info("Loading configuration...");
        loadConfig(config);
    }

    public void dispose() {
        saveConfigOnQuit();
    }

    public void getDefaultConfig() {
        String filePath = plugin.getDataFolder() + "/config.yml";
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                config.set("server_host", "127.0.0.1:25565");
                config.set("discord_token", "none");
                config.set("discord_command_prefix", "!");
                config.set("discord_default_channel", 0);
                config.set("discord_chatlogs_channel", 0);
                config.set("discord_logs_enabled", true);
                config.set("discord_logs_channel", 0);
                config.set("discord_chat_to_minecraft_template_message", "<%name%>: %message%");
                config.set("minecraft_chat_to_discord_template_message", "**<%name%>** %message%");
                config.set("discord_bot_send_on_login", true);
                config.set("discord_bot_send_on_login_message", "**%name% vient de se connecter**");
                config.set("discord_bot_send_on_logout", true);
                config.set("discord_bot_send_on_logout_message", "**%name% vient de se déconnecter**");
                config.set("use_embed_discord_message", true);
                config.set("show_emojis_name", true);
                config.set("debug_mode", false);
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
            } else {
                config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
            }
        } catch (IOException e) {
            Logger.exception(e);
        }
    }

    public void loadConfig(Configuration conf) {
        serverHost = conf.getString("server_host");
        discordToken = conf.getString("discord_token");
        discordPrefix = conf.getString("discord_command_prefix");
        defaultChannelId = conf.getLong("discord_default_channel");
        chatChannelId = conf.getLong("discord_chatlogs_channel");
        logChannelEnabled = conf.getBoolean("discord_logs_enabled");
        logChannelId = conf.getLong("discord_logs_channel");
        discordToMCTemplateMessage = conf.getString("discord_chat_to_minecraft_template_message");
        MCToDiscordTemplateMessage = conf.getString("minecraft_chat_to_discord_template_message");
        discordMessageOnUserLogin = conf.getBoolean("discord_bot_send_on_login");
        discordMessageOnUserLoginMessage = conf.getString("discord_bot_send_on_login_message");
        discordMessageOnUserLogout = conf.getBoolean("discord_bot_send_on_logout");
        discordMessageOnUserLogoutMessage = conf.getString("discord_bot_send_on_logout_message");
        useEmbedDiscordMessage = conf.getBoolean("use_embed_discord_message");
        showEmojisName = conf.getBoolean("show_emojis_name");
        isDebugging = conf.getBoolean("debug_mode");
    }

    public void saveConfigOnQuit() {
        String filePath = plugin.getDataFolder() + "/config.yml";
        File file = new File(filePath);
        try {
            if (file.exists()) {
                config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                config.set("server_host", serverHost);
                config.set("discord_token", discordToken);
                config.set("discord_command_prefix", discordPrefix);
                config.set("discord_default_channel", defaultChannelId);
                config.set("discord_chatlogs_channel", chatChannelId);
                config.set("discord_logs_enabled", logChannelEnabled);
                config.set("discord_logs_channel", logChannelId);
                config.set("discord_chat_to_minecraft_template_message", discordToMCTemplateMessage);
                config.set("minecraft_chat_to_discord_template_message", MCToDiscordTemplateMessage);
                config.set("discord_bot_send_on_login", discordMessageOnUserLogin);
                config.set("discord_bot_send_on_login_message", discordMessageOnUserLoginMessage);
                config.set("discord_bot_send_on_logout", discordMessageOnUserLogout);
                config.set("discord_bot_send_on_logout_message", discordMessageOnUserLogoutMessage);
                config.set("use_embed_discord_message", useEmbedDiscordMessage);
                config.set("show_emojis_name", showEmojisName);
                config.set("debug_mode", isDebugging);
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
            }
        } catch (IOException e) {
            Logger.exception(e);
        }
    }

    public Configuration getConfig() {
        return config;
    }

    public String getDiscordPrefix() {
        return discordPrefix;
    }

    public String getServerHost() {
        return serverHost;
    }

    public String getDiscordToken() {
        return discordToken;
    }

    public boolean isDiscordMessageOnUserLoginEnabled() {
        return discordMessageOnUserLogin;
    }

    public boolean isUsingEmbedDiscordMessage() {
        return useEmbedDiscordMessage;
    }

    public String getMCToDiscordTemplateMessage() {
        return MCToDiscordTemplateMessage;
    }

    public String getDiscordToMCTemplateMessage() {
        return discordToMCTemplateMessage;
    }

    public String discordMessageOnUserLoginMessage() {
        return discordMessageOnUserLoginMessage;
    }

    public boolean isDiscordMessageOnUserLogoutEnabled() {
        return discordMessageOnUserLogout;
    }

    public String discordMessageOnUserLogoutMessage() {
        return discordMessageOnUserLogoutMessage;
    }

    public boolean isLogChannelEnabled() {
        return logChannelEnabled;
    }

    public boolean isShowEmojisNameEnabled() {
        return showEmojisName;
    }

    public long getDefaultChannelId() {
        return defaultChannelId;
    }

    public long getChatChannelId() {
        return chatChannelId;
    }

    public long getLogChannelId() {
        return logChannelId;
    }

    public boolean isInDebugMode() {
        return isDebugging;
    }
}

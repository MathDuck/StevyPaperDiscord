package me.math.stevydiscordpaper.managers;

import me.math.stevydiscordpaper.Main;
import me.math.stevydiscordpaper.managers.discord.commands.*;
import me.math.stevydiscordpaper.managers.discord.listeners.DiscordMessageListener;
import me.math.stevydiscordpaper.utils.EmojiData;
import me.math.stevydiscordpaper.utils.TimeSpan;
import me.math.stevydiscordpaper.utils.Util;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;

import java.awt.*;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

public class DiscordManager {
    private final Main plugin;
    private static DiscordApi api = null;
    boolean isTokenHere = true;

    public DiscordManager(Main plugin) {
        this.plugin = plugin;
    }

    public void init() {
        try {
            plugin.getLogger().info("Connecting Discord bot...");

            String discordToken = Main.getConfigManager().getDiscordToken();
            if (discordToken.equalsIgnoreCase("none") || discordToken.isBlank()) {
                isTokenHere = false;
            }

            if (isTokenHere) {
                api = new DiscordApiBuilder().setToken(discordToken).login().join();

                api.addMessageCreateListener(new PingCommand(plugin));
                api.addMessageCreateListener(new DiscordCommand(plugin));
                api.addMessageCreateListener(new InfosCommand(plugin));
                api.addMessageCreateListener(new OnlineCommand(plugin));
                api.addMessageCreateListener(new TPSCommand(plugin));
                api.addMessageCreateListener(new WhitelistCommand(plugin));
                api.addMessageCreateListener(new DiscordMessageListener());

                User user = api.getYourself();
                if (user != null) {
                    plugin.getLogger().info("Connected on bot => " + user.getDiscriminatedName());
                    sendLogMessageToDiscord(user.getName() + " is ready!", true, Color.CYAN);
                }

                startDiscordCycle();

            } else {
                plugin.getLogger().warning("Discord Token is not configured in option file.");
            }

        } catch (Exception e) {
            plugin.getLogger().warning("Problem when loading Discord Bot => " + e.getMessage());
        }
    }

    public void sendListenerMessageToDiscord(Player player, String structure, Color color) {
        if (!isTokenHere)
            return;

        long defaultChannelId = Main.getConfigManager().getDefaultChannelId();
        if (defaultChannelId == 0)
            return;

        Optional<TextChannel> channel = api.getTextChannelById(defaultChannelId);

        String toSend = structure.replaceAll("%name%", player.getName());
        if (Main.getConfigManager().isUsingEmbedDiscordMessage()) {
            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle("[" + Util.completeDate() + "]")
                    .setDescription(toSend)
                    .setColor(color)
                    .setThumbnail("https://minotar.net/avatar/" + player.getUniqueId().toString().replace("-", "") + "/60");

            channel.ifPresent(textChannel -> {
                textChannel.sendMessage(embed);
            });
        } else {
            channel.ifPresent(textChannel -> {
                textChannel.sendMessage("[" + Util.completeDate() + "] " + toSend);
            });
        }
    }

    public void sendMessageToDiscord(String name, String message) {
        long chatChannelId = Main.getConfigManager().getChatChannelId();
        if (chatChannelId == 0)
            return;

        Optional<TextChannel> channel = api.getTextChannelById(chatChannelId);

        String toSend = Main.getConfigManager().getMCToDiscordTemplateMessage().replaceAll("%name%", name);
        toSend = toSend.replaceAll("%message%", message);
        String finalToSend = toSend;

        channel.ifPresent(textChannel -> {
            textChannel.sendMessage("*[" + Util.justClock() + "]*  " + finalToSend);
        });
    }

    public void sendCommandMessageToDiscord(String message) {
        if (!isTokenHere)
            return;

        long logChannelId = Main.getConfigManager().getLogChannelId();
        if (logChannelId == 0)
            return;

        Optional<TextChannel> channel = api.getTextChannelById(logChannelId);

        channel.ifPresent(textChannel -> {
            textChannel.sendMessage("```[" + Util.completeDate() + "] " + message + "```");
        });
    }

    public void sendLogMessageToDiscord(String message, boolean useEmbed, Color color) {
        if (!isTokenHere)
            return;

        long logChannelId = Main.getConfigManager().getLogChannelId();
        if (logChannelId == 0)
            return;

        Optional<TextChannel> channel = api.getTextChannelById(logChannelId);

        if (useEmbed && Main.getConfigManager().isUsingEmbedDiscordMessage()) {
            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle("[" + Util.completeDate() + "]")
                    .setDescription(message)
                    .setColor(color);

            channel.ifPresent(textChannel -> {
                textChannel.sendMessage(embed);
            });
        } else {
            channel.ifPresent(textChannel -> {
                textChannel.sendMessage("[" + Util.completeDate() + "] " + message);
            });
        }
    }

    public void sendMessageToMinecraft(String name, String message) {
        if (!isTokenHere)
            return;

        message = message.replaceAll("\u00a7", "");
        String toSend = Main.getConfigManager().getDiscordToMCTemplateMessage().replaceAll("&", "\u00a7");
        toSend = toSend.replaceAll("%name%", name);
        toSend = toSend.replaceAll("%message%", message);
        for (Player p : Bukkit.getOnlinePlayers()) p.sendMessage((BaseComponent) new TextComponent(toSend));
    }

    private void startDiscordCycle() {
        int delay = 10000; // delay for 10 sec.
        int period = 15000; // repeat every 15 sec.
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                long start = System.currentTimeMillis();
                updateDiscordInfos();
                TimeSpan span = new TimeSpan(start, System.currentTimeMillis());
                if (span.toMilliseconds() > 2000) {
                    plugin.getLogger().warning("Processing took: " + span.toMilliseconds() + "ms to execute.");
                }
            }
        }, delay, period);
    }

    public void forceUpdate() {
        if (!isTokenHere)
            return;

        updateDiscordInfos();
    }

    private static void updateDiscordInfos() {
        if (api != null) {
            String Message = "Connecté(s): " + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + " - " + Bukkit.getBukkitVersion().split("-")[0];
            api.updateActivity(ActivityType.PLAYING, Message);
        }
    }

    public String formatDiscordMessage(String message) {
        for (EmojiData emojiData : EmojiData.values()) {
            message = message.replace(emojiData.unicode, emojiData.minecraftFormat);
        }
        return message;
    }

    public String formatMinecraftMessage(String message) {
        for (EmojiData emojiData : EmojiData.values()) {
            message = message.replace(emojiData.minecraftFormat, emojiData.discordFormat);
        }
        return message;
    }

    public void dispose() {
        if (api == null || !isTokenHere)
            return;

        api.unsetActivity();
        api.disconnect();
        api = null;
    }
}

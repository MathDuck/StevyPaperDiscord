package me.math.stevydiscordpaper.managers.discord.commands;

import me.math.stevydiscordpaper.Main;
import org.bukkit.Bukkit;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class PingCommand implements MessageCreateListener {
    private final Main plugin;

    public PingCommand(Main main) {
        this.plugin = main;
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        Bukkit.getScheduler().runTask(plugin, () -> {
            if (event.getMessageContent().equalsIgnoreCase(Main.getConfigManager().getDiscordPrefix() + "ping")) {
                event.deleteMessage();
                event.getChannel().sendMessage("```Pong héhé!```");
            }
        });
    }
}

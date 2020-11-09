package me.math.stevydiscordpaper.managers.discord.commands;

import me.math.stevydiscordpaper.Main;
import org.bukkit.Bukkit;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class PingCommand implements MessageCreateListener {
    private Main main;

    public PingCommand(Main main) {
        this.main = main;
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        Bukkit.getScheduler().runTask(main, () -> {
            if (event.getMessageContent().equalsIgnoreCase(Main.getConfigManager().getDiscordPrefix() + "ping")) {
                event.deleteMessage();
                event.getChannel().sendMessage("```Pong héhé!```");
            }
        });
    }
}

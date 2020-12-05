package me.math.stevydiscordpaper.managers.discord.commands;

import me.math.stevydiscordpaper.Main;
import org.bukkit.Bukkit;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.Optional;

public class DiscordCommand implements MessageCreateListener {
    private Main plugin;

    public DiscordCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        Bukkit.getScheduler().runTask(plugin, () -> {
            if (event.getMessageContent().equalsIgnoreCase(Main.getConfigManager().getDiscordPrefix() + "discord")) {
                event.deleteMessage();

                Optional<ServerTextChannel> TextChannel = event.getChannel().asServerTextChannel();
                Optional<User> User = event.getMessageAuthor().asUser();
                if (TextChannel.isPresent()) {
                    if (User.isPresent()) {
                        if (TextChannel.get().hasPermission(User.get(), PermissionType.ADMINISTRATOR)) {
                            Main.getDiscordManager().dispose();
                            plugin.getLogger().info("Closing Connection to Discord...");
                            Main.getDiscordManager().init();
                        }
                    }
                }
            }
        });
    }
}

package me.math.stevydiscordpaper.managers.discord.commands;

import me.math.stevydiscordpaper.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.Optional;

public class WhitelistCommand implements MessageCreateListener {
    private Main plugin;

    public WhitelistCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        Bukkit.getScheduler().runTask(plugin, () -> {
            if (event.getMessageContent().startsWith(Main.getConfigManager().getDiscordPrefix() + "wl ")) {
                event.deleteMessage();

                Optional<ServerTextChannel> TextChannel = event.getChannel().asServerTextChannel();
                if (TextChannel.isPresent()) {
                    Optional<User> user = event.getMessageAuthor().asUser();
                    if (user.isPresent()) {
                        if (!TextChannel.get().hasPermission(user.get(), PermissionType.ADMINISTRATOR))
                            return;
                    }
                }

                String content = event.getMessageContent().substring(4);
                String[] args = content.split(" ");

                switch (args[0]) {
                    case "add": {
                        OfflinePlayer addPlayer = Bukkit.getOfflinePlayer(args[1]);
                        if (Bukkit.getWhitelistedPlayers().contains(addPlayer)) {
                            event.getChannel().sendMessage(addPlayer.getName() + " est déjà dans la whitelist.");
                        } else {
                            addPlayer.setWhitelisted(true);
                            Bukkit.reloadWhitelist();
                            event.getChannel().sendMessage(addPlayer.getName() + " a été ajouté à la whitelist.");
                        }
                        return;
                    }

                    case "remove": {
                        OfflinePlayer removePlayer = Bukkit.getOfflinePlayer(args[1]);
                        if (Bukkit.getWhitelistedPlayers().contains(removePlayer)) {
                            removePlayer.setWhitelisted(false);
                            Bukkit.reloadWhitelist();
                            event.getChannel().sendMessage(removePlayer.getName() + " a été retiré de la whitelist.");
                        } else {
                            event.getChannel().sendMessage(removePlayer.getName() + " n'est pas dans la whitelist.");
                        }
                        return;
                    }

                    case "list": {
                        StringBuilder text = new StringBuilder();
                        if (Bukkit.getWhitelistedPlayers().size() > 0) {
                            for (OfflinePlayer player : Bukkit.getWhitelistedPlayers()) {
                                text.append("> - `").append(player.getName()).append("`\n");
                            }
                        } else
                            text.append("Aucun whitelisté.");
                        event.getChannel().sendMessage(String.valueOf(text));
                        return;
                    }

                    default:
                        event.getChannel().sendMessage("Argument introuvable.");
                }
            }
        });
    }
}


package me.math.stevydiscordpaper.managers.discord.listeners;

import me.math.stevydiscordpaper.Main;
import org.bukkit.Bukkit;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class DiscordMessageListener implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getChannel().getId() == Main.getConfigManager().getChatChannelId()) {
            if (!event.getMessageAuthor().isYourself()) {
                String finalName = event.getMessageAuthor().getDiscriminatedName();
                String message = event.getMessageContent();
                if (Main.getConfigManager().isShowEmojisNameEnabled())
                    message = Main.getDiscordManager().formatDiscordMessage(event.getMessageContent());

                Main.getDiscordManager().sendMessageToMinecraft(finalName, message);
            }
        } else if (event.getChannel().getId() == Main.getConfigManager().getLogChannelId()) {
            if (!event.getMessageAuthor().isYourself()) {
                if (event.getMessageAuthor().isServerAdmin()) {
                    if (event.getMessageContent().startsWith(Main.getConfigManager().getDiscordPrefix()))
                        return;

                    String nickname = event.getMessageAuthor().getDisplayName();
                    String finalName = nickname != null && !nickname.isEmpty() ? nickname : event.getMessageAuthor().getDiscriminatedName();

                    event.deleteMessage();
                    if (Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), event.getMessageContent())) {
                        Main.getDiscordManager().sendCommandMessageToDiscord(finalName + " a utilisé une commande via Discord: /" + event.getMessageContent());
                    } else
                        event.getChannel().sendMessage("Commande invalide (Note: Pas de / avant la commande): " + event.getMessageContent());
                }
            }
        }
    }
}

package me.math.stevydiscordpaper.managers.discord.commands;

import me.math.stevydiscordpaper.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;

public class OnlineCommand implements MessageCreateListener {
    private Main plugin;

    public OnlineCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        Bukkit.getScheduler().runTask(plugin, () -> {
            if (event.getMessageContent().equalsIgnoreCase(Main.getConfigManager().getDiscordPrefix() + "online")) {
                event.deleteMessage();

                StringBuilder text = new StringBuilder();
                if (Bukkit.getOnlinePlayers().size() > 0) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        text.append("- *" + player.getName() + "*\n");
                    }
                } else
                    text.append("Aucun connecté.");

                EmbedBuilder embed = new EmbedBuilder()
                        .setTitle("Liste des connectés")
                        .setDescription(text.toString())
                        .setColor(Color.CYAN)
                        .setFooter("Made By Math");

                event.getChannel().sendMessage(embed);
            }
        });
    }
}

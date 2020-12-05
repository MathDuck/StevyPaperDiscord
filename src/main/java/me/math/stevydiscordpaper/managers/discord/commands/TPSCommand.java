package me.math.stevydiscordpaper.managers.discord.commands;

import me.math.stevydiscordpaper.Main;
import org.bukkit.Bukkit;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;

public class TPSCommand implements MessageCreateListener {
    private Main plugin;

    public TPSCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        Bukkit.getScheduler().runTask(plugin, () -> {
            if (event.getMessageContent().equalsIgnoreCase(Main.getConfigManager().getDiscordPrefix() + "tps")) {
                event.deleteMessage();
                String FinalTPS = "";
                for (double tps : Bukkit.getTPS())
                    FinalTPS += Double.toString(tps).substring(0, 5) + ", ";

                EmbedBuilder embed = new EmbedBuilder()
                        .setTitle("TPS du Serveur")
                        .setDescription(("Serveur TPS: [" + FinalTPS.substring(0, FinalTPS.length() - 2) + "]\n"))
                        .setColor(Color.CYAN)
                        .setFooter("Made By Math");
                event.getChannel().sendMessage(embed);
            }
        });
    }
}


package me.math.stevydiscordpaper.managers.discord.commands;

import me.math.stevydiscordpaper.Main;
import org.bukkit.Bukkit;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;

public class InfosCommand implements MessageCreateListener {
    private Main plugin;

    public InfosCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        Bukkit.getScheduler().runTask(plugin, () -> {
            if (event.getMessageContent().equalsIgnoreCase(Main.getConfigManager().getDiscordPrefix() + "infos")) {
                event.deleteMessage();

                String text = "Le serveur minecraft est lancé sur la version " + Bukkit.getBukkitVersion().split("-")[0] + ".\n" +
                        "Version de l'API Paper: " + Bukkit.getVersion() + ".\n" +
                        "IP de connexion: " + Main.getConfigManager().getServerHost() + "\n" +
                        "Il y a actuellement " + Bukkit.getOnlinePlayers().size() + (Bukkit.getOnlinePlayers().size() > 1 ? " connectés" : " connecté") + " sur un maximum de " + Bukkit.getMaxPlayers() + " slot(s).\n";
                EmbedBuilder embed = new EmbedBuilder()
                        .setTitle("Statut du serveur")
                        .setDescription(text)
                        .setColor(Color.GREEN)
                        .setFooter("Made By Math");
                event.getChannel().sendMessage(embed);
            }
        });
    }
}
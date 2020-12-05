package me.math.stevydiscordpaper.managers.paper.listeners.players;

import me.math.stevydiscordpaper.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

import java.awt.*;

public class PlayerAdvancementDoneListener implements Listener {
    private Main plugin;

    public PlayerAdvancementDoneListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerAdvancementDoneEvent(PlayerAdvancementDoneEvent event) {
        Player player = event.getPlayer();

        String sanitizedName = event.getAdvancement().getKey().getKey().replace("/", ".");
        String advancementTitle = Main.getTextManager().getTextData("advancements." + sanitizedName + ".title");
        String advancementDescription = Main.getTextManager().getTextData("advancements." + sanitizedName + ".description");

        if (advancementTitle.isEmpty() || advancementDescription.isBlank())
            return;

        if (sanitizedName.contains("root"))
            Main.getDiscordManager().sendListenerMessageToDiscord(player, "**%name%** a débloqué l'onglet **[" + advancementTitle + "]**.\n*(" + advancementDescription + ")*", Color.CYAN);
        else
            Main.getDiscordManager().sendListenerMessageToDiscord(player, "**%name%** a réalisé le progrès **[" + advancementTitle + "]**.\n*(" + advancementDescription + ")*", Color.GREEN);
    }
}
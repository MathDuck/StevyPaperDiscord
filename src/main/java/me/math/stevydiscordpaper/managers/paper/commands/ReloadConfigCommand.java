package me.math.stevydiscordpaper.managers.paper.commands;

import me.math.stevydiscordpaper.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ReloadConfigCommand implements CommandExecutor {
    private final Main plugin;

    public ReloadConfigCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player || sender instanceof ConsoleCommandSender)) {
            sender.sendMessage("Seuls les joueurs peuvent utiliser les commandes!");
            return true;
        }

        if (!sender.isOp()) {
            sender.sendMessage("Seuls les joueurs OP peuvent utiliser les commandes!");
            return true;
        }

        assert sender instanceof Player;
        Player player = (Player) sender;

        Main.getConfigManager().init();
        Main.getDiscordManager().forceUpdate();
        player.sendMessage("Reloaded configuration file.");

        return true;
    }
}

package net.ddns.mlgland.minetils.commands;

import net.ddns.mlgland.minetils.commands.server.CommandReload;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MasterCommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        // checks if the sender is a player
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length >= 1) {
                switch (args[0]) {
                    case "reload":
                        CommandReload.bind(sender, command, s, args);
                        return true;
                }
            } else {
                player.sendMessage(ChatColor.RED + "Usage: /tw <command> [args]");
            }
        }
        return true;
    }
}

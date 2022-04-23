package net.ddns.mlgland.minetils.commands.server;

import net.ddns.mlgland.minetils.Type;
import net.ddns.mlgland.minetils.events.KickEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandKick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("kick")) {
            if (args.length == 0) {
                commandSender.sendMessage(ChatColor.RED + "Usage: /kick <player> [reason]");
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                commandSender.sendMessage(ChatColor.DARK_RED + "Error executing command: invalid argument [0]: player might not be online or is not specified");
                commandSender.sendMessage(ChatColor.RED + "Usage: /kick <player> [reason]");
                return true;
            }

            if (args.length >= 2) {
                StringBuffer kickReason = new StringBuffer();

                for (int i = 1; i <= (args.length - 1); i++) {
                    kickReason.append(args[i]);
                    kickReason.append(" ");
                }

                target.kickPlayer("§c" + kickReason.toString());
                Bukkit.getServer().getPluginManager().callEvent(new KickEvent(target, Type.KICK));
            } else {
                target.kickPlayer("§cYou have been kicked for an unspecified reason.");
                Bukkit.getServer().getPluginManager().callEvent(new KickEvent(target, Type.KICK));
            }
        }
        return true;
    }
}

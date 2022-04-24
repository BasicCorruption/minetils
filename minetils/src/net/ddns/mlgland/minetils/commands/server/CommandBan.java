package net.ddns.mlgland.minetils.commands.server;

import net.ddns.mlgland.minetils.Type;
import net.ddns.mlgland.minetils.events.BanEvent;
import net.ddns.mlgland.minetils.events.KickEvent;
import net.ddns.mlgland.minetils.events.UnbanEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBan implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("ban")) {
            if (args.length == 0) {
                commandSender.sendMessage(ChatColor.RED + "Usage: /ban <player> [reason]");
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                commandSender.sendMessage(ChatColor.DARK_RED + "Error executing command: invalid argument [0]: player might not be online or is not specified");
                return true;
            }

            if (args.length >= 2) {
                StringBuffer banReason = new StringBuffer();

                for (int i = 1; i <= (args.length - 1); i++) {
                    banReason.append(args[i]);
                    banReason.append(" ");
                }

                if (target.isBanned()) {
                    commandSender.sendMessage(ChatColor.RED + "Error executing command: invalid argument [0]: player might already be banned, is not online right now, or does not exist");
                } else {
                    target.kickPlayer("§c" + banReason.toString());
                    //target.setBanned(true);
                    Bukkit.getServer().getPluginManager().callEvent(new BanEvent(target, Type.BAN, banReason.toString()));
                    //System.out.println("Banned a player");
                }
            } else {
                target.kickPlayer("§cYou have been banned for an unspecified reason.");
                //target.setBanned(true);
                Bukkit.getServer().getPluginManager().callEvent(new BanEvent(target, Type.BAN, "You have been banned for an unspecified reason."));
                //System.out.println("Banned a player");
            }
        } else if (command.getName().equalsIgnoreCase("unban")) {
            if (args.length == 0) {
                commandSender.sendMessage(ChatColor.RED + "Usage: /unban <player>");
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                commandSender.sendMessage(ChatColor.DARK_RED + "Error executing command: invalid argument [0]: player might not be online or is not specified");
                return true;
            }

            if (target.isBanned()) {
                target.setBanned(false);
                Bukkit.getServer().getPluginManager().callEvent(new UnbanEvent(target, Type.UNBAN));
            } else {
                commandSender.sendMessage(ChatColor.RED + "Error executing command: invalid argument [0]: player might not be banned, is not online right now, or does not exist");
            }
        }
        return true;
    }
}

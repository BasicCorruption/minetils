package net.ddns.mlgland.minetils.commands.client;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {

        } else {
            Player player = (Player) commandSender;

            if (player.hasPermission("minetils.commands.basic.test")) {
                player.sendMessage(ChatColor.GREEN + "Plugin is working all fine!");
            } else {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to execute this command!");
            }
        }


        return true;

    }
}

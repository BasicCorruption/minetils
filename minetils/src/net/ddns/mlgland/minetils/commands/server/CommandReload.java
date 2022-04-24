package net.ddns.mlgland.minetils.commands.server;

import net.ddns.mlgland.minetils.config.Config;
import net.ddns.mlgland.minetils.config.Database;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandReload {
     public static boolean bind(CommandSender commandSender, Command command, String label, String[] args) {
         Player player = (Player) commandSender;

         if (player.hasPermission("minetils.commands.advanced.reload")) {
             Config.reload();
             Database.reload();
         }

         return true;
     }
}

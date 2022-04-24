package net.ddns.mlgland.minetils.commands.server;

import net.ddns.mlgland.minetils.config.Config;
import net.ddns.mlgland.minetils.config.Database;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandReload {
     public static boolean bind(CommandSender commandSender, Command command, String label, String[] args) {
         Player player = (Player) commandSender;

         if (player.hasPermission("minetils.commands.literal_danger.reload")) {
             Config.reload();
             Database.reload();
         } else {
             commandSender.sendMessage("§4§lYou do not have permission to use this command");
         }

         return true;
     }
}

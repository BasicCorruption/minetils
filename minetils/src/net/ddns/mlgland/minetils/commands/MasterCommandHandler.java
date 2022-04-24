package net.ddns.mlgland.minetils.commands;

import net.ddns.mlgland.minetils.config.Config;
import net.ddns.mlgland.minetils.config.Database;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MasterCommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length >= 1) {
            switch (args[0]) {
                case "reload":
                    if (sender.hasPermission("minetils.commands.literal_danger.reload")) {
                        System.out.println("Reloading MineTils config and database");
                        sender.sendMessage(ChatColor.DARK_RED + "MineTils config and database are being reloaded. If you encounter any issues, use /restart to restart the entire server.");
                        Config.reload();
                        Database.reload();
                        sender.sendMessage(ChatColor.GREEN + "MineTils reload complete! If you encounter any issues, use /restart to restart the entire server.");
                        System.out.println("MineTils config and database have been successfully reloaded!");
                    } else {
                        sender.sendMessage("§4§lYou do not have permission to use this command");
                    }

                    return true;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Usage: /mt <command> [args]");
            return true;
        }
        return true;
    }
}

package net.mlgland.minetils.commands.server;

import net.mlgland.minetils.config.Config;
import net.mlgland.minetils.config.Database;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.GameMode.*;

public class CommandGamemode implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        Player player = (Player) commandSender;

        if (player.hasPermission("minetils.commands.gamemode")) {
            switch (label) {
                case "gms":
                case "gm0":
                case "gmsurvival":
                case "gsurvival":
                case "gmodesurvival":
                case "gamemodesurvival":
                case "gamemode0":
                case "gmode0":
                case "gmod0":
                    // switch the gamemode to survival
                    player.setGameMode(SURVIVAL);
                    player.sendMessage("§aYou have set your gamemode to survival!");
                    System.out.println("[Minetils] [Admin Log]" + player.getName() + " has set their gamemode to survival");
                    break;
                case "gmc":
                case "gm1":
                case "gmcreative":
                case "gcreative":
                case "gmodecreative":
                case "gamemodecreative":
                case "gamemode1":
                case "gmode1":
                case "gmod1":
                    // switch the gamemode to creative
                    player.setGameMode(CREATIVE);
                    player.sendMessage("§aYou have set your gamemode to creative!");
                    System.out.println("[Minetils] [Admin Log]" + player.getName() + " has set their gamemode to creative");
                    break;
                case "gma":
                case "gm2":
                case "gmadventure":
                case "gadventure":
                case "gmodeadventure":
                case "gamemodeadventure":
                case "gamemode2":
                case "gmode2":
                case "gmod2":
                    // switch the gamemode to adventure
                    player.setGameMode(ADVENTURE);
                    player.sendMessage("§aYou have set your gamemode to adventure!");
                    System.out.println("[Minetils] [Admin Log]" + player.getName() + " has set their gamemode to adventure");
                    break;
                case "gmsp":
                case "gm3":
                case "gmspectator":
                case "gspectator":
                case "gmodespectator":
                case "gamemodespectator":
                case "gamemode3":
                case "gmode3":
                case "gmod3":
                    // switch the gamemode to spectator
                    player.setGameMode(SPECTATOR);
                    player.sendMessage("§aYou have set your gamemode to spectator!");
                    System.out.println("[Minetils] [Admin Log]" + player.getName() + " has set their gamemode to spectator");
                    break;
                default:
                    // check the first argument
                    if (args.length > 0) {
                        switch (args[0]) {
                            case "0":
                            case "survival":
                                player.setGameMode(SURVIVAL);
                                player.sendMessage("§aYou have set your gamemode to survival!");
                                System.out.println("[Minetils] [Admin Log]" + player.getName() + " has set their gamemode to survival");
                                break;
                            case "1":
                            case "creative":
                                player.setGameMode(CREATIVE);
                                player.sendMessage("§aYou have set your gamemode to creative!");
                                System.out.println("[Minetils] [Admin Log]" + player.getName() + " has set their gamemode to creative");
                                break;
                            case "2":
                            case "adventure":
                                player.setGameMode(ADVENTURE);
                                player.sendMessage("§aYou have set your gamemode to adventure!");
                                System.out.println("[Minetils] [Admin Log]" + player.getName() + " has set their gamemode to adventure");
                                break;
                            case "3":
                            case "spectator":
                                player.setGameMode(SPECTATOR);
                                player.sendMessage("§aYou have set your gamemode to spectator!");
                                System.out.println("[Minetils] [Admin Log]" + player.getName() + " has set their gamemode to spectator");
                                break;
                            default:
                                player.sendMessage("§4§lInvalid gamemode");
                                break;
                        }
                    } else {
                        player.sendMessage("Usage: /gamemode <gamemode name/id>");
                    }
            }
        } else {
            commandSender.sendMessage("§4§lYou do not have permission to use this command");
        }

        return true;
    }
}

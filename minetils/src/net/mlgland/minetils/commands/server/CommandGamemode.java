package net.mlgland.minetils.commands.server;

import net.mlgland.minetils.config.Config;
import net.mlgland.minetils.config.Database;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.GameMode.*;

public class CommandGamemode {
    public static boolean bind(CommandSender commandSender, Command command, String label, String[] args) {
        Player player = (Player) commandSender;

        if (player.hasPermission("minetils.commands.gamemode")) {
            switch (command.toString()) {
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
                    break;
            }
        } else {
            commandSender.sendMessage("§4§lYou do not have permission to use this command");
        }

        return true;
    }
}

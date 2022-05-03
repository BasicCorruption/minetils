package net.ddns.mlgland.minetils.listeners.player;

import net.ddns.mlgland.minetils.config.Config;
import net.ddns.mlgland.minetils.config.Database;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin {
    public static void invoke(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        FileConfiguration db = Database.get();
        FileConfiguration cf = Config.get();

        // check to see if the player is in the ban database
        Boolean banned = (Boolean) db.get(player.getName() + ".status");

        if (banned) {
            String reason = (String) db.get(player.getName() + ".reason");

            player.kickPlayer("§4You have been banned indefinitely: " + reason);
        } else {
            if (!cf.get("enableJoinMessage").equals(true)) {
                player.sendMessage(cf.get("joinMessage").toString());
            }
        }
    }
}

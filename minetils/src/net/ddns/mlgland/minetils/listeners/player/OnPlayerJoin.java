package net.ddns.mlgland.minetils.listeners.player;

import net.ddns.mlgland.minetils.config.Database;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin {
    public static void invoke(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // check to see if the player is in the ban database
        Boolean banned = (Boolean) Database.get().get(player.getName() + ".status");

        if (banned) {
            String reason = (String) Database.get().get(player.getName() + ".reason");

            player.kickPlayer("§4You have been banned indefinitely: " + reason);
        }
    }
}

package net.ddns.mlgland.minetils.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin {
    public static void invoke(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // check to see if the player is in the ban database
    }
}

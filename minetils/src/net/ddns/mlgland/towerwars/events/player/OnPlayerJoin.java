package net.ddns.mlgland.towerwars.events.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin {
    public static void invoke(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.BLUE + "Welcome to TowerWars!");
        player.sendMessage(ChatColor.GRAY + "To join a game, open the compass.");
        player.sendMessage(ChatColor.GRAY + "To see how to play, open the book.");
    }
}

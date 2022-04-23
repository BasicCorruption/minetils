package net.ddns.mlgland.towerwars.events.player;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

public class OnPlayerMove {
    public static void invoke(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        int bx = player.getLocation().getBlockX();
        int by = player.getLocation().getBlockY() - 1;
        int bz = player.getLocation().getBlockZ();

        Material mat = player.getWorld().getBlockAt(bx, by, bz).getType();
        if (mat == Material.STONE) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "You are standing on stone!");
        }
    }
}

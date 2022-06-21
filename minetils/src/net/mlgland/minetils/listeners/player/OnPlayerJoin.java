package net.mlgland.minetils.listeners.player;

import net.mlgland.minetils.config.Config;
import net.mlgland.minetils.config.Database;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin {
    public static void invoke(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        FileConfiguration db = Database.get();
        FileConfiguration cf = Config.get();

        if (!cf.get("joinMessage").equals("")) {
            player.sendMessage(cf.get("joinMessage").toString());
        }
        if (cf.get("enableJoinAnnouncement").equals(true)) {
            event.setJoinMessage("");
        }
    }
}

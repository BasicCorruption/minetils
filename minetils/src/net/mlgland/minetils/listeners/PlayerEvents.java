package net.mlgland.minetils.listeners;

import net.mlgland.minetils.listeners.player.OnPlayerJoin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerEvents implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        OnPlayerJoin.invoke(event);
    }

}

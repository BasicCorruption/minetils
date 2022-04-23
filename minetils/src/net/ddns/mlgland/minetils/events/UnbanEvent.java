package net.ddns.mlgland.minetils.events;

import net.ddns.mlgland.minetils.Type;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UnbanEvent extends Event {
    Player p;
    Type t;

    public UnbanEvent(Player p, Type t) {
        this.p = p;
        this.t = t;
    }

    public Player getPlayer() {
        return p;
    }

    public Type getType() {
        return t;
    }

    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

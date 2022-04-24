package net.ddns.mlgland.minetils.events;

import net.ddns.mlgland.minetils.Type;
import net.ddns.mlgland.minetils.config.Database;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UnbanEvent extends Event {
    String p;
    Type t;

    public UnbanEvent(String p, Type t) {
        this.p = p;
        this.t = t;

        FileConfiguration db = Database.get();

        switch (t) {
            case BAN:
                break;
            case KICK:
                break;
            case UNBAN:
                db.set(p + ".status", false);
                break;
        }
    }

    public String getPlayer() {
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

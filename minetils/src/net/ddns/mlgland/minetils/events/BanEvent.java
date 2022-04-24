package net.ddns.mlgland.minetils.events;

import net.ddns.mlgland.minetils.Type;
import net.ddns.mlgland.minetils.config.Database;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;

public class BanEvent extends Event {

    Player p;
    Type t;

    public BanEvent(Player p, Type t) {
        this.p = p;
        this.t = t;

        List banlist = Database.get().getList("banlist");

        switch (t) {
            case BAN:
                break;
            case KICK:
                break;
            case UNBAN:
                for (int i = 1; i <= (banlist.size() - 1); i++) {
                    if (banlist.get(i) == p.getName()) {
                        banlist.remove(i);
                    }
                }
                break;
        }
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

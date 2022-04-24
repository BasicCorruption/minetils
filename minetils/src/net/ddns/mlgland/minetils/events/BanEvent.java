package net.ddns.mlgland.minetils.events;

import net.ddns.mlgland.minetils.Type;
import net.ddns.mlgland.minetils.config.Database;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.ArrayList;
import java.util.List;

public class BanEvent extends Event {

    Player p;
    Type t;

    public BanEvent(Player p, Type t, String r) {
        this.p = p;
        this.t = t;

        //System.out.println("Ban event received");

        FileConfiguration db = Database.get();

        switch (t) {
            case BAN:
                //db.createSection(p.getName());
                db.set(p.getName() + ".status", true);
                db.set(p.getName() + ".reason", r);
                //System.out.println("Added a player to the ban database");
                break;
            case KICK:
                break;
            case UNBAN:
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

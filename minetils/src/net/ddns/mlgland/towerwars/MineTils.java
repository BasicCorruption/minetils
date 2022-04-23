package net.ddns.mlgland.towerwars;

import net.ddns.mlgland.towerwars.commands.CommandHandler;
import net.ddns.mlgland.towerwars.commands.client.CommandTest;
import net.ddns.mlgland.towerwars.events.PlayerEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MineTils extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("[MineTils] Registering events...");
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        getServer().getConsoleSender().sendMessage("[MineTils] Registered event 1/1 (task 1/3)");

        getServer().getConsoleSender().sendMessage("[MineTils] Registering command handler...");
        getCommand("minetils").setExecutor(new CommandHandler());
        getServer().getConsoleSender().sendMessage("[MineTils] Registered command handler (task 2/3)");

        getServer().getConsoleSender().sendMessage("[MineTils] Registering commands...");
        getCommand("mttest").setExecutor(new CommandTest());
        getServer().getConsoleSender().sendMessage("[MineTils] Registered command 1/1 (task 3/3)");

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MineTils] Plugin is now enabled");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MineTils] Plugin is now disabled");
    }

}

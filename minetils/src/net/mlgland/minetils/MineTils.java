package net.mlgland.minetils;

import net.mlgland.minetils.commands.MasterCommandHandler;
import net.mlgland.minetils.commands.client.CommandTest;
import net.mlgland.minetils.commands.server.CommandGamemode;
import net.mlgland.minetils.config.Config;
import net.mlgland.minetils.config.Database;
import net.mlgland.minetils.listeners.PlayerEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MineTils extends JavaPlugin {

    @Override
    public void onEnable() {
        // make new instances
        CommandGamemode cmdGamemode = new CommandGamemode();

        getServer().getConsoleSender().sendMessage("[MineTils] Registering events");
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        getServer().getConsoleSender().sendMessage("[MineTils] Registered events");

        getServer().getConsoleSender().sendMessage("[MineTils] Registering commands");
        getCommand("minetils").setExecutor(new MasterCommandHandler());
        getCommand("mttest").setExecutor(new CommandTest());
        getCommand("gamemode").setExecutor(cmdGamemode);
        getCommand("gms").setExecutor(cmdGamemode);
        getCommand("gmc").setExecutor(cmdGamemode);
        getCommand("gma").setExecutor(cmdGamemode);
        getCommand("gmsp").setExecutor(cmdGamemode);
        getServer().getConsoleSender().sendMessage("[MineTils] Registered commands");

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Config.setup();
        Config.save();
        Config.get().addDefault("joinMessage", "Welcome to the server! §4§lPowered by MineTils");
        Config.get().addDefault("enableJoinAnnouncement", false);
        Config.get().options().copyDefaults(true);
        Config.save();

        Database.setup();
        Database.get().options().copyDefaults(true);
        Database.save();



        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MineTils] Plugin is now enabled");
    }

    @Override
    public void onDisable() {
        Config.save();
        Database.save();

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MineTils] Plugin is now disabled");
    }

}

package net.ddns.mlgland.minetils.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    private static File file = new File(Bukkit.getServer().getPluginManager().getPlugin("MineTils").getDataFolder(), "config.yml");;
    private static FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("MineTils").getDataFolder(), "config.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            config = YamlConfiguration.loadConfiguration(file);
        }
    }

    public static FileConfiguration get() {
        return config;
    }

    public static void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reload() {
        config = YamlConfiguration.loadConfiguration(file);
    }

}

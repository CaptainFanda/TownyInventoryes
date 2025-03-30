package PolitGame.CaptainFanda.Data;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private static File config = new File("plugins/Fox/TownyInvs/config.yml");

    public static void createConfig() {
        YamlConfiguration ymlPut = YamlConfiguration.loadConfiguration(config);
        if(!config.exists()) {
            ymlPut.addDefault("language", "ru");
            ymlPut.addDefault("inventory-size", 54);
            ymlPut.options().copyDefaults(true);
            try {
                ymlPut.save(config);
            } catch (IOException var6) {
                var6.printStackTrace();
            }
        }
    }
    public static YamlConfiguration getConfig() {
        return YamlConfiguration.loadConfiguration(config);
    }
}

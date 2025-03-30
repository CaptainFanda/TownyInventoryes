package PolitGame.CaptainFanda.Data;

import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class TownsData {
    private static File townFile;
    private static String path = "plugins/Fox/TownyInvs/towns/";
    public static void addTown(Town town) {
        townFile = new File(path + town.getName() + ".yml");
        YamlConfiguration ymlPut = YamlConfiguration.loadConfiguration(townFile);
        ymlPut.addDefault("items", "none");
        ymlPut.options().copyDefaults(true);
        try {
            ymlPut.save(townFile);
        } catch (IOException var1) {
            var1.fillInStackTrace();
        }
    }
    public static void deleteTown(Town town) {
        townFile = new File(path + town.getName() + ",yml");
        YamlConfiguration ymlPut = YamlConfiguration.loadConfiguration(townFile);
        ymlPut.set("items", "none");
        ymlPut.options().copyDefaults(true);
        try {
            ymlPut.save(townFile);
        } catch (IOException var1) {
            var1.fillInStackTrace();
        }
    }

    public static YamlConfiguration getTownYAML(Town town) {
        townFile = new File(path + town.getName() + ".yml");
        return YamlConfiguration.loadConfiguration(townFile);
    }
    public static File getTownFile(Town town) {
        townFile = new File(path + town.getName() + ".yml");
        return townFile;
    }
}

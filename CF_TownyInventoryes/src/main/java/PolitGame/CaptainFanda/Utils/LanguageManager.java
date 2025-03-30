package PolitGame.CaptainFanda.Utils;

import PolitGame.CaptainFanda.Data.Config;
import PolitGame.CaptainFanda.Data.Messages;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

public class LanguageManager {
    public static YamlConfiguration getMessages() {
        YamlConfiguration CFG = Config.getConfig();
        if(CFG.getString("language").equals("ru")) {
            return Messages.getRu();
        } else
        if(CFG.getString("language").equals("en")) {
            return Messages.getEn();
        }
        return Messages.getEn();
    }

}

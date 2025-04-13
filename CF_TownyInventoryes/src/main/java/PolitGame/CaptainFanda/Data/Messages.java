package PolitGame.CaptainFanda.Data;

import org.bukkit.configuration.file.YamlConfiguration;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

public class Messages {
    private static File ru = new File("plugins/Fox/TownyInvs/language/ru.yml");
    private static File en = new File("plugins/Fox/TownyInvs/language/en.yml");

    public static void createMessages() {
        YamlConfiguration ymlPut;
        if(!ru.exists()) {
            ymlPut = YamlConfiguration.loadConfiguration(ru);
            LinkedHashMap<String, Object> messages = new LinkedHashMap<>();
            messages.put("prefix", "&7[&6Fox&7] ");
            messages.put("not-town", "&cУ вас нету Города");
            messages.put("not-mayor", "&cВы не мэр что бы открыть инвентарь Города");
            messages.put("not-permission", "&cНедостаточно прав");
            messages.put("succes-open-inv", "&aУспешно открыт инвентарь города");
            ymlPut.addDefaults(messages);
            ymlPut.options().copyDefaults(true);
            try {
                ymlPut.save(ru);
            } catch (IOException var5) {
                var5.printStackTrace();
            }
        }
        if(!en.exists()) {
            ymlPut = YamlConfiguration.loadConfiguration(en);
            LinkedHashMap<String, Object> messages = new LinkedHashMap<>();
            messages.put("prefix", "&7[&6Fox&7] ");
            messages.put("not-town", "&cYou dont have a town");
            messages.put("not-mayor", "&cYou not mayor");
            messages.put("not-permission", "&cNot have Permission");
            messages.put("succes-open-inv", "&aSucces open town inventory");
            ymlPut.addDefaults(messages);
            ymlPut.options().copyDefaults(true);
            try {
                ymlPut.save(en);
            } catch (IOException var5) {
                var5.printStackTrace();
            }
        }
    }

    public static YamlConfiguration getRu() { return YamlConfiguration.loadConfiguration(ru); }
    public static YamlConfiguration getEn() { return YamlConfiguration.loadConfiguration(en); }

}

package PolitGame.CaptainFanda;

import PolitGame.CaptainFanda.Commands.InventoryCommand;
import PolitGame.CaptainFanda.Data.Config;
import PolitGame.CaptainFanda.Data.Messages;
import PolitGame.CaptainFanda.Listener.PlayerListener;
import PolitGame.CaptainFanda.Listener.TownListener;
import com.palmergames.bukkit.towny.TownyCommandAddonAPI;
import com.palmergames.bukkit.towny.TownyCommandAddonAPI.CommandType;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.Console;

public final class CF_TownyInventoryes extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new TownListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        TownyCommandAddonAPI.addSubCommand(CommandType.TOWN, "inventory", new InventoryCommand());
        TownyCommandAddonAPI.addSubCommand(CommandType.TOWN, "inv", new InventoryCommand());
        Messages.createMessages();
        Config.createConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

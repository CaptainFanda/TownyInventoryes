package PolitGame.CaptainFanda.Listener;

import PolitGame.CaptainFanda.Data.TownsData;
import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.TownyUniverse;
import com.palmergames.bukkit.towny.event.NewTownEvent;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerListener implements Listener {

    @EventHandler
    public void onCloseInventory(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        Town town = TownyAPI.getInstance().getTown(player);
        Inventory inv = e.getInventory();
        YamlConfiguration yml;
        if(e.getView().getTitle().equals(town.getName())) {
            if (!TownsData.getTownFile(town).exists()) {
                try {
                    yml = YamlConfiguration.loadConfiguration(TownsData.getTownFile(town));
                    yml.addDefault("items", "none");
                    yml.options().copyDefaults(true);
                    yml.save(TownsData.getTownFile(town));
                } catch (IOException var10) {
                    var10.printStackTrace();
                }
            }
            try {
                yml = YamlConfiguration.loadConfiguration(TownsData.getTownFile(town));
                ItemStack[] itemlist = inv.getContents();
                yml.set("items", itemlist);
                yml.save(TownsData.getTownFile(town));
            } catch (Exception var9) {
                var9.printStackTrace();
            }
        }
    }
}

package PolitGame.CaptainFanda.Service;

import PolitGame.CaptainFanda.Data.Config;
import PolitGame.CaptainFanda.Data.TownsData;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InventoryService {
    public static void openInventory(Player player, Town town) {
        YamlConfiguration ymlPut = TownsData.getTownYAML(town);
        List<ItemStack> items = new ArrayList<>();
        ItemStack[] itemStacks;
        if(!ymlPut.get("items").equals("none")) {
            List list = ymlPut.getList("items");
            Iterator var3 = list.iterator();
            while(var3.hasNext()) {
                Object next = var3.next();
                if(next instanceof ItemStack) {
                    ItemStack item = (ItemStack) next;
                    items.add(item);
                }
            }
            itemStacks = new ItemStack[items.size()];

            for(int i = 0; i < items.size(); i++) {
                itemStacks[i] = (ItemStack) items.get(i);
            }
        } else {
            itemStacks = new ItemStack[1];
            ItemStack itemStack1 = new ItemStack(Material.AIR);
            itemStacks[0] = itemStack1;
        }
        Inventory inventory = Bukkit.createInventory(player, Config.getConfig().getInt("inventory-size"), town.getName());
        inventory.setContents(itemStacks);
        player.openInventory(inventory);
    }
}

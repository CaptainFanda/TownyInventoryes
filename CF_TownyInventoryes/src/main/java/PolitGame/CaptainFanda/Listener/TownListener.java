package PolitGame.CaptainFanda.Listener;

import PolitGame.CaptainFanda.Data.TownsData;
import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.event.DeleteTownEvent;
import com.palmergames.bukkit.towny.event.NewTownEvent;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TownListener implements Listener {
    @EventHandler
    public void onNewTown(NewTownEvent e) {
        TownsData.addTown(e.getTown());
    }
    @EventHandler
    public void onTownDelete(DeleteTownEvent e) {
        Town town = TownyAPI.getInstance().getTown(e.getTownName());
        TownsData.deleteTown(town);
    }
}

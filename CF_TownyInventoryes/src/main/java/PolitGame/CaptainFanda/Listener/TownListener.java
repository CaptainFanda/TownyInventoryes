package PolitGame.CaptainFanda.Listener;

import PolitGame.CaptainFanda.Data.TownsData;
import com.palmergames.bukkit.towny.event.NewTownEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TownListener implements Listener {
    @EventHandler
    public void onNewTown(NewTownEvent e) {
        TownsData.addTown(e.getTown());
    }
}

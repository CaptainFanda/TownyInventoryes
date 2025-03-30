package PolitGame.CaptainFanda.Commands;

import PolitGame.CaptainFanda.Service.InventoryService;
import PolitGame.CaptainFanda.Utils.LanguageManager;
import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.security.Provider;

public class InventoryCommand implements CommandExecutor {
    private static String prefix = LanguageManager.getMessages().getString("prefix");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player p) {
            Resident resident = TownyAPI.getInstance().getResident(p);
            Town town = TownyAPI.getInstance().getTown(p);
            if(town != null) {
                if(resident.isMayor() || p.isOp()) {
                    InventoryService.openInventory(p, town);
                    String message = LanguageManager.getMessages().getString("succes-open-inv");
                    message = message.replace('&', '§');
                    p.sendMessage(message);
                } else {
                    String message = LanguageManager.getMessages().getString("not-mayor");
                    message = message.replace('&', '§');
                    p.sendMessage(message);
                }
            } else {
                String message = LanguageManager.getMessages().getString("not-town");
                message = message.replace('&', '§');
                p.sendMessage(message);
            }
        }
        return true;
    }
}

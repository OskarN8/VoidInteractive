package lethal.voidinteractive.commands;

import lethal.voidinteractive.functions.VoidChest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class openVoidChestCommand implements CommandExecutor {
    private VoidChest voidChest;

    public openVoidChestCommand(VoidChest voidChest) {
        this.voidChest = voidChest;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.openInventory(voidChest.getChestInventory());
            return true;
        } else {
            sender.sendMessage("Tylko gracz moze otworzyc otchlan");
            return false;
        }
    }
}
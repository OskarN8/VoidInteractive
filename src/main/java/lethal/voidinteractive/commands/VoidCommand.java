//package lethal.voidinteractive.commands;
//
//import lethal.voidinteractive.functions.ScanItems;
//import lethal.voidinteractive.functions.VoidChest;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//
//public class VoidCommand implements CommandExecutor {
//    public VoidCommand(ScanItems sc, VoidChest vc){
//        scanItems = sc;
//        voidChest = vc;
//    }
//    ScanItems scanItems;
//    VoidChest voidChest;
//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//
//        if (!(sender instanceof Player)) return false;
//        Player player = (Player) sender;
//        player.sendMessage("Otwieranie voidChesta");
//        voidChest.openVoidChest(player);
//
//        return true;
//    }
//}
//
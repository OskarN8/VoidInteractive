//package lethal.voidinteractive.functions;
//
//import org.bukkit.Bukkit;
//import org.bukkit.entity.Entity;
//import org.bukkit.entity.Player;
//import org.bukkit.inventory.ItemStack;
//
//import java.util.Iterator;
//import java.util.List;
//
//public class ItemsToGUI {
//
//    public ItemsToGUI(ScanItems sc, VoidChest vc)
//    {
//        scanItems = sc;
//        voidChest = vc;
//    }
//
//    ScanItems scanItems;
//    VoidChest voidChest;
//
//
//    public Runnable sendItemsToGUI(){
//
//        List<Entity> items = scanItems.items;
////        List<Entity> items = scanItems.getAllGroundsItems();
//        Iterator<Entity> itemsIterator = items.iterator();
//        while(itemsIterator.hasNext()){
//            Entity item = itemsIterator.next();
//            item.remove();
//            Bukkit.getServer().broadcastMessage("Item "+item.getName()+" removed");
//
//            voidChest.voidChest.addItem((ItemStack) item);
//        }
//        return null;
//    }
//}

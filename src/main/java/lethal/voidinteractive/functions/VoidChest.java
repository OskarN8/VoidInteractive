package lethal.voidinteractive.functions;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;
import java.util.List;

public class VoidChest  {
    private Inventory chestInventory;


    public VoidChest() {
        chestInventory = Bukkit.createInventory(null, 54, "Otchlan");
    }

    public void addItems(List<ItemStack> items) {
        Iterator<ItemStack> iterator = items.iterator();
        while (iterator.hasNext()) {
            chestInventory.addItem(iterator.next());
        }
    }

    public void clearItems() {
        chestInventory.clear();
    }

    public Inventory getChestInventory() {
        return chestInventory;
    }

}

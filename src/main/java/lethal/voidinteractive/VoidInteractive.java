package lethal.voidinteractive;
import lethal.voidinteractive.commands.openVoidChestCommand;
import lethal.voidinteractive.functions.ClearItems;
import lethal.voidinteractive.functions.VoidChest;

import lethal.voidinteractive.listeners.OnInventoryClick;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.w3c.dom.ls.LSException;

public final class VoidInteractive extends JavaPlugin {

    private final int CLEAR_ITEMS_INTERVAL = 20;
    private ClearItems scanItems;
    private  VoidChest voidChest;
    private OnInventoryClick onInventoryClick;

    @Override
    public void onEnable() {

        voidChest = new VoidChest();
        scanItems = new ClearItems(this,voidChest);
        onInventoryClick = new OnInventoryClick(voidChest.getChestInventory());

        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(onInventoryClick,this);


        getCommand("otchlan").setExecutor(new openVoidChestCommand(voidChest));
        getServer().getScheduler().scheduleSyncRepeatingTask(this,scanItems,0,CLEAR_ITEMS_INTERVAL);
    }
}
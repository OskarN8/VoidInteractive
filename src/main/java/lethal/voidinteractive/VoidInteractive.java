package lethal.voidinteractive;
import lethal.voidinteractive.functions.ScanItems;
import lethal.voidinteractive.functions.VoidChest;

import org.bukkit.plugin.java.JavaPlugin;

public final class VoidInteractive extends JavaPlugin {

    private final int SCAN_ITEMS_INTERVAL = 60;
    private  ScanItems scanItems;
    private  VoidChest voidChest;

    @Override
    public void onEnable() {
        voidChest = new VoidChest();
        scanItems = new ScanItems(this,voidChest);

        getCommand("otchlan").setExecutor(new voidChestCommandExecutor(voidChest));
        getServer().getScheduler().scheduleSyncRepeatingTask(this,scanItems,0,SCAN_ITEMS_INTERVAL);
    }

    @Override
    public void onDisable(){

    }

}
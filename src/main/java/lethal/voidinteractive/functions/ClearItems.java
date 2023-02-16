package lethal.voidinteractive.functions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class ClearItems implements Runnable {

    private List<ItemStack> itemStacks = new ArrayList<>();
    private Plugin plugin;
    private VoidChest voidChest;
    private final int CLEAR_ITEM_TIME = 60;
    private int timeLeft = CLEAR_ITEM_TIME;

    public ClearItems(Plugin plugin, VoidChest voidChest) {
        this.plugin = plugin;
        this.voidChest = voidChest;
    }

    private List<Chunk> getAllLoadedChunks() {
        List<World> worlds = Bukkit.getWorlds();
        World[] test = worlds.toArray(new World[0]);
        test[0].getEntities();

        List<Chunk> chunks = new ArrayList<>();
        Iterator<World> worldsIterator = worlds.iterator();

        while (worldsIterator.hasNext()) {
            World scannedWorld = worldsIterator.next();
            Iterator<Chunk> chunksIterator = Arrays.stream(scannedWorld.getLoadedChunks()).iterator();
            while (chunksIterator.hasNext()) {
                chunks.add(chunksIterator.next());
            }
        }
        return chunks;
    }

    private void clearItemsAndSendToChest() {

        List<Chunk> loadedChunks = getAllLoadedChunks();
        Iterator<Chunk> chunkIterator = loadedChunks.iterator();
        voidChest.clearItems();
        while (chunkIterator.hasNext()) {
            Chunk chunk = chunkIterator.next();
            Iterator<Entity> entityIterator = Arrays.stream(chunk.getEntities()).iterator();

            while (entityIterator.hasNext()) {
                Entity entity = entityIterator.next();
                if (entity instanceof Item) {
                    itemStacks.add(((Item) entity).getItemStack());
                    entity.remove();
                }
            }
        }
        voidChest.addItems(itemStacks);
        itemStacks.clear();
    }

    @Override
    public void run() {
        timeLeft--;

        if((timeLeft <= 5 && timeLeft > 0) || timeLeft == 10 || timeLeft == 15 || timeLeft == 30){
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "Otchlan zbiera itemy za " + ChatColor.YELLOW   + timeLeft + ChatColor.RED + " sekund!");
        }
        else if(timeLeft == 0)
        {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + "Otchlan otwiera sie!");
            clearItemsAndSendToChest();
            timeLeft = CLEAR_ITEM_TIME;
        }
    }
}


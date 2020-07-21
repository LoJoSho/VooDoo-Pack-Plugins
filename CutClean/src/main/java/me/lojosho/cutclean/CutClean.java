package me.lojosho.cutclean;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class CutClean extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void onAnimalDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (entity.getType() == EntityType.PIG) {
            int upper = this.getConfig().getInt("pig.max");
            int lower = this.getConfig().getInt("pig.min");
            int XPPigMax = this.getConfig().getInt("pig.xpmax");
            int XPPigMin = this.getConfig().getInt("pig.xpmin");
            int RandomPig = (int) (Math.random() * (upper - lower + 1)) + lower;
            int RandomPigXP = (int) (Math.random() * (XPPigMax - XPPigMin + 1)) + XPPigMin;
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.COOKED_PORKCHOP, RandomPig));
            event.setDroppedExp(RandomPigXP);
        }
        if (entity.getType() == EntityType.COW) {
            int upper = this.getConfig().getInt("cow.max");
            int lower = this.getConfig().getInt("cow.min");
            int XPCowMax = this.getConfig().getInt("cow.xpmax");
            int XPCowMin = this.getConfig().getInt("cow.xpmin");
            int RandomCow = (int) (Math.random() * (upper - lower + 1)) + lower;
            int RandomCowXP = (int) (Math.random() * (XPCowMax - XPCowMin + 1)) + XPCowMin;
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.COOKED_BEEF, RandomCow));
            event.setDroppedExp(RandomCowXP);
        }
        if (entity.getType() == EntityType.CHICKEN) {
            int upper = this.getConfig().getInt("chicken.max");
            int lower = this.getConfig().getInt("chicken.min");
            int XPMax = this.getConfig().getInt("chicken.xpmax");
            int XPMin = this.getConfig().getInt("chicken.xpmin");
            int RandomAmountDropped = (int) (Math.random() * (upper - lower + 1)) + lower;
            int RandomXP = (int) (Math.random() * (XPMax - XPMin + 1)) + XPMin;
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.COOKED_CHICKEN, RandomAmountDropped));
            event.setDroppedExp(RandomXP);
        }
        if (entity.getType() == EntityType.SHEEP) {
            int upper = this.getConfig().getInt("sheep.max");
            int lower = this.getConfig().getInt("sheep.min");
            int XPMax = this.getConfig().getInt("sheep.xpmax");
            int XPMin = this.getConfig().getInt("sheep.xpmin");
            int RandomAmountDropped = (int) (Math.random() * (upper - lower + 1)) + lower;
            int RandomXP = (int) (Math.random() * (XPMax - XPMin + 1)) + XPMin;
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.COOKED_MUTTON, RandomAmountDropped));
            event.setDroppedExp(RandomXP);
        }
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(event.getBlock().getType() == Material.IRON_ORE) {
            Block b = event.getBlock();
            b.setType(Material.AIR);
            b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.IRON_INGOT, 1));
            event.setCancelled(true);
        }
        if(event.getBlock().getType() == Material.GOLD_ORE) {
            Block b = event.getBlock();
            b.setType(Material.AIR);
            b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.GOLD_INGOT, 1));
            event.setCancelled(true);
        }
        if(event.getBlock().getType() == Material.GRAVEL) {
            Block b = event.getBlock();
            b.setType(Material.AIR);
            b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.FLINT, 1));
            event.setCancelled(true);
        }
    }
}

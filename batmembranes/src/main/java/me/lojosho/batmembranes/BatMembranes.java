package me.lojosho.batmembranes;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class BatMembranes extends JavaPlugin implements Listener {

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
    public void BatDeathMembranes(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        int upper = this.getConfig().getInt("maxMembranes");
        int lower = this.getConfig().getInt("minMembranes");
        if (entity.getType() == EntityType.BAT) {
            int Random = (int) (Math.random() * (upper - lower + 1)) + lower;
            event.getDrops().add(new ItemStack(Material.PHANTOM_MEMBRANE, Random));
            }
        }
    }

package me.lojosho.zombieleather;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZombieLeather extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        furnaceFurnace();
    }

    private void furnaceFurnace(){
        int XP = this.getConfig().getInt("XP");
        int Time = this.getConfig().getInt("CookingTime");
        ItemStack result = new ItemStack(Material.LEATHER);
        FurnaceRecipe recipe = new FurnaceRecipe(result, Material.ROTTEN_FLESH);
        recipe.setExperience(XP);
        recipe.setCookingTime(Time);
        getServer().addRecipe(recipe);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

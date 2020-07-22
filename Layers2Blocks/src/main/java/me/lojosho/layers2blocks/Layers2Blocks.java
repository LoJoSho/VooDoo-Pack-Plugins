package me.lojosho.layers2blocks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class Layers2Blocks extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getRecipe();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void getRecipe() {
        ItemStack SnowBlock = new ItemStack(Material.SNOW_BLOCK);

        NamespacedKey key = new NamespacedKey(this, "SNOW_BLOCK1");
        ShapedRecipe recipe = new ShapedRecipe(key, SnowBlock);

        recipe.shape("AAA", "A A", "AAA");
        recipe.setIngredient('A', Material.SNOW);
        Bukkit.addRecipe(recipe);
    }
}

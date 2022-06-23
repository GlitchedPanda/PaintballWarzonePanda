package me.glitchedpanda.paintballwarzonepanda.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PaintballGun {

    public static Material ammoType;
    public static Material material;
    private static ItemStack item;

    public PaintballGun(Material ammoType, Material material) {
        PaintballGun.ammoType = ammoType;
        PaintballGun.material = material;

        item = new ItemStack(material, 1);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Frost Paintball Gun");

        item.setItemMeta(meta);
    }

    public static ItemStack getItem() {
        return item;
    }

}

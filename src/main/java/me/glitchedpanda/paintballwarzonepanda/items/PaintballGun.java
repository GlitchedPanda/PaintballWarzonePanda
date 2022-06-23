package me.glitchedpanda.paintballwarzonepanda.items;

import me.glitchedpanda.paintballwarzonepanda.utils.color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PaintballGun {

    public static Material ammoType;
    public static Material material;
    private static ItemStack item;

    public PaintballGun(Material ammoType, Material material) {
        PaintballGun.ammoType = ammoType;
        PaintballGun.material = material;

        item = new ItemStack(material, 1);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Paintball Gun");
        List lore = new ArrayList();
        lore.add(color.colorise("&c&lRight click &6to shoot&c!"));

        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    public static ItemStack getItem() {
        return item;
    }

}

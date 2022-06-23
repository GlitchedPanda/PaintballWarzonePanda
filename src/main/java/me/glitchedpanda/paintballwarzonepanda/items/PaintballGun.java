package me.glitchedpanda.paintballwarzonepanda.items;

import me.glitchedpanda.paintballwarzonepanda.PaintballWarzonePanda;
import me.glitchedpanda.paintballwarzonepanda.utils.color;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class PaintballGun implements Listener {

    public static EntityType ammoType;
    public static Material material;
    private static ItemStack item;

    public PaintballGun(EntityType ammoType, Material material) {
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

    public PaintballGun() {

    }

    public static void shoot(Player p) {
        Location loc = p.getLocation();
        float height = (float) p.getHeight();
        Bukkit.getLogger().log(Level.INFO, String.valueOf(height));
        loc.setY(loc.getBlockY() + height);

        World w = Bukkit.getWorld("world");
        if (w != null) {
            w.spawnEntity(loc, ammoType, false);
        } else {
            PaintballWarzonePanda.getPlugin(PaintballWarzonePanda.class).getLogger().log(Level.INFO, "NullPointer Exception");
        }
    }

    @EventHandler
    public void onRightCLick(PlayerInteractEvent e) {

        if (e.getItem().getItemMeta() == item.getItemMeta()) {
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                shoot(e.getPlayer());
            } else if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                shoot(e.getPlayer());
            }
        }
    }

    public static ItemStack getItem() {
        return item;
    }

}

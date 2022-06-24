package me.glitchedpanda.paintballwarzonepanda.items;

import me.glitchedpanda.paintballwarzonepanda.PaintballWarzonePanda;
import me.glitchedpanda.paintballwarzonepanda.utils.color;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
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

    public static Class ammoType;
    public static Material material;
    private static ItemStack item;

    public PaintballGun(Class ammoType, Material material) {
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

    public static void shootEnderPearl(Player p) {
        Location loc = p.getLocation();
        float height = (float) p.getHeight();
        loc.setY(loc.getBlockY() + height);

        World w = Bukkit.getWorld("world");
        if (w != null) {
            EnderPearl ammo =  p.getWorld().spawn(loc,EnderPearl.class);
            ammo.setVelocity(p.getLocation().getDirection().multiply(1));
        } else {
            PaintballWarzonePanda.getPlugin(PaintballWarzonePanda.class).getLogger().log(Level.INFO, "NullPointer Exception");
        }
    }

    public static void shootSnowBall(Player p) {
        Location loc = p.getLocation();
        float height = (float) p.getHeight();
        loc.setY(loc.getBlockY() + height);

        World w = Bukkit.getWorld("world");
        if (w != null) {
            Snowball ammo =  p.getWorld().spawn(loc,Snowball.class);
            ammo.setVelocity(p.getLocation().getDirection().multiply(1));
        } else {
            PaintballWarzonePanda.getPlugin(PaintballWarzonePanda.class).getLogger().log(Level.INFO, "NullPointer Exception");
        }
    }

    @EventHandler
    public void onRightCLick(PlayerInteractEvent e) {

        if (e.getPlayer().getInventory().getItemInMainHand().isSimilar(item)) {
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.DIAMOND_HORSE_ARMOR) { shootSnowBall(e.getPlayer()); }
                if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.GOLDEN_HORSE_ARMOR) { shootEnderPearl(e.getPlayer()); }
            } else if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.DIAMOND_HORSE_ARMOR) { shootSnowBall(e.getPlayer()); }
                if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.GOLDEN_HORSE_ARMOR) { shootEnderPearl(e.getPlayer()); }
            }
        }
    }

    public static ItemStack getItem() {
        return item;
    }

}

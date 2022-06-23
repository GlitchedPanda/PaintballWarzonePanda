package me.glitchedpanda.paintballwarzonepanda.paintballguns;

import me.glitchedpanda.paintballwarzonepanda.PaintballWarzonePanda;
import me.glitchedpanda.paintballwarzonepanda.items.PaintballGun;
import me.glitchedpanda.paintballwarzonepanda.utils.color;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.logging.Level;

public class TeamFrost implements CommandExecutor, Listener {

    public static PaintballGun frostGun = new PaintballGun(Material.ENDER_PEARL, Material.DIAMOND_HORSE_ARMOR);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        // Do some changes for the frost gun only
        frostGun.getItem().getItemMeta().setDisplayName(color.colorise("&bFrost PaintballGun"));
        p.getInventory().addItem(frostGun.getItem());

        return true;
    }


    public static void shoot(Player p) {
        World w = Bukkit.getWorld("world");
        assert w != null;
        w.spawnEntity(p.getLocation(), EntityType.ENDER_PEARL, false);
        assert w == null;
        PaintballWarzonePanda.getPlugin(PaintballWarzonePanda.class).getLogger().log(Level.INFO, "NullPointer Exception");
    }

    @EventHandler
    public void onRightCLick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR) {
            shoot(e.getPlayer());
        } else if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            shoot(e.getPlayer());
        }
    }



}

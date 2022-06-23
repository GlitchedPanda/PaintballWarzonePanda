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

    public static PaintballGun frostGun = new PaintballGun(EntityType.ENDER_PEARL, Material.DIAMOND_HORSE_ARMOR);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        // Do some changes for the frost gun only
        frostGun.getItem().getItemMeta().setDisplayName(color.colorise("&bFrost PaintballGun"));
        p.getInventory().addItem(frostGun.getItem());

        return true;
    }
}

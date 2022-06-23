package me.glitchedpanda.paintballwarzonepanda.paintballguns;

import me.glitchedpanda.paintballwarzonepanda.items.PaintballGun;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TeamFrost implements CommandExecutor, Listener {

    public static PaintballGun frostGun = new PaintballGun(EntityType.ENDER_PEARL, Material.DIAMOND_HORSE_ARMOR);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        p.getInventory().addItem(frostGun.getItem());

        return true;
    }
}

package me.glitchedpanda.paintballwarzonepanda;

import me.glitchedpanda.paintballwarzonepanda.items.PaintballGun;
import me.glitchedpanda.paintballwarzonepanda.paintballguns.TeamFrost;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class PaintballWarzonePanda extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().log(Level.INFO, "PaintballWarzone has started");
        getCommand("gftg").setExecutor(new TeamFrost());
        getServer().getPluginManager().registerEvents(new PaintballGun(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().log(Level.INFO, "PaintballWarzone has stopped");
    }
}

package me.glitchedpanda.paintballwarzonepanda;

import me.glitchedpanda.paintballwarzone.painballguns.TeamFrost;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Level;

public final class PaintballWarzonePanda extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().log(Level.INFO, "PaintballWarzone has started");
        getCommand("gftg").setExecutor(new TeamFrost());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().log(Level.INFO, "PaintballWarzone has stopped");
    }
}

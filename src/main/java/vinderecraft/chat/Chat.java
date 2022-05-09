package vinderecraft.chat;

// VindereCraft Imports
import vinderecraft.core.Core;
import vinderecraft.chat.events.PlayerJoin;
import vinderecraft.chat.events.PlayerQuit;

// Bukkit Imports
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Chat extends JavaPlugin {
    // Allows access to 'vinderecraft.core.Core.java'
    public static Core core;

    // Runs when the plugin is enabled
    @Override
    public void onEnable() {
        core = (Core) Bukkit.getServer().getPluginManager().getPlugin("VindereCraft-Core");
        assert core != null;
        if (core.debug) { core.getServer().getConsoleSender().sendMessage("[VC CHAT] Debug messages enabled."); }
        // Registers event handlers.
        getServer().getPluginManager().registerEvents(new PlayerJoin(core), this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(core), this);
        // Sends debug message
        if (core.debug) { getServer().getConsoleSender().sendMessage("[VC CHAT] [DEBUG] Event handlers successfully registered."); }
        core.getServer().getConsoleSender().sendMessage("[VC CHAT] Plugin enabled, linked to VC CORE.");
    }

    // Runs when the plugin is disabled
    @Override
    public void onDisable() {
        assert core != null;
        core.getServer().getConsoleSender().sendMessage("[VC CHAT] Plugin disabled.");
    }
}

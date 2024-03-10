package com.ashkiano.commandblocker;

import org.bukkit.plugin.java.JavaPlugin;

public class CommandBlocker extends JavaPlugin {
    @Override
    public void onEnable() {
        // Načtení konfiguračního souboru
        saveDefaultConfig();

        // Registrace event listeneru
        getServer().getPluginManager().registerEvents(new CommandListener(this), this);

        getLogger().info("CommandBlocker has been enabled!");

        Metrics metrics = new Metrics(this, 21290);
    }

    @Override
    public void onDisable() {
        getLogger().info("CommandBlocker has been disabled!");
    }
}

package com.ashkiano.commandblocker;

import org.bukkit.plugin.java.JavaPlugin;

public class CommandBlocker extends JavaPlugin {
    @Override
    public void onEnable() {
        // Načtení konfiguračního souboru
        saveDefaultConfig();

        // Registrace event listeneru
        getServer().getPluginManager().registerEvents(new CommandListener(this), this);

        this.getLogger().info("Thank you for using the CommandBlocker plugin! If you enjoy using this plugin, please consider making a donation to support the development. You can donate at: https://donate.ashkiano.com");

        Metrics metrics = new Metrics(this, 21290);
    }

    @Override
    public void onDisable() {
        getLogger().info("CommandBlocker has been disabled!");
    }
}

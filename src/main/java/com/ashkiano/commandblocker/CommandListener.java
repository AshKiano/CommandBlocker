package com.ashkiano.commandblocker;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

public class CommandListener implements Listener {
    private CommandBlocker plugin;

    public CommandListener(CommandBlocker plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage().substring(1).split(" ")[0];

        FileConfiguration pluginConfig = plugin.getConfig();
        List<String> blockedCommands = pluginConfig.getStringList("blocked-commands");
        String blockedMessage = pluginConfig.getString("blocked-message", "This command is blocked by the server!")
                .replace("&", "§");

        if (blockedCommands.contains(command)) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(blockedMessage);
        }
    }
}
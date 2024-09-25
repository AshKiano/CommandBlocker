package com.ashkiano.commandblocker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    private CommandBlocker plugin;

    public CommandListener(CommandBlocker plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage().substring(1).split(" ")[0];

        if (!event.getPlayer().hasPermission("blockcommands.bypass") && plugin.getConfig().getStringList("blocked-commands").contains(command)) {
            event.setCancelled(true);
            String blockedMessage = plugin.getConfig().getString("blocked-command-message", "This command is blocked by the server!");
            event.getPlayer().sendMessage(blockedMessage);
        }
    }
}
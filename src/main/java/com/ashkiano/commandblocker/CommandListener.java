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

        if (plugin.getConfig().getStringList("blocked-commands").contains(command)) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("This command is blocked by the server!");
        }
    }
}
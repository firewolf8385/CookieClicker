package net.jadedmc.cookieclicker.listeners;

import net.jadedmc.cookieclicker.CookieClickerPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    private final CookieClickerPlugin plugin;

    public PlayerQuitListener(final CookieClickerPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        plugin.cookiePlayerManager().removePlayer(event.getPlayer());
    }
}
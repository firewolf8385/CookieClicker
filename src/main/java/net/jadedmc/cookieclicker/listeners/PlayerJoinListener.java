package net.jadedmc.cookieclicker.listeners;

import net.jadedmc.cookieclicker.CookieClickerPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private final CookieClickerPlugin plugin;

    public PlayerJoinListener(final CookieClickerPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        plugin.cookiePlayerManager().addPlayer(event.getPlayer());
    }
}
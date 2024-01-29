package net.jadedmc.cookieclicker;

import net.jadedmc.cookieclicker.listeners.PlayerJoinListener;
import net.jadedmc.cookieclicker.listeners.PlayerQuitListener;
import net.jadedmc.cookieclicker.player.CookiePlayerManager;
import net.jadedmc.cookieclicker.utils.GUIListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class CookieClickerPlugin extends JavaPlugin {
    private CookiePlayerManager cookiePlayerManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        cookiePlayerManager = new CookiePlayerManager(this);

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(this), this);
        getServer().getPluginManager().registerEvents(new GUIListeners(), this);
    }

    public CookiePlayerManager cookiePlayerManager() {
        return cookiePlayerManager;
    }
}
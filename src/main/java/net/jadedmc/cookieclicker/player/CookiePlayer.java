package net.jadedmc.cookieclicker.player;

import net.jadedmc.cookieclicker.CookieClickerPlugin;
import org.bukkit.entity.Player;

public class CookiePlayer {
    private final CookieClickerPlugin plugin;
    private final Player player;

    private int cookies = 0;

    public CookiePlayer(final CookieClickerPlugin plugin, final Player player) {
        this.plugin = plugin;
        this.player = player;
    }

    public void addCookie() {
        cookies++;
    }

    public int getCookies() {
        return cookies;
    }
}
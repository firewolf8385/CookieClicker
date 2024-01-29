/*
 * This file is part of CookieClicker, licensed under the MIT License.
 *
 *  Copyright (c) JadedMC
 *  Copyright (c) contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */
package net.jadedmc.cookieclicker.player;

import net.jadedmc.cookieclicker.CookieClickerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * This class manages the Cookie Player object, which stores plugin-specific data about players.
 */
public class CookiePlayerManager {
    private final CookieClickerPlugin plugin;
    private final Map<Player, CookiePlayer> cookiePlayers = new HashMap<>();

    /**
     * Initializes the Cookie Player Manager.
     * @param plugin Instance of the plugin.
     */
    public CookiePlayerManager(final CookieClickerPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Add a player to the player list.
     * @param player Player to add.
     * @return CookiePlayer completable future.
     */
    public CompletableFuture<CookiePlayer> addPlayer(Player player) {
        return CompletableFuture.supplyAsync(() -> {
            CookiePlayer cookiePlayer = new CookiePlayer(plugin, player);
            cookiePlayers.put(player, cookiePlayer);
            return cookiePlayer;
        });
    }

    /**
     * Get the JadedPlayer of a player
     * @param player Player to get JadedPlayer of.
     * @return JadedPlayer of the player.
     */
    public CookiePlayer getPlayer(Player player) {
        return cookiePlayers.get(player);
    }

    /**
     * Get a JadedPlayer from a UUID.
     * @param uuid UUID of the player.
     * @return JadedPlayer of the player.
     */
    public CookiePlayer getPlayer(UUID uuid) {
        return this.getPlayer(Bukkit.getPlayer(uuid));
    }

    /**
     * Remove a player from the player list.
     * @param player Player to remove.
     */
    public void removePlayer(Player player) {
        cookiePlayers.remove(player);
    }
}
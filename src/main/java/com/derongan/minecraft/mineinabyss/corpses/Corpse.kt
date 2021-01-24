package com.derongan.minecraft.mineinabyss.corpses

import com.derongan.minecraft.mineinabyss.world.Layer
import org.bukkit.entity.Item
import org.bukkit.entity.Player
import java.util.*

/**
 * @property player The Bukkit player for this data.
 * @property deathDate The date of the player death event.
 * @property instance Which one of the player's deaths on the given date the corpse derives from.
 * @property variant The type of corpse - may change over time.
 * @property inventorySize The maximum number of items that can be held by the corpse.
 * @property inventory The list of items currently held by the corpse.
 * @property looted Whether the corpse has ever been found by any player.
 * @property lootDate The date of the last time the corpse was looted.
 * @property depth The depth (in m) where the corpse is located.
 * @property layer The layer in which the corpse is located.
 */
interface Corpse {
    val player: Player
    val deathDate: Date?
    val instance: Int?
    var variant: String
    val inventorySize: Int
    val inventory: List<Item>
    val looted: Boolean
    val lootDate: Date?
    val depth: Int?
    val layer: Layer

    /**
     * Spawns a corpse of the player in the world with the inventory filled.
     * Sets player, deathDate, instance
     */
    fun spawnCorpse()

    /**
     * Opens the corpse's inventory as a GUI for the looting player, allowing the player to add or remove items.
     * Also marks the corpse as looted and sets lootDate.
     */
    fun lootCorpse()

    /**
     * Removes the corpse from the world.
     */
    fun despawnCorpse()

    /**
     * Respawns the player at the corpse location.
     */
    fun revivePlayer()
}
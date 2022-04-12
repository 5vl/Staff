package me.fivevl.staff

import me.clip.placeholderapi.PlaceholderAPI
import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.PlayerInventory
import java.util.regex.Pattern

object Utils {
    var instance: Main? = null
    val inStaffmode = HashMap<Player, PlayerInventory>()
    val inVanish = ArrayList<Player>()
    @Suppress("deprecation")
    fun hex(s: String): String {
        var s2 = s
        val pattern = Pattern.compile("#[a-fA-F0-9]{6}")
        var match = pattern.matcher(s)
        while (match.find()) {
            val color = s.substring(match.start(), match.end())
            s2 = s2.replace(color, ChatColor.of(color).toString())
            match = pattern.matcher(s2)
        }
        return ChatColor.translateAlternateColorCodes('&', s2)
    }
    fun getPlaceholders(p: Player?, s: String): String {
        return PlaceholderAPI.setPlaceholders(p, s)
    }
    fun toggleStaffmode(p: Player) {
        if (inStaffmode.containsKey(p)) {
            p.inventory.clear()
            p.inventory.contents = inStaffmode[p]!!.contents
            inStaffmode.remove(p)
        } else {
            inStaffmode[p] = p.inventory
            p.inventory.clear()
            for (i: Int in Config.staffmodeHotbar.keys) {
                var item = ItemStack(Material.AIR)
                when (Config.staffmodeHotbar[i]) {
                    "DISABLE_STAFFMODE" -> item = Items.DISABLE_STAFFMODE.item
                    "FREEZE_WAND" -> item = Items.FREEZE_WAND.item
                    "INVENTORY_WAND" -> item = Items.INVENTORY_WAND.item
                    "KB_STICK" -> item = Items.KB_STICK.item
                    "VANISH_ITEM" -> item = Items.VANISH_ITEM.item
                }
                p.inventory.setItem(i - 1, item)
            }
        }
        p.sendMessage(hex(getPlaceholders(p, Config.toggleStaffmode)))
    }
    fun toggleVanish(p: Player) {
        if (inVanish.contains(p)) {
            for (ps in Bukkit.getOnlinePlayers()) {
                ps.showPlayer(instance!!, p)
            }
            inVanish.remove(p)
        } else {
            for (ps in Bukkit.getOnlinePlayers()) {
                ps.hidePlayer(instance!!, p)
            }
            inVanish.add(p)
        }
        p.sendMessage(hex(getPlaceholders(p, Config.toggleVanish)))
    }

    fun getConfig(): FileConfiguration {
        return instance!!.config
    }
}
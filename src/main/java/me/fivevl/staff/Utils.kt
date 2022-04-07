package me.fivevl.staff

import me.clip.placeholderapi.PlaceholderAPI
import net.md_5.bungee.api.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.PlayerInventory
import java.util.regex.Pattern

object Utils {
    private val inStaffmode = HashMap<Player, PlayerInventory>()
    @Suppress("deprecation")
    fun hex(s: String): String {
        var s2 = s
        val pattern = Pattern.compile("#[a-fA-F0-9]{6}")
        var match = pattern.matcher(s)
        while (match.find()) {
            val color = s.substring(match.start(), match.end())
            s2 = s2.replace(color, ChatColor.of(color).toString() + "")
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
                    "DISABLE_STAFFMODE" -> item = ItemStack(Material.AIR)
                    "FREEZE_WAND" -> item = ItemStack(Material.AIR)
                    "INVENTORY_WAND" -> item = ItemStack(Material.AIR)
                    "KB_STICK" -> item = ItemStack(Material.AIR)
                    "VANISH_ITEM" -> item = ItemStack(Material.AIR)
                }
                p.inventory.setItem(i - 1, item)
            }
        }
        p.sendMessage(hex(getPlaceholders(p, Config.toggleStaffmode!!)))
    }
}
package me.fivevl.staff

import me.clip.placeholderapi.PlaceholderAPI
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

object Utils {
    var instance: Main? = null
    val inStaffmode = HashMap<Player, Inventory>()
    val inVanish = ArrayList<Player>()
    val inOtherInv = ArrayList<Player>()
    val frozen = ArrayList<Player>()
    @Suppress("deprecation")
    fun mm(s: String): Component {
        return MiniMessage.miniMessage().deserialize(s)
    }
    fun color(s: String): String {
        return ChatColor.translateAlternateColorCodes('&', s)
    }
    fun getPlaceholders(p: Player?, s: String): String {
        return PlaceholderAPI.setPlaceholders(p, s)
    }
    fun toggleStaffmode(p: Player) {
        if (inStaffmode.containsKey(p)) {
            p.inventory.clear()
            p.inventory.contents = inStaffmode[p]!!.contents
            inStaffmode.remove(p)
            p.sendMessage(mm(getPlaceholders(p, Config.toggleStaffmodeOff)))
        } else {
            inStaffmode[p] = p.inventory
            p.inventory.clear()
            for (i: Int in Config.staffmodeHotbar.keys) {
                var item = ItemStack(Material.AIR)
                when (Config.staffmodeHotbar[i]) {
                    "DISABLE_STAFFMODE" -> if (p.hasPermission("staff.staffmode")) item = Items.DISABLE_STAFFMODE.item
                    "FREEZE_WAND" -> if (p.hasPermission("staff.freeze.wand")) item = Items.FREEZE_WAND.item
                    "INVENTORY_WAND" -> if (p.hasPermission("staff.invsee.wand")) item = Items.INVENTORY_WAND.item
                    "KB_STICK" -> if (p.hasPermission("staff.kbstick")) item = Items.KB_STICK.item
                    "VANISH_ITEM" -> if (p.hasPermission("staff.vanish.item")) item = Items.VANISH_ITEM.item
                }
                p.inventory.setItem(i - 1, item)
            }
            p.sendMessage(mm(getPlaceholders(p, Config.toggleStaffmodeOn)))
        }
    }
    fun toggleVanish(p: Player) {
        if (inVanish.contains(p)) {
            for (ps in Bukkit.getOnlinePlayers()) {
                ps.showPlayer(instance!!, p)
            }
            inVanish.remove(p)
            p.sendMessage(mm(getPlaceholders(p, Config.toggleVanishOff)))
        } else {
            for (ps in Bukkit.getOnlinePlayers()) {
                ps.hidePlayer(instance!!, p)
            }
            inVanish.add(p)
            p.sendMessage(mm(getPlaceholders(p, Config.toggleVanishOn)))
        }
    }
    fun toggleFreeze(p: Player) {
        if (frozen.contains(p)) {
            p.sendMessage(mm(getPlaceholders(p, Config.toggleFreezeOff)))
            frozen.remove(p)
        } else {
            p.sendMessage(mm(getPlaceholders(p, Config.toggleFreezeOn)))
            frozen.add(p)
        }
    }
}
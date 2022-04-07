package me.fivevl.staff


import me.clip.placeholderapi.PlaceholderAPI
import net.md_5.bungee.api.ChatColor
import org.bukkit.entity.Player
import java.util.regex.Pattern

object Utils {
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
}
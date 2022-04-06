package me.fivevl.staff


import net.md_5.bungee.api.ChatColor
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
}
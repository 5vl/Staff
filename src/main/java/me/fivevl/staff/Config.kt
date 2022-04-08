package me.fivevl.staff

import org.bukkit.configuration.file.FileConfiguration

object Config {
    var config: FileConfiguration? = null
    val mustBePlayer = config?.getString("must-be-player")
    val noPermission = config?.getString("no-permission")
    val toggleStaffmode = config?.getString("toggle-staffmode")
    val staffmodeHotbar = HashMap<Int, String>().apply {
        config?.getConfigurationSection("staffmode-hotbar")?.getKeys(false)?.forEach {
            put(it.toInt(), config?.getString("staffmode-hotbar.$it")!!)
        }
    }
    val toggleVanish = config?.getString("toggle-vanish")
}
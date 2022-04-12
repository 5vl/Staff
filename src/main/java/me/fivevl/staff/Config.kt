package me.fivevl.staff

import org.bukkit.configuration.file.FileConfiguration

object Config {
    private fun getConfig(): FileConfiguration {
        return Utils.getConfig()
    }
    val mustBePlayer = getConfig().getString("must-be-player")!!
    val noPermission = getConfig().getString("no-permission")!!
    val toggleStaffmode = getConfig().getString("toggle-staffmode")!!
    val toggleVanish = getConfig().getString("toggle-vanish")!!
    val staffmodeHotbar = HashMap<Int, String>().apply {
        getConfig().getConfigurationSection("staffmode-hotbar")?.getKeys(false)?.forEach {
            put(it.toInt(), getConfig().getString("staffmode-hotbar.$it")!!)
        }
    }
    val disableStaffmodeItem = getConfig().getString("disable-staffmode-item")!!
}
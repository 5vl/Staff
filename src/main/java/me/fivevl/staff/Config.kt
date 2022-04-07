package me.fivevl.staff

import org.bukkit.configuration.file.FileConfiguration

object Config {
    var config: FileConfiguration? = null
    val mustBePlayer = config?.getString("must-be-player")
    val noPermission = config?.getString("no-permission")
}
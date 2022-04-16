package me.fivevl.staff

import org.bukkit.configuration.file.FileConfiguration

object Config {
    private fun getConfig(): FileConfiguration {
        return Utils.getConfig()
    }
    val mustBePlayer = getConfig().getString("must-be-player")!!
    val noPermission = getConfig().getString("no-permission")!!
    val toggleStaffmodeOn = getConfig().getString("toggle-staffmode-on")!!
    val toggleStaffmodeOff = getConfig().getString("toggle-staffmode-off")!!
    val toggleVanishOn = getConfig().getString("toggle-vanish-on")!!
    val toggleVanishOff = getConfig().getString("toggle-vanish-off")!!
    val staffmodeHotbar = HashMap<Int, String>().apply {
        getConfig().getConfigurationSection("staffmode-hotbar")?.getKeys(false)?.forEach {
            put(it.toInt(), getConfig().getString("staffmode-hotbar.$it")!!)
        }
    }
    val disableStaffmodeItem = getConfig().getString("items.DISABLE_STAFFMODE")!!
    val freezeWandItem = getConfig().getString("items.FREEZE_WAND")!!
    val inventoryWandItem = getConfig().getString("items.INVENTORY_WAND")!!
    val kbStickItem = getConfig().getString("items.KB_STICK")!!
    val vanishItem = getConfig().getString("items.VANISH_ITEM")!!
}
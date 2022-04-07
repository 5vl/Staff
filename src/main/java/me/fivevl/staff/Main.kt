package me.fivevl.staff

import me.fivevl.staff.commands.StaffModeCommand
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        saveDefaultConfig()
        Config.config = config
        getCommand("staffmode")!!.setExecutor(StaffModeCommand())
        logger.info("Staff plugin enabled.")
    }

    override fun onDisable() {
        logger.info("Staff plugin disabled.")
    }


    /*
        FEATURES:
            DONE:
                - PlaceholderAPI support
            NOT DONE:
                - Staff mode (Invisibility/vanish, fly, items)
                - Freeze (Command and freeze wand in staff mode)
                - Open inventory (Command and wand in staff mode) with permission for being able to edit it
                - Knockback Stick (Extra, useful to check if the player has no kb)
    */
}

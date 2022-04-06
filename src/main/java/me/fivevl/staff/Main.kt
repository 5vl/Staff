package me.fivevl.staff

import me.fivevl.staff.commands.StaffModeCommand
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        logger.info("Staff plugin enabled.")
        getCommand("staffmode")!!.setExecutor(StaffModeCommand())
    }

    override fun onDisable() {
        logger.info("Staff plugin disabled.")
    }


    /*
        FEATURES:
            DONE:

            NOT DONE:
                - Staff mode (Invisibility/vanish, fly, items)
                - Freeze (Command and freeze wand in staff mode)
                - Open inventory (Command and wand in staff mode) with permission for being able to edit it
                - Knockback Stick (Extra, useful to check if the player has no kb)
                - PlaceholderAPI support
    */
}

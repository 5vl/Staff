package me.fivevl.staff

import me.fivevl.staff.commands.StaffModeCommand
import me.fivevl.staff.commands.VanishCommand
import me.fivevl.staff.listeners.JoinListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        Utils.instance = this

        saveDefaultConfig()

        getCommand("staffmode")!!.setExecutor(StaffModeCommand())
        getCommand("vanish")!!.setExecutor(VanishCommand())

        Bukkit.getPluginManager().registerEvents(JoinListener(), this)
        logger.info("Staff plugin enabled.")
    }

    override fun onDisable() {
        logger.info("Staff plugin disabled.")
    }


    /*
        FEATURES:
            DONE:
                - PlaceholderAPI support
                - Config
            NOT DONE:
                - Staff mode (Invisibility/vanish, fly, items)
                - Freeze (Command and freeze wand in staff mode)
                - Open inventory (Command and wand in staff mode) with permission for being able to edit it
                - Knockback Stick (Extra, useful to check if the player has no kb)
    */
}

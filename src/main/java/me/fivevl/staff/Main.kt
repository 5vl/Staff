package me.fivevl.staff

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        logger.info("Staff plugin enabled.")
    }

    override fun onDisable() {
        logger.info("Staff plugin disabled.")
    }


    /*
        FEATURES:
            DONE:

            NOT DONE:
                - Staff mode
                - Freeze
                - Inventory Lookup (Open inventory)
                - Teleport to online players
                - Invisibility
                - Knockback Stick (Extra, useful to check if the player has no kb)
                - PlaceholderAPI
                - Toggle on/off each individual items, (Extra, per-player settings would be sweet)
    */
}

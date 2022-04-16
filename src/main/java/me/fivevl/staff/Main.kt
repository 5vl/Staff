package me.fivevl.staff

import me.fivevl.staff.commands.InvseeCommand
import me.fivevl.staff.commands.StaffmodeCommand
import me.fivevl.staff.commands.VanishCommand
import me.fivevl.staff.listeners.JoinListener
import me.fivevl.staff.listeners.StaffmodeListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        Utils.instance = this

        saveDefaultConfig()

        getCommand("staffmode")!!.setExecutor(StaffmodeCommand())
        getCommand("vanish")!!.setExecutor(VanishCommand())
        getCommand("invsee")!!.setExecutor(InvseeCommand())

        Bukkit.getPluginManager().registerEvents(JoinListener(), this)
        Bukkit.getPluginManager().registerEvents(StaffmodeListener(), this)
        logger.info("Staff plugin enabled.")
    }

    override fun onDisable() {
        logger.info("Staff plugin disabled.")
    }
}

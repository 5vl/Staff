package me.fivevl.staff.commands

import me.fivevl.staff.Config
import me.fivevl.staff.Utils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class VanishCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(Utils.hex(Utils.getPlaceholders(null, Config.mustBePlayer)))
            return true
        }
        val p = sender.player!!
        if (!p.hasPermission("staff.vanish")) {
            p.sendMessage(Utils.hex(Utils.getPlaceholders(p, Config.noPermission)))
            return true
        }
        Utils.toggleVanish(p)
        return true
    }

}
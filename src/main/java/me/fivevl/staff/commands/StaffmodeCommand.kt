package me.fivevl.staff.commands

import me.fivevl.staff.Config
import me.fivevl.staff.Utils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class StaffmodeCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(Utils.mm(Utils.getPlaceholders(null, Config.mustBePlayer)))
            return true
        }
        val p = sender.player!!
        if (!p.hasPermission("staff.staffmode")) {
            p.sendMessage(Utils.mm(Utils.getPlaceholders(p, Config.noPermission)))
            return true
        }
        Utils.toggleStaffmode(p)
        return true
    }
}
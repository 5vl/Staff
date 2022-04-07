package me.fivevl.staff.commands

import me.fivevl.staff.Utils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class StaffModeCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(Utils.hex(Utils.getPlaceholders(null, "&cYou must be a player to use this command!")))
            return true
        }
        val p = sender.player
        return true
    }
}
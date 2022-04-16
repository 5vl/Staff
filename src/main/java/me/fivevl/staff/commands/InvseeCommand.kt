package me.fivevl.staff.commands

import me.fivevl.staff.Config
import me.fivevl.staff.Utils
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class InvseeCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(Utils.mm(Utils.getPlaceholders(null, Config.mustBePlayer)))
            return true
        }
        val p = sender.player!!
        if (!p.hasPermission("staff.invsee")) {
            p.sendMessage(Utils.mm(Utils.getPlaceholders(p, Config.noPermission)))
            return true
        }
        if (args.size != 1) {
            p.sendMessage(Utils.mm("<red><hover:show_text:Click me to insert command!><click:suggest_command:/invsee >Usage: /invsee <player></click></hover></red>"))
            return true
        }
        val target = Bukkit.getPlayer(args[0])
        if (target == null) {
            p.sendMessage(Utils.mm(Utils.getPlaceholders(p, Config.playerNotFound)))
            return true
        }
        p.openInventory(target.inventory)
        Utils.inOtherInv.add(p)
        return true
    }
}
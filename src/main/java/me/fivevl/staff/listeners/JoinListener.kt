package me.fivevl.staff.listeners

import me.fivevl.staff.Utils
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class JoinListener : Listener {
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val p = e.player
        for (ps in Utils.inVanish) {
            p.hidePlayer(Utils.instance!!, ps)
        }
    }
}

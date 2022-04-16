package me.fivevl.staff.listeners

import me.fivevl.staff.Utils
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class JoinListener : Listener {
    @Suppress("deprecation")
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val p = e.player
        for (ps in Utils.inVanish) {
            p.hidePlayer(Utils.instance!!, ps)
        }
    }
    @Suppress("deprecation")
    @EventHandler
    fun onLeave (e: PlayerQuitEvent) {
        val p = e.player
        if (Utils.inVanish.contains(p)) {
            Utils.inVanish.remove(p)
        }
        if (Utils.inStaffmode.contains(p)) {
            p.inventory.clear()
            p.inventory.contents = Utils.inStaffmode[p]!!.contents
            Utils.inStaffmode.remove(p)
        }
    }
}

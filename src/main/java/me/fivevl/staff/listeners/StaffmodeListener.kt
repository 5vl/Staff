package me.fivevl.staff.listeners

import me.fivevl.staff.Config
import me.fivevl.staff.Items
import me.fivevl.staff.Utils
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.player.PlayerInteractAtEntityEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerMoveEvent


class StaffmodeListener : Listener {
    @EventHandler
    fun onDrop(e: PlayerDropItemEvent) {
        if (Utils.inStaffmode.containsKey(e.player)) {
            e.isCancelled = true
        }
    }
    @EventHandler
    fun onInvClick(e: InventoryClickEvent) {
        if (Utils.inOtherInv.contains(e.whoClicked) && !e.whoClicked.hasPermission("staff.invsee.move")) {
            e.isCancelled = true
        }
        if (!Utils.inStaffmode.containsKey(e.whoClicked)) {return}
        if (!e.whoClicked.hasPermission("staff.inventory")) {
            e.isCancelled = true
        }
    }
    @EventHandler
    fun onInvClose(e: InventoryCloseEvent) {
        Utils.inOtherInv.remove(e.player)
    }
    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        if (!Utils.inStaffmode.containsKey(e.player)) {
            return
        }
        val p = e.player
        if (p.inventory.itemInMainHand.equals(Items.DISABLE_STAFFMODE)) {
            Utils.toggleStaffmode(p)
        }
        if (p.inventory.itemInMainHand.equals(Items.VANISH_ITEM)) {
            Utils.toggleVanish(p)
        }
    }
    @EventHandler
    fun onEntityInteract(e: PlayerInteractAtEntityEvent) {
        if (!Utils.inStaffmode.containsKey(e.player)) {
            return
        }
        if (e.rightClicked !is Player) return
        val p = e.player
        val target = e.rightClicked as Player
        if (p.inventory.itemInMainHand.equals(Items.INVENTORY_WAND)) {
            p.openInventory(target.inventory)
            Utils.inOtherInv.add(p)
        }
        if (p.inventory.itemInMainHand.equals(Items.FREEZE_WAND)) {
            Utils.toggleFreeze(target)
        }
    }
    @EventHandler
    fun onMove(e: PlayerMoveEvent) {
        if (Utils.frozen.contains(e.player)) {
            e.isCancelled = true
            e.player.sendMessage(Utils.mm(Utils.getPlaceholders(e.player, Config.currentlyFrozen)))
        }
    }
}
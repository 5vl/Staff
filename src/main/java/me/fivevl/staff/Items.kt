package me.fivevl.staff

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

enum class Items(val item: ItemStack) {
    DISABLE_STAFFMODE(getStaffmodeItem()),
    FREEZE_WAND(ItemStack(Material.STICK)),
    INVENTORY_WAND(ItemStack(Material.STICK)),
    KB_STICK(ItemStack(Material.STICK)),
    VANISH_ITEM(ItemStack(Material.STICK)),
}
@Suppress("deprecation")
private fun getStaffmodeItem(): ItemStack {
    val item = ItemStack(Material.LIME_DYE)
    val meta = item.itemMeta
    meta.setDisplayName(Utils.hex(Utils.getPlaceholders(null, Config.disableStaffmodeItem)))
    return item
}
package me.fivevl.staff

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

enum class Items(val item: ItemStack) {
    DISABLE_STAFFMODE(getStaffmodeItem()),
    FREEZE_WAND(getFreezeWandItem()),
    INVENTORY_WAND(getInventoryWandItem()),
    KB_STICK(getKbStickItem()),
    VANISH_ITEM(getVanishItem())
}
@Suppress("deprecation")
private fun getStaffmodeItem(): ItemStack {
    val item = ItemStack(Material.LIME_DYE)
    val meta = item.itemMeta
    meta.setDisplayName(Utils.color(Utils.getPlaceholders(null, Config.disableStaffmodeItem)))
    item.itemMeta = meta
    return item
}
@Suppress("deprecation")
private fun getFreezeWandItem(): ItemStack {
    val item = ItemStack(Material.CHAIN)
    val meta = item.itemMeta
    meta.setDisplayName(Utils.color(Utils.getPlaceholders(null, Config.freezeWandItem)))
    item.itemMeta = meta
    return item
}
@Suppress("deprecation")
private fun getInventoryWandItem(): ItemStack {
    val item = ItemStack(Material.BLAZE_ROD)
    val meta = item.itemMeta
    meta.setDisplayName(Utils.color(Utils.getPlaceholders(null, Config.inventoryWandItem)))
    item.itemMeta = meta
    return item
}
@Suppress("deprecation")
private fun getKbStickItem(): ItemStack {
    val item = ItemStack(Material.STICK)
    val meta = item.itemMeta
    meta.setDisplayName(Utils.color(Utils.getPlaceholders(null, Config.kbStickItem)))
    item.itemMeta = meta
    return item
}
@Suppress("deprecation")
private fun getVanishItem(): ItemStack {
    val item = ItemStack(Material.BARRIER)
    val meta = item.itemMeta
    meta.setDisplayName(Utils.color(Utils.getPlaceholders(null, Config.vanishItem)))
    item.itemMeta = meta
    return item
}
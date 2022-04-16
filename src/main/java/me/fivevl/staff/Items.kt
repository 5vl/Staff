package me.fivevl.staff

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
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
    val item = ItemStack(Material.valueOf(Config.disableStaffmodeItem))
    val meta = item.itemMeta
    meta.setDisplayName(Utils.color(Utils.getPlaceholders(null, Config.disableStaffmodeItemName)))
    item.itemMeta = meta
    return item
}
@Suppress("deprecation")
private fun getFreezeWandItem(): ItemStack {
    val item = ItemStack(Material.valueOf(Config.freezeWandItem))
    val meta = item.itemMeta
    meta.setDisplayName(Utils.color(Utils.getPlaceholders(null, Config.freezeWandItemName)))
    item.itemMeta = meta
    return item
}
@Suppress("deprecation")
private fun getInventoryWandItem(): ItemStack {
    val item = ItemStack(Material.valueOf(Config.inventoryWandItem))
    val meta = item.itemMeta
    meta.setDisplayName(Utils.color(Utils.getPlaceholders(null, Config.inventoryWandItemName)))
    item.itemMeta = meta
    return item
}
@Suppress("deprecation")
private fun getKbStickItem(): ItemStack {
    val item = ItemStack(Material.valueOf(Config.kbStickItem))
    val meta = item.itemMeta
    meta.setDisplayName(Utils.color(Utils.getPlaceholders(null, Config.kbStickItemName)))
    meta.addEnchant(Enchantment.KNOCKBACK, 10, true)
    item.itemMeta = meta
    return item
}
@Suppress("deprecation")
private fun getVanishItem(): ItemStack {
    val item = ItemStack(Material.valueOf(Config.vanishItem))
    val meta = item.itemMeta
    meta.setDisplayName(Utils.color(Utils.getPlaceholders(null, Config.vanishItemName)))
    item.itemMeta = meta
    return item
}
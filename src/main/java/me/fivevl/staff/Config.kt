package me.fivevl.staff

object Config {
    val mustBePlayer = Utils.instance!!.config.getString("must-be-player")!!
    val noPermission = Utils.instance!!.config.getString("no-permission")!!
    val toggleStaffmodeOn = Utils.instance!!.config.getString("toggle-staffmode-on")!!
    val toggleStaffmodeOff = Utils.instance!!.config.getString("toggle-staffmode-off")!!
    val toggleVanishOn = Utils.instance!!.config.getString("toggle-vanish-on")!!
    val toggleVanishOff = Utils.instance!!.config.getString("toggle-vanish-off")!!
    val staffmodeHotbar = HashMap<Int, String>().apply {
        Utils.instance!!.config.getConfigurationSection("staffmode-hotbar")?.getKeys(false)?.forEach {
            put(it.toInt(), Utils.instance!!.config.getString("staffmode-hotbar.$it")!!)
        }
    }
    val disableStaffmodeItemName = Utils.instance!!.config.getString("items.DISABLE_STAFFMODE.name")!!
    val freezeWandItemName = Utils.instance!!.config.getString("items.FREEZE_WAND.name")!!
    val inventoryWandItemName = Utils.instance!!.config.getString("items.INVENTORY_WAND.name")!!
    val kbStickItemName = Utils.instance!!.config.getString("items.KB_STICK.name")!!
    val vanishItemName = Utils.instance!!.config.getString("items.VANISH_ITEM.name")!!
    val disableStaffmodeItem = Utils.instance!!.config.getString("items.DISABLE_STAFFMODE.item")!!
    val freezeWandItem = Utils.instance!!.config.getString("items.FREEZE_WAND.item")!!
    val inventoryWandItem = Utils.instance!!.config.getString("items.INVENTORY_WAND.item")!!
    val kbStickItem = Utils.instance!!.config.getString("items.KB_STICK.item")!!
    val vanishItem = Utils.instance!!.config.getString("items.VANISH_ITEM.item")!!
}
package net.st915.hydrogenmod.item

import net.minecraft.item.Item
import net.st915.hydrogenmod.itemgroup.HydrogenModGroup

object HydrogenItem {

  val properties: Item.Properties =
    new Item.Properties()
      .group(HydrogenModGroup.instance)

  val instance: Item = new HydrogenItem

}

final class HydrogenItem extends Item(HydrogenItem.properties)

package net.st915.hydrogenmod.instances

import net.minecraft.item.Item
import net.st915.hydrogenmod.itemgroup.HydrogenModGroup

trait ItemPropertyInstances {

  implicit val defaultItemProperties: Item.Properties =
    new Item.Properties().group(HydrogenModGroup.instance)

}

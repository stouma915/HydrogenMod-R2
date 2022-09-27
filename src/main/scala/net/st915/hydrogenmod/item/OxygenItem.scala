package net.st915.hydrogenmod.item

import net.minecraft.item.Item
import net.st915.hydrogenmod.implicits.defaultItemProperties
import net.st915.hydrogenmod.item.generic.HydrogenModItem

object OxygenItem {

  val instance: Item = new OxygenItem

}

final class OxygenItem extends HydrogenModItem

package net.st915.hydrogenmod.item

import net.minecraft.item.Item
import net.st915.hydrogenmod.implicits.defaultItemProperties
import net.st915.hydrogenmod.item.generic.HydrogenModItem

object HydrogenPeroxideItem {

  val instance: Item = new HydrogenPeroxideItem

}

final class HydrogenPeroxideItem extends HydrogenModItem

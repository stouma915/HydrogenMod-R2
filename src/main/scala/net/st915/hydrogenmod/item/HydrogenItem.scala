package net.st915.hydrogenmod.item

import net.minecraft.item.Item
import net.st915.hydrogenmod.implicits.defaultItemProperties

object HydrogenItem {

  val instance: Item = new HydrogenItem

}

final class HydrogenItem extends HydrogenModItem

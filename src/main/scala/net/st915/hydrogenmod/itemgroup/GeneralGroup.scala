package net.st915.hydrogenmod.itemgroup

import net.minecraft.item.{Item, ItemGroup}
import net.st915.hydrogenmod.item._
import net.st915.hydrogenmod.itemgroup.generic.HydrogenModGroup

object GeneralGroup {

  val instance: ItemGroup = new GeneralGroup

}

final class GeneralGroup extends HydrogenModGroup("general") {

  override def makeIcon: Item = HydrogenItem.instance

  override def itemList: List[Item] = List(
    HydrogenItem.instance,
    OxygenItem.instance,
    HydrogenPeroxideItem.instance
  )

}

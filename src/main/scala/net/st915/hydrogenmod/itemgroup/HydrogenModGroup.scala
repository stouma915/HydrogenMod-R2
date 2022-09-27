package net.st915.hydrogenmod.itemgroup

import net.minecraft.item.{Item, ItemGroup, ItemStack}
import net.minecraft.util.NonNullList
import net.st915.hydrogenmod.HydrogenMod
import net.st915.hydrogenmod.implicits._
import net.st915.hydrogenmod.item._

object HydrogenModGroup {

  lazy val items: List[Item] = List(
    HydrogenItem.instance,
    OxygenItem.instance
  )

  val instance: ItemGroup = new HydrogenModGroup

}

final class HydrogenModGroup extends ItemGroup(HydrogenMod.ModId) {

  override def createIcon(): ItemStack = HydrogenItem.instance.makeStack

  override def fill(items: NonNullList[ItemStack]): Unit = {
    items.clear()

    HydrogenModGroup.items.map(_.makeStack).foreach(items.add)
  }

}

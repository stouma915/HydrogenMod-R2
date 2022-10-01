package net.st915.hydrogenmod.itemgroup.generic

import net.minecraft.item.{Item, ItemGroup, ItemStack}
import net.minecraft.util.NonNullList
import net.st915.hydrogenmod.HydrogenMod
import net.st915.hydrogenmod.implicits._

abstract class HydrogenModGroup(name: String)
    extends ItemGroup(s"${HydrogenMod.ModId}_$name") {

  def makeIcon: Item

  def itemList: List[Item]

  override def createIcon(): ItemStack = makeIcon.makeStack

  override def fill(items: NonNullList[ItemStack]): Unit = {
    items.clear()

    itemList.map(_.makeStack).foreach(items.add)
  }

}

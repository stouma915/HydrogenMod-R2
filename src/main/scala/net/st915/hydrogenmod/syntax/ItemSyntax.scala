package net.st915.hydrogenmod.syntax

import net.minecraft.item.{Item, ItemStack}

trait ItemSyntax {

  implicit class ItemOps(item: Item) {

    def makeStack: ItemStack = new ItemStack(item)

  }

}

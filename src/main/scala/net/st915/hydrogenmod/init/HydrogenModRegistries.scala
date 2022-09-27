package net.st915.hydrogenmod.init

import net.minecraftforge.registries.{DeferredRegister, ForgeRegistries}
import net.st915.hydrogenmod.HydrogenMod

private[hydrogenmod] object HydrogenModRegistries {

  final val ItemRegistry =
    DeferredRegister.create(ForgeRegistries.ITEMS, HydrogenMod.ModId)

  def getRegistries: Set[DeferredRegister[_]] = Set(
    ItemRegistry
  )

}

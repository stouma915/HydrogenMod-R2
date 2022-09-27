package net.st915.hydrogenmod

import cats.effect.IO
import net.minecraft.item.Item
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.st915.hydrogenmod.init.HydrogenModRegistries
import net.st915.hydrogenmod.item._

object HydrogenMod {

  final val ModId = "hydrogenmod"

}

@Mod(HydrogenMod.ModId)
final class HydrogenMod {

  import cats.effect.unsafe.implicits.global

  private val eventBus = FMLJavaModLoadingContext.get.getModEventBus

  // region startup tasks

  private val registerItems = IO {
    Map(
      "hydrogen" -> HydrogenItem.instance,
      "oxygen" -> OxygenItem.instance,
      "hydrogen_peroxide" -> HydrogenPeroxideItem.instance
    ).foreach { case (name: String, item: Item) =>
      HydrogenModRegistries.ItemRegistry.register(name, () => item)
    }
  }

  private val registerEventBus = IO {
    HydrogenModRegistries.getRegistries.foreach(_.register(eventBus))
  }

  private val startMod = for {
    _ <- registerItems
    _ <- registerEventBus
  } yield ()

  // endregion

  startMod.unsafeRunSync()

}

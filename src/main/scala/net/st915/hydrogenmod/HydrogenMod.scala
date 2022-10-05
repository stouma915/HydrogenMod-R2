package net.st915.hydrogenmod

import cats.effect.IO
import net.minecraft.item.Item
import net.minecraft.potion.Potion
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.st915.hydrogenmod.init.HydrogenModRegistries
import net.st915.hydrogenmod.item._
import net.st915.hydrogenmod.potion._

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
    ).foreach { case (id: String, item: Item) =>
      HydrogenModRegistries.ItemRegistry.register(id, () => item)
    }
  }

  private val registerPotions = IO {
    Map(
      "hydrogen_water" -> HydrogenWaterPotion.instance
    ).foreach { case (id: String, potion: Potion) =>
      HydrogenModRegistries.PotionRegistry.register(id, () => potion)
    }
  }

  private val registerEventBus = IO {
    HydrogenModRegistries.getRegistries.foreach(_.register(eventBus))
  }

  private val startMod = for {
    _ <- registerItems
    _ <- registerPotions
    _ <- registerEventBus
  } yield ()

  // endregion

  startMod.unsafeRunSync()

}

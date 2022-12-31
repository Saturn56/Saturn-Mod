package io.github.saturn56.mod.mixin;

import io.github.saturn56.mod.ExampleMod;
import io.github.saturn56.mod.hacks.AutoFishing;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(FishingBobberEntity.class)
public class FishingBobberEntityMixin {

    @Shadow private boolean caughtFish;

    @Inject(at = @At("TAIL"), method = "onTrackedDataSet")
    public void onTrackedDataSet(TrackedData<?> data, CallbackInfo ci){
        MinecraftClient client = MinecraftClient.getInstance();

        //ExampleMod.LOGGER.info("tick: "+caughtFish+" | "+waitCountdown);

        if(caughtFish && ExampleMod.getInstance().Toggle_AutoFish){
            client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
            AutoFishing.setRecastRod(20);
        }
    }

    /*
    @Inject(at = @At("TAIL"), method = "tick")
    public void tick(CallbackInfo ci){
        MinecraftClient client = MinecraftClient.getInstance();
        if(ExampleMod.getInstance().recastRod>0) {
            ExampleMod.getInstance().recastRod--;
        }
        if(ExampleMod.getInstance().recastRod==0 && ExampleMod.getInstance().Toggle_AutoFish){
            client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
            ExampleMod.getInstance().recastRod=-1;
        }
    }*/
}

package io.github.saturn56.mod.mixin;

import io.github.saturn56.mod.SaturnMod;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class clientPlayerNetworkHandler {
    @Inject(method = "onPlaySound", at = @At("HEAD"))
    public void onPlaySound(PlaySoundS2CPacket packet, CallbackInfo ci){
        if (!SaturnMod.getInstance().Toggle_SoundPacket){
            return;
        }
        SaturnMod.LOGGER.info(packet.getClass().getName());
    }
}

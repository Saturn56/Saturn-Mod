package io.github.saturn56.mod.mixin;

import io.github.saturn56.mod.ExampleMod;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {
    @Inject(at = @At("TAIL"), method = "send(Lnet/minecraft/network/Packet;)V", cancellable = true)
    private void send(Packet<?> packet, CallbackInfo ci) {
        if (packet instanceof PlayerMoveC2SPacket) {
            return;
        }

        if (!ExampleMod.getInstance().Toggle_ClientConnectionPacket){
            return;
        }

        ExampleMod.LOGGER.info(packet.getClass().getName());
    }

}
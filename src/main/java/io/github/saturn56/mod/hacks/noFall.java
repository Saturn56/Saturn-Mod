package io.github.saturn56.mod.hacks;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.text.Text;

public class noFall {
    public static Boolean Toggle = false;

    public static void T_NoFall(ButtonWidget b){
        Toggle = !Toggle;
        b.setMessage(Text.literal("No-Fall " + G_NoFall()));
    }
    public static String G_NoFall(){
        if(Toggle){
            return "enabled";
        }else {
            return "disabled";
        }
    }

    public static void tick(){
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;
        if(client.player == null){
            return;
        }
        float fallDistance = player.fallDistance;
        if (!Toggle){
            return;
        }
        if(fallDistance <= (player.isFallFlying() ? 1 : 2)){
            return;
        }
        if(player.isFallFlying() && player.isSneaking() && !isFallingFastEnoughToCauseDamage(player)){
            return;
        }
        player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true));
    }
    private static boolean isFallingFastEnoughToCauseDamage(ClientPlayerEntity player)
    {
        return player.getVelocity().y < -0.5;
    }
}


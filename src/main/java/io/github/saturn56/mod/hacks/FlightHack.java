package io.github.saturn56.mod.hacks;

import io.github.saturn56.mod.SaturnMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.AlwaysSelectedEntryListWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class FlightHack {
    private static boolean sneakWasPressed;
    private static boolean jumpWasPressed;
    private static int tickCounter = 0;
    static double antiKickDistance = -0.04;

    public static Boolean Toggle = false;
    private static int antiKickInterval = 60;
    public static MinecraftClient MC = MinecraftClient.getInstance();


    public static void T_FlightHack(ButtonWidget b){
        if(Toggle){
            ToggleFlightHack(false);
            Toggle = false;
        }else {
            ToggleFlightHack(true);
            Toggle = true;
        }
        b.setMessage(Text.literal("Creative-Flight " + G_FlightHack()));
    }
    public static String G_FlightHack(){
        MinecraftClient client = MinecraftClient.getInstance();
        boolean allowFlying = client.player.getAbilities().allowFlying;
        if(allowFlying){
            Toggle = true;
            return "enabled";
        }else {
            Toggle = false;
            return "disabled";
        }
    }
    public static void ToggleFlightHack(Boolean toggle) {
        MinecraftClient client = MinecraftClient.getInstance();
        assert client.player != null;
        PlayerAbilities abilities = client.player.getAbilities();
        abilities.allowFlying = toggle;
    }

    public static void tick(MinecraftClient client){
        if(client.player == null){
            return;
        }
        boolean allowedFlying = client.player.getAbilities().allowFlying;
        if(!allowedFlying){
            return;
        }
        if(tickCounter > antiKickInterval){
            tickCounter = 0;

        }
        if(tickCounter == 0 ){
            setMotionY(antiKickDistance);
        }
        if (tickCounter == 1){
            setMotionY(-antiKickDistance);
        }
        if (tickCounter == 2){
            setMotionY(0);
        }
        tickCounter++;
    }

    private static void setMotionY(double motionY)
    {
        if (MC.options.sneakKey.isPressed()){
            MC.options.sneakKey.setPressed(false);
            sneakWasPressed = true;
        } else {
            sneakWasPressed = false;
        }
        if (MC.options.jumpKey.isPressed()){
            MC.options.jumpKey.setPressed(false);
            jumpWasPressed = true;
        } else {
            jumpWasPressed = false;
        }



        Vec3d velocity = MC.player.getVelocity();
        MC.player.setVelocity(velocity.x, motionY, velocity.z);
    }
    private static void restoreKeyPresses()
    {
        if(sneakWasPressed){
            MC.options.sneakKey.setPressed(true);
        }
        if(jumpWasPressed){
            MC.options.jumpKey.setPressed(true);
        }
    }
}

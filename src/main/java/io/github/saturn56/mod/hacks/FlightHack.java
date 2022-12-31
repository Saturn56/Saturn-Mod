package io.github.saturn56.mod.hacks;

import io.github.saturn56.mod.SaturnMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.text.Text;

public class FlightHack {

    public static Boolean Toggle = false;

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
        if(Toggle){
            return "enabled";
        }else {
            return "disabled";
        }
    }
    public static void ToggleFlightHack(Boolean toggle) {
        MinecraftClient client = MinecraftClient.getInstance();
        assert client.player != null;
        PlayerAbilities abilities = client.player.getAbilities();
        abilities.allowFlying = !abilities.allowFlying;
    }
}

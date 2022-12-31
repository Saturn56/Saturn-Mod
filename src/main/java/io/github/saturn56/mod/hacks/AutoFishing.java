package io.github.saturn56.mod.hacks;

import io.github.saturn56.mod.SaturnMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

public class AutoFishing {
    public int recastRod = -1;
    public static AutoFishing instance = new AutoFishing();
    public static void T_AutoFishing(ButtonWidget b){
        SaturnMod.getInstance().Toggle_AutoFish = !SaturnMod.getInstance().Toggle_AutoFish;
        b.setMessage(Text.literal("Auto-Fish " + G_AutoFishing()));
    }

    public static String G_AutoFishing(){
        if(SaturnMod.getInstance().Toggle_AutoFish){
            return "enabled";
        }else {
            return "disabled";
        }
    }

    public static void tick(MinecraftClient client){
        if(SaturnMod.getInstance().recastRod>0) {
            SaturnMod.getInstance().recastRod--;
        }
        if(SaturnMod.getInstance().recastRod==0 && SaturnMod.getInstance().Toggle_AutoFish){
            client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
            SaturnMod.getInstance().recastRod=-1;
        }
    }

    public static void setRecastRod(int countdown) {
        SaturnMod.getInstance().recastRod = countdown;
    }

    public static AutoFishing getInstance(){return instance;};


}

package io.github.saturn56.mod.hacks;

import io.github.saturn56.mod.ExampleMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

public class AutoFishing {
    public int recastRod = -1;
    public static AutoFishing instance = new AutoFishing();
    public static void T_AutoFishing(ButtonWidget b){
        ExampleMod.getInstance().Toggle_AutoFish = !ExampleMod.getInstance().Toggle_AutoFish;
        b.setMessage(Text.literal("Auto-Fish " + G_AutoFishing()));
    }

    public static String G_AutoFishing(){
        if(ExampleMod.getInstance().Toggle_AutoFish){
            return "enabled";
        }else {
            return "disabled";
        }
    }

    public static void tick(MinecraftClient client){
        if(ExampleMod.getInstance().recastRod>0) {
            ExampleMod.getInstance().recastRod--;
        }
        if(ExampleMod.getInstance().recastRod==0 && ExampleMod.getInstance().Toggle_AutoFish){
            client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
            ExampleMod.getInstance().recastRod=-1;
        }
    }

    public static void setRecastRod(int countdown) {
        ExampleMod.getInstance().recastRod = countdown;
    }

    public static AutoFishing getInstance(){return instance;};


}

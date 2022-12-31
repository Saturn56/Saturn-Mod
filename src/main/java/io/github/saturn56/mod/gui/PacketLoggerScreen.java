package io.github.saturn56.mod.gui;

import io.github.saturn56.mod.ExampleMod;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

public class PacketLoggerScreen extends Screen{
    private final Screen parant;
    private final GameOptions settings;
    private ButtonWidget Toggle1Button;
    private ButtonWidget BackButton;

    public PacketLoggerScreen(Screen parent, GameOptions options) {
        super(Text.literal("Saturn Mod"));
        this.parant = parent;
        this.settings = options;
    }
    protected void init() {

        //addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 23, 130, 20, Text.literal("placeholder"), b ->{}));
        //addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 23 * 2, 130, 20, Text.literal("placeholder"), b ->{}));
        //addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 23 * 3, 130, 20, Text.literal("placeholder"), b ->{}));
        addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 23 * 4, 130, 20, Text.literal("ClientConnection"), b -> {}));
        addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 23 * 5, 130, 20, Text.literal("SoundPacket " + G_SoundPacket()), b -> {T_SoundPacket(b);}));
        addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 23 * 6, 130, 20, Text.literal("placeholder"), b -> {
        }));

        //addDrawableChild(new ButtonWidget(this.width / 2 - 135, this.height / 6 + 23, 130, 20, Text.literal("placeholder"), b ->{}));
        //addDrawableChild(new ButtonWidget(this.width / 2 - 135, this.height / 6 + 23 * 2, 130, 20, Text.literal("placeholder"), b ->{}));
        //addDrawableChild(new ButtonWidget(this.width / 2 - 135, this.height / 6 + 23 * 3, 130, 20, Text.literal("placeholder"), b ->{}));
        addDrawableChild(new ButtonWidget(this.width / 2 - 135, this.height / 6 + 23 * 4, 130, 20, Text.literal("placeholder"), b -> {
        }));
        addDrawableChild(new ButtonWidget(this.width / 2 - 135, this.height / 6 + 23 * 5, 130, 20, Text.literal("placeholder"), b -> {
        }));
        addDrawableChild(new ButtonWidget(this.width / 2 - 135, this.height / 6 + 23 * 6, 130, 20, Text.literal("placeholder"), b -> {
        }));

        addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 23 * 7, 200, 20, ScreenTexts.BACK, b -> {
            this.client.setScreen(this.parant);
        }));
    }

    public void T_SoundPacket(ButtonWidget b){
        ExampleMod.getInstance().Toggle_SoundPacket = !ExampleMod.getInstance().Toggle_SoundPacket;
        b.setMessage(Text.literal("SoundPacket " + G_SoundPacket()));
    }
    public String G_SoundPacket(){
        if(ExampleMod.getInstance().Toggle_SoundPacket){
            return "enabled";
        }else {
            return "disabled";
        }
    }
}

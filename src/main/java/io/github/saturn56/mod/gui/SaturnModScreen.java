package io.github.saturn56.mod.gui;



import io.github.saturn56.mod.SaturnMod;
import io.github.saturn56.mod.hacks.AutoFishing;
import io.github.saturn56.mod.hacks.FlightHack;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

public class SaturnModScreen extends Screen {
    private final Screen parant;
    private final GameOptions settings;
    private ButtonWidget Toggle1Button;
    private ButtonWidget BackButton;

    public SaturnModScreen(Screen parent, GameOptions options) {
        super(Text.literal("Saturn Mod"));
        this.parant = parent;
        this.settings = options;
    }


    protected void init(){
        //addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 23, 130, 20, Text.literal("placeholder"), b ->{}));
        //addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 23 * 2, 130, 20, Text.literal("placeholder"), b ->{}));
        //addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 23 * 3, 130, 20, Text.literal("placeholder"), b ->{}));
        addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 23 * 4, 130, 20, Text.literal("X-Ray " + G_xRay()), b ->{T_xRay(b);}));
        addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 23 * 5, 130, 20, Text.literal("placeholder"), b ->{}));
        addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 23 * 6, 130, 20, Text.literal("placeholder"), b ->{}));
        addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 23 * 7, 130, 20, Text.literal("Packet Logger"), b ->{this.client.setScreen(new PacketLoggerScreen(this, this.client.options));}));

        //addDrawableChild(new ButtonWidget(this.width / 2 - 135, this.height / 6 + 23, 130, 20, Text.literal("placeholder"), b ->{}));
        //addDrawableChild(new ButtonWidget(this.width / 2 - 135, this.height / 6 + 23 * 2, 130, 20, Text.literal("placeholder"), b ->{}));
        //addDrawableChild(new ButtonWidget(this.width / 2 - 135, this.height / 6 + 23 * 3, 130, 20, Text.literal("placeholder"), b ->{}));
        addDrawableChild(new ButtonWidget(this.width / 2 - 135, this.height / 6 + 23 * 4, 130, 20, Text.literal("Auto-Fish " + AutoFishing.G_AutoFishing()), b ->{AutoFishing.T_AutoFishing(b);}));
        addDrawableChild(new ButtonWidget(this.width / 2 - 135, this.height / 6 + 23 * 5, 130, 20, Text.literal("Creative-Flight" + FlightHack.G_FlightHack()), b ->{FlightHack.T_FlightHack(b);}));
        addDrawableChild(new ButtonWidget(this.width / 2 - 135, this.height / 6 + 23 * 6, 130, 20, Text.literal("placeholder"), b ->{}));
        addDrawableChild(new ButtonWidget(this.width / 2 - 135, this.height / 6 + 23 * 7, 130, 20, Text.literal("placeholder"), b ->{}));

        addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 23 * 8, 200, 20, ScreenTexts.BACK, b ->{this.client.setScreen(this.parant);}));

        /*addDrawableChild(BackButton =
                ButtonWidget.builder(ScreenTexts.BACK,
                        button -> {
                            this.client.setScreen(this.parant);
                        }).dimensions(this.width / 2 - 100, this.height / 6 + 90, 200, 20).build());*/
    }
    public void T_xRay(ButtonWidget b){
        if(SaturnMod.getInstance().Toggle_xRay){
            SaturnMod.getInstance().Toggle_xRay = false;
        }else {
            SaturnMod.getInstance().Toggle_xRay = true;
        }
        b.setMessage(Text.literal("X-Ray " + G_xRay()));
    }

    String G_xRay(){
        if(SaturnMod.getInstance().Toggle_xRay){
            return "enabled";
        }else {
            return "disabled";
        }
    }

    public void Packet_Logger(){

    }
}

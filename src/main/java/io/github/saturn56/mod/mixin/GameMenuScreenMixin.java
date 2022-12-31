package io.github.saturn56.mod.mixin;

import io.github.saturn56.mod.gui.SaturnModScreen;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public abstract class GameMenuScreenMixin extends Screen {

    protected GameMenuScreenMixin(Text text) {
        super(text);
    }


    @Inject(at = @At("TAIL"), method = "initWidgets")
    private void initWidgets(CallbackInfo ci){
        /*ButtonWidget saturnModMenue =
                ButtonWidget.builder(Text.literal("Saturn Mod Menue"),
                button -> {
                    this.client.setScreen(new SaturnModScreen(this, this.client.options));
        }).dimensions(10, 10, 90, 20).build();*/
        this.addDrawableChild(new ButtonWidget(this.width - 130, this.height - 50, 120, 20, Text.literal("Saturn Mod Menue"),
                button -> {
                    this.client.setScreen(new SaturnModScreen(this, this.client.options));
        }));
        //this.addDrawableChild(saturnModMenue);
    }
}

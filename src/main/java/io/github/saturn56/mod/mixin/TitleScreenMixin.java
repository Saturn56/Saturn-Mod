package io.github.saturn56.mod.mixin;

import io.github.saturn56.mod.gui.SaturnModScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("TAIL"), method = "initWidgetsNormal")
    private void initWidgetsNormal(int y, int spacingY, CallbackInfo ci){
        int l = this.height / 4 + 48;
        this.addDrawableChild(new ButtonWidget(this.width - 130, this.height - 50, 120, 20, Text.literal("Saturn Mod Menue"),
                button -> {
                    this.client.setScreen(new SaturnModScreen(this, this.client.options));
                }));
        /*this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, y + spacingY * 3, 200, 20, Text.translatable("menu.online"), (button) -> {
            this.client.setScreen(new SaturnModScreen(this, this.client.options));
        }));*/
    }
}

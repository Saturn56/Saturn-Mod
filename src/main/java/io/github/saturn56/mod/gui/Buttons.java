package io.github.saturn56.mod.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class Buttons extends Screen {
    protected Buttons(Text title) {
        super(title);
    }

    public ButtonWidget createButtonMenue(int lORr /* Left 0, Right 1 */, int numFromUp /* Number from up to down form 0-8*/){

        return new ButtonWidget(this.width / 2 + 5, this.height / 6 + 23, 130, 20, Text.literal("placeholder"), b ->{});
    }
}

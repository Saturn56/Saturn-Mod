package io.github.saturn56.mod.hacks;

import io.github.saturn56.mod.SaturnMod;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;

import java.util.HashSet;

public class xRay {

    private static HashSet<String> xrayBlocks = new HashSet();

    public static HashSet<String> xRayList(){
        HashSet<String> xrayBlock = new HashSet<String>();
        xrayBlock.add("minecraft:coal_ore");
        xrayBlock.add("minecraft:diorite");
        return xrayBlock;
    }

    public static boolean showBlock(BlockState state) {
        String name = Registry.BLOCK.getId(state.getBlock()).toString();
        SaturnMod.LOGGER.info(name);
        if (xRayList().contains(state.getBlock().toString())){
            SaturnMod.LOGGER.info(name);
            SaturnMod.LOGGER.info("rendered");
            return true;
        }
        return false;
    }
}

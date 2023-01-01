package io.github.saturn56.mod.hacks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;
import java.util.List;

public class xRay {


    public static List<Block> XRAY_BLOCKS(){
        return Arrays.asList(Blocks.COAL_BLOCK, Blocks.DIORITE, Blocks.DIAMOND_ORE);
    }


    public static boolean showBlock(BlockState state) {
        String name = Registry.BLOCK.getId(state.getBlock()).toString();
        if (XRAY_BLOCKS().contains(state.getBlock())){
            //SaturnMod.LOGGER.info(name);
            //SaturnMod.LOGGER.info("rendered");
            return true;
        }
        return false;
    }
}

package me.peke.mtplus;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

/*
    We do this because the StairBlock constructor has protected access for some strange reason
 */
public class AccesibleStairBlock extends StairBlock {
    public AccesibleStairBlock(BlockState blockState, Properties properties) {
        super(blockState, properties);
    }
}

package com.github.puzzle.game.block;

import com.badlogic.gdx.graphics.Pixmap;
import com.github.puzzle.game.block.generators.BlockGenerator;
import com.github.puzzle.game.block.generators.model.BasicCubeModelGenerator;
import com.github.puzzle.game.block.generators.model.BlockModelGenerator;
import com.github.puzzle.game.block.generators.model.IBlockModelGenerator;
import finalforeach.cosmicreach.util.Identifier;

import java.util.List;

/**
 * @see IModBlock
 * This class creates a basic Block with top, bottom and side
 * textures, a simple default block state and a single custom
 * model
 */
public class BasicModBlock implements IModBlock {

    public Identifier blockId;
    public String blockName;
    public Pixmap top, bottom, side;

    public BasicModBlock(Identifier blockId, String blockName) {
        this.blockId = blockId;
        this.blockName = blockName;
    }

    @Override
    public Identifier getIdentifier() {
        return blockId;
    }

    @Override
    public BlockGenerator getBlockGenerator() {
        BlockGenerator generator = new BlockGenerator(blockId);
        generator.createBlockState("default", "model", true);
        return generator;
    }

    @Override
    public List<IBlockModelGenerator> getBlockModelGenerators(Identifier blockId) {
        BlockModelGenerator generator = new BasicCubeModelGenerator(blockId, "model", true, top, bottom, side);
        return List.of(generator);
    }

}
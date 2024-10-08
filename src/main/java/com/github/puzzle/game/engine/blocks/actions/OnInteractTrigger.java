package com.github.puzzle.game.engine.blocks.actions;

import com.github.puzzle.core.PuzzleRegistries;
import com.github.puzzle.game.block.IModBlock;
import finalforeach.cosmicreach.blockevents.BlockEventTrigger;
import finalforeach.cosmicreach.blockevents.actions.ActionId;
import finalforeach.cosmicreach.blockevents.actions.IBlockAction;
import finalforeach.cosmicreach.blocks.BlockPosition;
import finalforeach.cosmicreach.blocks.BlockState;
import finalforeach.cosmicreach.gamestates.InGame;
import finalforeach.cosmicreach.util.Identifier;
import finalforeach.cosmicreach.world.Zone;

import java.util.Map;

@ActionId(id = "puzzle-loader:mod_block_interact")
public class OnInteractTrigger implements IBlockAction {

    public Identifier blockId;

    @Override
    public void act(BlockState blockState, BlockEventTrigger blockEventTrigger, Zone zone, Map<String, Object> map) {
        IModBlock block = PuzzleRegistries.BLOCKS.get(blockId);
        block.onInteract(zone, InGame.getLocalPlayer(), blockState, (BlockPosition) map.get("blockPos"));
    }
}
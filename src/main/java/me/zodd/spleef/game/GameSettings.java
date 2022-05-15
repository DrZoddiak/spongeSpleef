package me.zodd.spleef.game;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;

import java.util.ArrayList;
import java.util.List;

public class GameSettings {
    private boolean pvpAllowed;
    private boolean resetArenaAutomatically;
    private int maxPlayers;
    private List<BlockType> floorBlocks;
    private ItemType startingItem;
    private int matchTime;

    public GameSettings gameSettings(
            boolean pvpAllowed,
            boolean resetArenaAutomatically,
            int maxPlayers,
            List<BlockType> floorBlocks,
            ItemType startingItem,
            int matchTime
    ) {
        this.pvpAllowed = pvpAllowed;
        this.resetArenaAutomatically = resetArenaAutomatically;
        this.maxPlayers = maxPlayers;
        this.floorBlocks = floorBlocks;
        this.startingItem = startingItem;
        this.matchTime = matchTime;
        return this;
    }

    public GameSettings gameSettings() {
        List<BlockType> fb = new ArrayList<>();
        fb.add(BlockTypes.SNOW_BLOCK.get());
        return gameSettings(
                false,
                true,
                2,
                fb,
                ItemTypes.GOLDEN_SHOVEL.get(),
                300
        );
    }

    public int getMatchTime() {
        return matchTime;
    }

    public boolean isResetArenaAutomatically() {
        return resetArenaAutomatically;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public ItemType getStartingItem() {
        return startingItem;
    }

    public boolean isPvpAllowed() {
        return pvpAllowed;
    }

    public List<BlockType> getFloorBlocks() {
        if (floorBlocks.isEmpty()) floorBlocks.add(BlockTypes.SNOW_BLOCK.get());
        return floorBlocks;
    }
}

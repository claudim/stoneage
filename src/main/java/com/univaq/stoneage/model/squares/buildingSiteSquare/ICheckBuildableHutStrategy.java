package com.univaq.stoneage.model.squares.buildingSiteSquare;

import com.univaq.stoneage.model.MHutToken;
import com.univaq.stoneage.model.players.MPlayer;

import java.util.ArrayList;

/**
 * Interface for the control of the buildable hut strategy.
 */
public interface ICheckBuildableHutStrategy {
    /**
     * Check if a list of hut tokens are buildable for the player.
     *
     * @param player           The player who want to build a hut.
     * @param hutTokensToCheck The list of the all hut tokens not buildable yet
     * @return The hut token buildable
     */
    ArrayList<MHutToken> checkBuildableHut(MPlayer player, ArrayList<MHutToken> hutTokensToCheck);
}

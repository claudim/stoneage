package com.univaq.stoneage.model.gameGoal;

import com.univaq.stoneage.model.players.MPlayer;

/**
 * Strategy Interface responsible to know if a player is the game winner.
 */
public interface IGameGoalStrategy {

    /**
     * Check if the player is the game winner.
     *
     * @param player the player to check if he is the game winner
     * @return true if the player is the game winner, false otherwise
     */
    boolean isWinner(MPlayer player);
}

package com.univaq.stoneage.model.gameGoal;

import com.univaq.stoneage.model.players.MPlayer;

/**
 * Strategy to decree the player victory if the player has built 3 hut token.
 */
public class ThreeHutTokenGoalStrategy implements IGameGoalStrategy {

    /**
     * Check if the player is the game winner. To do this, it checks if the player has built 3 hut token.
     *
     * @param player the player to check if he is the game winner
     * @return true if the player is the game winner, false otherwise
     */
    @Override
    public boolean isWinner(MPlayer player) {
        // player.setM_winner(true);
        return player.getM_settlement().getM_builtHutTokens().size() == 3;
        //return true;
    }
}

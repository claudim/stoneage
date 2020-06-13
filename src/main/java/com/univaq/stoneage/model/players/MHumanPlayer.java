package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MStoneAgeGame;

/**
 * A specific player.
 */
public class MHumanPlayer extends MPlayer {
    public MHumanPlayer() {
        super();
    }

    @Override
    public void playTurn() {
        MStoneAgeGame.getInstance().getM_gameState().waitForTokenForest();
        //NO-OP
    }

    @Override
    public void buildHut() {
        //NO-OP
    }

    @Override
    public void stealResource() {
        //NO-OP
    }

    /**
     * Execute the ability when the player is on a square.
     */
    @Override
    public void executeOnSquareAbility() {
    }

    /**
     * Execute the ability on start turn.
     */
    @Override
    public void executeOnStartTurnAbility() {

    }

    /**
     * Get the player with no ability.
     *
     * @return The player with no ability
     */
    @Override
    public MPlayer getPlayer() {
        return this;
    }

}
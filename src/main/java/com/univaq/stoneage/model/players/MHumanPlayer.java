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

    /**
     * Choose the robbed player name among game players.
     *
     * @return the robbed player name
     */
    @Override
    public String choosePlayerToRob() {
        return null;
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

    /**
     * Choose the hut token id to build.
     *
     * @return the hut token id
     */
    @Override
    public int chooseIdHutToken() {
        return -1;
    }

}
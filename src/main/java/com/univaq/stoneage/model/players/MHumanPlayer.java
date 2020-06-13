package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MStoneAgeGame;

/**
 *
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

    @Override
    public void executeOnSquareAbility() {

    }

    @Override
    public void executeOnStartTurnAbility() {

    }

    @Override
    public MPlayer getPlayer() {
        return this;
    }

}
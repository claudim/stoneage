package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.gameState.GameState;

public class TakeAnotherTurnAbilityPlayerDecorator extends ExtraAbilityPlayerDecorator {


    public TakeAnotherTurnAbilityPlayerDecorator(MPlayer playerWithNoAbility) {
        super(playerWithNoAbility);
        this.m_marker = playerWithNoAbility.getM_marker();
        this.m_settlement = playerWithNoAbility.getM_settlement();
    }

    @Override
    public void playTurn() {

    }

    @Override
    public void buildHut() {

    }

    @Override
    public void stealResource() {

    }

    @Override
    public void executeAbility() {

    }

    @Override
    public void executeOnSquareAbility() {

    }

    @Override
    public void executeOnStartTurnAbility() {

    }

    @Override
    public void executeOnEndTurnAbility() {
        removeAbility();
        GameState gameState = MStoneAgeGame.getInstance().getM_gameState();
        if (isM_winner()) {
            gameState.winner();
            // visualizza vittoria
        } else {
            // next player play his turn
            gameState.takeAnotherTurn();
        }
    }

    @Override
    public MPlayer getPlayer() {
        return null;
    }
}

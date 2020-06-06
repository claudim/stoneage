package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MStoneAgeGame;

public class SkipNextTurnAbilityPlayerDecorator extends ExtraAbilityPlayerDecorator {

    public SkipNextTurnAbilityPlayerDecorator(MPlayer player) {
        super(player);
        this.m_marker = player.getM_marker();
        this.m_settlement = player.getM_settlement();
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
        removeAbility();
        MStoneAgeGame.getInstance().getGameState().skipTurn();
        System.out.println(player.getMarkerName() + " ha saltato il turno");

    }
}

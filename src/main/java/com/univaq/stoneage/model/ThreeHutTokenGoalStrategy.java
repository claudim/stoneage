package com.univaq.stoneage.model;

import com.univaq.stoneage.model.players.MPlayer;

public class ThreeHutTokenGoalStrategy implements IGameGoalStrategy {
    @Override
    public boolean isWinner(MPlayer player) {
        // player.setM_winner(true);
        return player.getM_settlement().getM_builtHutTokens().size() == 3;
    }
}

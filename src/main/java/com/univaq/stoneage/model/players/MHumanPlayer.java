package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.hutTokens.MHutToken;

import java.util.ArrayList;

public class MHumanPlayer extends MPlayer {
    public MHumanPlayer() {
        super();
    }

    @Override
    public void playTurn() {
        //NO-OP
    }


    @Override
    public void buildHut(ArrayList<MHutToken> playerBuildableMHutTokens) {
        if (playerBuildableMHutTokens.size() == 0)
            MStoneAgeGame.getInstance().getGameState().hutBuilt();
    }

}
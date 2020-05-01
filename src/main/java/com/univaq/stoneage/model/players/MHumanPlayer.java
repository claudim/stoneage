package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MHutToken;

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
        //NO-OP
    }
}
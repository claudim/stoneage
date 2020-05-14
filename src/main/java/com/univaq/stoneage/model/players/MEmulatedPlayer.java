package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.hutTokens.MHutToken;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MEmulatedPlayer extends MPlayer {

    public MEmulatedPlayer() {
        super();
    }

    @Override
    public void playTurn() {

        int nextForestTokenId = MStoneAgeGame.getInstance().getM_grid().getNextForestTokenId();
        //wait 2 seconds before execute MStoneAgeGame.getInstance().playTurn(nextForestTokenId)
        final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.schedule(() -> MStoneAgeGame.getInstance().playTurn(nextForestTokenId), 2, TimeUnit.SECONDS);

    }

    @Override
    public void buildHut(ArrayList<MHutToken> playerBuildableHutTokens) {
        if (playerBuildableHutTokens.size() > 0) {
            int idHutToken = MStoneAgeGame.getInstance().getM_board().getBuildingSiteSquare().getNextHutTokenId(playerBuildableHutTokens);
            buildHut(idHutToken);
        } else {
            // non posso costruire nulla quindi termino il turno
            MStoneAgeGame.getInstance().getGameState().hutBuilt();
        }

//        if (playerBuildableHutTokens.size() > 0) {//todo non è detto che debba scegliere il primo inserire strategia ad esempio
//            int idHutToken = playerBuildableHutTokens.get(0).getIdToken();
//            this.buildHut(idHutToken);
//        }
    }


}
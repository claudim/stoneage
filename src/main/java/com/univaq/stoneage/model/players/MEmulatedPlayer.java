package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MHutToken;
import com.univaq.stoneage.model.MStoneAgeGame;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MEmulatedPlayer extends MPlayer {

    public MEmulatedPlayer() {
        super();
    }

    @Override
    public void playTurn() {

        //wait 2 seconds before execute MStoneAgeGame.getInstance().playTurn(1)
        final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.schedule(() -> MStoneAgeGame.getInstance().playTurn(1), 2, TimeUnit.SECONDS);

    }

    @Override
    public void buildHut(ArrayList<MHutToken> playerBuildableHutTokens) {
        if (playerBuildableHutTokens.size() > 0) {//todo non è detto che debba scegliere il primo inserire strategia ad esempio
            int idHutToken = playerBuildableHutTokens.get(0).getIdHutToken();
            this.buildHut(idHutToken);
        }
    }


}
package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MStoneAgeGame;

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
}
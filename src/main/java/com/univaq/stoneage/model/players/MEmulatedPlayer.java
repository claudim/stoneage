package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.hutTokens.MHutToken;
import com.univaq.stoneage.model.players.RobbedPlayer.MIRobbedPlayerStrategy;
import com.univaq.stoneage.model.players.RobbedPlayer.MRandomRobberPlayerStrategy;

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
        MStoneAgeGame.getInstance().getGameState().waitForTokenForest();
        //wait 2 seconds before execute MStoneAgeGame.getInstance().playTurn(nextForestTokenId)
        final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.schedule(() -> MStoneAgeGame.getInstance().playTurn(nextForestTokenId), 2, TimeUnit.SECONDS);
    }

    @Override
    public void buildHut() {
        ArrayList<MHutToken> playerBuildableHutTokens = MStoneAgeGame.getInstance().getM_board().getBuildingSiteSquare().getM_playerBuildableMHutTokens();
        //has already been done the check if playerBuildableHutTokens.size is zero
        int idHutToken = MStoneAgeGame.getInstance().getM_board().getBuildingSiteSquare().getNextHutTokenId(playerBuildableHutTokens);
        MStoneAgeGame.getInstance().buildHut(idHutToken);

    }

    @Override
    public void stealResource() {

        // todo strategia 
        //scegliere a caso
        ArrayList<MPlayer> gamePlayers = MStoneAgeGame.getInstance().getM_players();
        ArrayList<MPlayer> players = new ArrayList<>();
        gamePlayers.forEach(mPlayer -> {
            if (!mPlayer.getMarkerName().equals(this.getMarkerName())) {
                players.add(mPlayer);
            }
        });
        MIRobbedPlayerStrategy robbedPlayerStrategy = new MRandomRobberPlayerStrategy();
        String robbedPlayerName = robbedPlayerStrategy.getRobbedPlayerName(players);
        // ruba
        MStoneAgeGame.getInstance().stealResource(robbedPlayerName);
    }


}
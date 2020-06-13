package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.hutTokens.MHutToken;
import com.univaq.stoneage.model.players.RobbedPlayer.MIRobbedPlayerStrategy;
import com.univaq.stoneage.model.players.RobbedPlayer.MRandomRobberPlayerStrategy;
import com.univaq.stoneage.model.squares.buildingSiteSquare.MBuildingSiteSquare;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * A specific player. The system emulates the human actions.
 */
public class MEmulatedPlayer extends MPlayer {

    public MEmulatedPlayer() {
        super();
    }

    /**
     * Start a turn. The system chooses a forest token for the emulated player and then calls the play turn system's operation after waited 2 seconds.
     */
    @Override
    public void playTurn() {
        int nextForestTokenId = MStoneAgeGame.getInstance().getM_grid().getNextForestTokenId();
        MStoneAgeGame.getInstance().getM_gameState().waitForTokenForest();
        //wait 2 seconds before execute MStoneAgeGame.getInstance().playTurn(nextForestTokenId)
        final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.schedule(() -> MStoneAgeGame.getInstance().playTurn(nextForestTokenId), 2, TimeUnit.SECONDS);
    }

    /**
     * Start to build a hut. The system chooses a hut token for the emulated player and then calls the buildBut system's operation.
     */
    @Override
    public void buildHut() {
        MStoneAgeGame stoneAgeGame = MStoneAgeGame.getInstance();
        MBuildingSiteSquare bsSquare = stoneAgeGame.getM_board().getBuildingSiteSquare();
        ArrayList<MHutToken> playerBuildableHutTokens = bsSquare.getM_playerBuildableMHutTokens();
        //has already been done the check if playerBuildableHutTokens.size is zero
        int idHutToken = bsSquare.getNextHutTokenId(playerBuildableHutTokens);
        stoneAgeGame.buildHut(idHutToken);
    }

    /**
     *
     */
    @Override
    public void stealResource() {
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

//    @Override
//    public void executeAbility() {
//
//    }

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
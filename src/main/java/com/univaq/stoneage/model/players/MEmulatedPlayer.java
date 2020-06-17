package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.RobbedPlayer.MIRobbedPlayerStrategy;
import com.univaq.stoneage.model.players.RobbedPlayer.MRandomRobbedPlayerStrategy;
import com.univaq.stoneage.model.squares.buildingSiteSquare.MBuildingSiteSquare;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * A specific player. The system emulates the human actions.
 */
public class MEmulatedPlayer extends MPlayer {

    /**
     * Strategy to choose
     */
    private MIRobbedPlayerStrategy robbedPlayerStrategy;

    /**
     * Constructor.
     */
    public MEmulatedPlayer() {
        super();
    }

    /**
     * Start a turn. The system chooses a forest token for the emulated player
     * then calls the play turn system's operation after waited 2 seconds.
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
     * Choose the robbed player name among game players.
     *
     * @return the robbed player name
     */
    public String choosePlayerToRob() {
        ArrayList<MPlayer> gamePlayers = MStoneAgeGame.getInstance().getM_players();
        ArrayList<MPlayer> players = new ArrayList<>();
        gamePlayers.forEach(mPlayer -> {
            if (!mPlayer.getMarkerName().equals(this.getMarkerName())) {
                players.add(mPlayer);
            }
        });
        //TODO inserire nella factory
        robbedPlayerStrategy = new MRandomRobbedPlayerStrategy();
        return robbedPlayerStrategy.getRobbedPlayerName(players);
    }

    /**
     * Execute the ability when the player is on a square.
     */
    @Override
    public void executeOnSquareAbility() {

    }

    /**
     * Execute the ability on start turn.
     */
    @Override
    public void executeOnStartTurnAbility() {

    }

    /**
     * Get the player with no ability.
     *
     * @return The player with no ability
     */
    @Override
    public MPlayer getPlayer() {
        return this;
    }

    /**
     * Choose the hut token id to build.
     *
     * @return the hut token id
     */
    @Override
    public int chooseIdHutToken() {
        MBuildingSiteSquare bsSquare = MStoneAgeGame.getInstance().getM_board().getBuildingSiteSquare();
        //ArrayList<MHutToken> playerBuildableHutTokens = bsSquare.getM_playerBuildableMHutTokens();
        //has already been done the check if playerBuildableHutTokens.size is zero
        // int idHutToken = bsSquare.getNextHutTokenId(playerBuildableHutTokens);

        return bsSquare.getNextHutTokenId(bsSquare.getM_playerBuildableMHutTokens());
    }
}
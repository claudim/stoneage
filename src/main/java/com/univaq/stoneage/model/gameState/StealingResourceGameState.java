package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.MResourceSquare;

import java.util.ArrayList;

public class StealingResourceGameState implements IGameState {

    private final GameState gameState;

    public StealingResourceGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void nextTurn() {

    }


    @Override
    public void winner() {

    }

    @Override
    public void onNewSquare(int idForestToken) {

    }

    @Override
    public void hutBuilt(int idHutToken) {

    }

    @Override
    public void initialize() {
    }

    @Override
    public void doSquareAction() {
        MStoneAgeGame.getInstance().getGameState().setWaitingForEvent(true);
    }

    @Override
    public void endAction() {

    }

    @Override
    public void stealResource(String playerName) {
        MPlayer activePlayer = MStoneAgeGame.getInstance().getActivePlayer();
        String resourceType = ((MResourceSquare) activePlayer.getM_marker().getCurrentSquare()).getm_resourceType();
        ArrayList<MPlayer> m_players = MStoneAgeGame.getInstance().getM_players();
        MPlayer player = m_players.stream().filter(p -> p.getMarkerName().equals(playerName)).findFirst().get();
        MResource resource = player.getM_settlement().getM_resources().stream().filter(r -> r.getM_type().equals(resourceType)).findFirst().get();
        player.getM_settlement().removeResource(resource);
        activePlayer.getM_settlement().addResource(resource);
        this.gameState.changeState(new EndTurnGameState(this.gameState));
    }

}

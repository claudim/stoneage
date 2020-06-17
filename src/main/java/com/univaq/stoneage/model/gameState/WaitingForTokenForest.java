package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.players.MPlayer;

public class WaitingForTokenForest implements IGameState {
    private final GameState gameState;

    public WaitingForTokenForest(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void waitForTokenForest() {

    }

    @Override
    public void initState() {

    }

    @Override
    public void onNewSquare(int idForestToken) {
        MStoneAgeGame sag = MStoneAgeGame.getInstance();
        MTokenForest mTokenForest = sag.getM_grid().faceUpTokenForest(idForestToken);
        if (mTokenForest != null) {
            MPlayer activePlayer = sag.getActivePlayer();
            System.out.println(activePlayer.getMarkerName() + " ha scelto il token " + mTokenForest.getValue());
            activePlayer.moveMarker(mTokenForest);
            this.gameState.changeState(new OnNewSquareGameState(this.gameState));
        } else {
            this.gameState.changeState(new EndTurnGameState(this.gameState));
            this.gameState.initState();
        }
    }


    @Override
    public void nextTurn() {

    }

    @Override
    public void winner() {

    }

    @Override
    public void takeAnotherTurn() {

    }


    @Override
    public void hutBuilt(int idHutToken) {

    }

    @Override
    public void initialize() {

    }

    @Override
    public void doSquareAction() {

    }

    @Override
    public void endAction() {

    }

    @Override
    public void stealResource(MPlayer player) {

    }


}

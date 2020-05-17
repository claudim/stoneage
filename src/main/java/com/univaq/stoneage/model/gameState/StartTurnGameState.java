package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.MSquare;

public class StartTurnGameState implements IGameState {

    private final GameState gameState;

    public StartTurnGameState(GameState gameState) {
        this.gameState = gameState;
        MStoneAgeGame.getInstance().getCurrentPlayer().playTurn();
    }

    @Override
    public void nextTurn() {
        System.out.println("nextTurn   StartTurnGameState");
    }

    @Override
    public void winner() {
        System.out.println("winner   StartGameState");
    }

    @Override
    public void onNewSquare(int idForestToken) {
        //System.out.println("onNewSquare   StartGameState");
        MStoneAgeGame sag = MStoneAgeGame.getInstance();
        MTokenForest mTokenForest = sag.getM_grid().faceUpTokenForest(idForestToken);
        if (mTokenForest != null) {
            MPlayer activePlayer = sag.getCurrentPlayer();
            MSquare newSquare = activePlayer.moveMarker(mTokenForest, sag.getM_board());
            this.gameState.changeState(new OnNewSquareGameState(this.gameState));
        } else {
            //andare ad end turn
            this.gameState.changeState(new EndTurnGameState(this.gameState));
            //sag.endTurnActions();
        }

        //this.gameState.changeState(new OnNewSquareGameState(this.gameState));

    }

    @Override
    public void hutBuilt(int idHutToken) {
        System.out.println("hutBuilt   StartGameState");
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
    public void stealResource(String playerName) {

    }
}

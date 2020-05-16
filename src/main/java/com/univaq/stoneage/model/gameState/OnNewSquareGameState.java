package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.ActionResult;
import com.univaq.stoneage.model.squares.MSquare;

public class OnNewSquareGameState implements IGameState {

    private final GameState gameState;

    public OnNewSquareGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void nextTurn() {
        System.out.println("nextTurn OnNewSquareGameState");

    }

    @Override
    public void winner() {

    }

    @Override
    public void onNewSquare(int idForestToken) {
        System.out.println("onNewSquare OnNewSquareGameState");
    }

    @Override
    public void hutBuilt(int idHutToken) {
        System.out.println("hutBuilt  onNewSuqareGameState");
    }

    @Override
    public void initialize() {

    }

    @Override
    public void doSquareAction() {
        MPlayer activePlayer = MStoneAgeGame.getInstance().getCurrentPlayer();
        MSquare newSquare = activePlayer.getM_marker().getCurrentSquare();
        ActionResult actionResult = newSquare.doAction(activePlayer);
        IStateFactory stateFactory = new SimpleStateFactory();
        gameState.changeState(stateFactory.createState(actionResult, gameState));
    }

    @Override
    public void endAction() {
    }
}

package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.MStoneAgeGame;

public class StartTurnGameState implements IGameState {

    private final GameState gameState;

    public StartTurnGameState(GameState gameState) {
        this.gameState = gameState;

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

    @Override
    public void waitForTokenForest() {
        this.gameState.changeState(new WaitingForTokenForest(this.gameState));
    }

    @Override
    public void initState() {
        MStoneAgeGame.getInstance().getCurrentPlayer().playTurn();
    }
}

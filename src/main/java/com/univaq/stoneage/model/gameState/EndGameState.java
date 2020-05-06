package com.univaq.stoneage.model.gameState;

public class EndGameState implements IGameState {
    public EndGameState(GameState gameState) {
    }

    @Override
    public void nextTurn() {

    }

    @Override
    public void gotResource() {

    }

    @Override
    public void hutTokenCheckDone() {

    }

    @Override
    public void winner() {

    }

    @Override
    public void onNewSquare() {

    }

    @Override
    public void hutBuilt() {
        System.out.println("EndGameState");
    }
}

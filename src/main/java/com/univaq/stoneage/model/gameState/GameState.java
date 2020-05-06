package com.univaq.stoneage.model.gameState;

/**
 * This class is responsible for setting the state and getting what state we are in
 */
public class GameState {
    private IGameState gameState;

    public GameState() {
        // startTurnGameState is the default game state
        this.gameState = new StartTurnGameState(this);
    }

    public GameState(IGameState gameState) {
        this.gameState = gameState;
    }

    public IGameState getGameState() {
        return gameState;
    }

    public void setGameState(IGameState gameState) {
        this.gameState = gameState;
    }


    public void changeState(IGameState gameState) {
        this.gameState = gameState;
    }

    // every method delegate IGameState to handle the method

    public void nextTurn() {
        //delegates to IGameState
        this.gameState.nextTurn();

    }

    public void gotResource() {
        this.gameState.gotResource();
    }

    public void hutForestCheckDone() {
        this.gameState.hutTokenCheckDone();
    }

    public void winner() {
        this.gameState.winner();
    }

    public void onNewSquare() {
        this.gameState.onNewSquare();
    }

    public void hutBuilt() {
        this.gameState.hutBuilt();
    }
}

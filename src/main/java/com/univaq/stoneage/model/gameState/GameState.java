package com.univaq.stoneage.model.gameState;

/**
 * This class is responsible for setting the state and getting what state we are in
 */
public class GameState {
    private IGameState gameState;
    private boolean waitingForEvent;

    public GameState() {
        // startGameState is the default game state
        this.gameState = new StartGameState(this);
        waitingForEvent = false;
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

    public void winner() {
        this.gameState.winner();
    }

    public void playTurn(int idForestToken) {
        this.gameState.onNewSquare(idForestToken);
        while (!this.gameState.getClass().getSimpleName().equals(EndTurnGameState.class.getSimpleName()) && !waitingForEvent) {
            this.gameState.doSquareAction();
        }
        this.gameState.endAction();

    }

    public void hutBuilt(int idHutToken) {
        this.gameState.hutBuilt(idHutToken);
        this.waitingForEvent = false;
        this.gameState.endAction();
    }

    public void initialize() {
        this.gameState.initialize();
    }

    public boolean isWaitingForEvent() {
        return waitingForEvent;
    }

    public void setWaitingForEvent(boolean waitingForEvent) {
        this.waitingForEvent = waitingForEvent;
    }
}

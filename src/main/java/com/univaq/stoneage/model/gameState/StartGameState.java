package com.univaq.stoneage.model.gameState;

public class StartGameState implements IGameState {

    private final GameState gameState;

    public StartGameState(GameState gameState) {
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
        this.gameState.changeState(new StartTurnGameState(this.gameState));
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

package com.univaq.stoneage.model.gameState;

public class EndGameState implements IGameState {
    public EndGameState(GameState gameState) {
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
        System.out.println("EndGameState");
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

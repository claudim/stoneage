package com.univaq.stoneage.model.gameState;

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
    public void gotResource() {
        System.out.println("gotResource OnNewSquareGameState");
        //this.gameState.changeState(new ResourceCaughtGameState(this.gameState));
        this.gameState.changeState(new EndTurnGameState(this.gameState));

    }

    @Override
    public void hutTokenCheckDone() {
        System.out.println("hutTokenCheckDone OnNewSquareGameState");
        this.gameState.changeState(new BuildingHutGameState(this.gameState));
    }

    @Override
    public void winner() {

    }

    @Override
    public void onNewSquare() {
        System.out.println("onNewSquare OnNewSquareGameState");
    }

    @Override
    public void hutBuilt() {
        System.out.println("hutBuilt  onNewSuqareGameState");
    }
}

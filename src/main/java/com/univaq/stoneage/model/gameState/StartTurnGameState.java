package com.univaq.stoneage.model.gameState;

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
    public void gotResource() {
        System.out.println("gotResource   StartTurnGameState");
    }

    @Override
    public void hutTokenCheckDone() {
        System.out.println(" hutTokenCheckDone     StartTurnGameState");
    }

    @Override
    public void winner() {
        System.out.println("winner   StartGameState");
        //facciomogli fare quello che deve fare e poi cambiamo lo stato
        this.gameState.changeState(new EndGameState(this.gameState));
    }

    @Override
    public void onNewSquare() {
        System.out.println("onNewSquare   StartGameState");
        this.gameState.changeState(new OnNewSquareGameState(this.gameState));
    }

    @Override
    public void hutBuilt() {
        System.out.println("hutBuilt   StartGameState");
    }
}

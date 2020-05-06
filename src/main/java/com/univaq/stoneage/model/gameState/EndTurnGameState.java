package com.univaq.stoneage.model.gameState;

public class EndTurnGameState implements IGameState {

    private final GameState gameState;

    public EndTurnGameState(GameState gameState) {
        this.gameState = gameState;
        System.out.println("endTurnGameState create");
    }

    @Override
    public void nextTurn() {
        // we are in EndTurn state and the event called is nextTurn
        System.out.println(" nextTurn endTurnGameState");
        //facciomogli fare quello che deve fare e poi cambiamo lo stato
        this.gameState.changeState(new StartTurnGameState(this.gameState));
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
        System.out.println("EndTurnGameState");
    }
}

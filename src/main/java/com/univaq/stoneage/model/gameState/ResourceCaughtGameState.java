package com.univaq.stoneage.model.gameState;

public class ResourceCaughtGameState implements IGameState {

    private final GameState gameState;

    public ResourceCaughtGameState(GameState gameState) {
        this.gameState = gameState;
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
        System.out.println("resourceCaught");
    }
}

package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.MStoneAgeGame;

public class BuildingHutGameState implements IGameState {
    private final GameState gameState;

    public BuildingHutGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void nextTurn() {
        System.out.println("nextTurn   BuildignHutGameState");
    }

    @Override
    public void gotResource() {
        System.out.println(" gotResource   BuildignHutGameState");
    }

    @Override
    public void hutTokenCheckDone() {
        System.out.println("hutTokenCheckDone   onBuildingHut");
    }

    @Override
    public void winner() {
        System.out.println("winner   onBuildingHut");
    }

    @Override
    public void onNewSquare() {
        System.out.println("onNewSquare   onBuildingHut");
    }

    @Override
    public void hutBuilt() {
        System.out.println("hutBuilt   onBuildingHut");
        this.gameState.changeState(new EndTurnGameState(this.gameState));
        MStoneAgeGame.getInstance().getM_grid().forestTokenShuffle();
        MStoneAgeGame.getInstance().endTurnActions();
    }
}

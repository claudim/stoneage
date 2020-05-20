package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.MStoneAgeGame;

public class WaitingForPreyGameState implements IGameState {
    private final GameState gameState;

    public WaitingForPreyGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void waitForTokenForest() {
    }

    @Override
    public void initState() {
        this.steal();
    }

    @Override
    public void onNewSquare(int idForestToken) {
    }

    @Override
    public void nextTurn() {

    }

    @Override
    public void winner() {
    }


    @Override
    public void hutBuilt(int idHutToken) {

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
        MStoneAgeGame.getInstance().getActivePlayer().stealResource(playerName);
        this.gameState.changeState(new EndTurnGameState(this.gameState));
    }


    public void steal() {
        MStoneAgeGame.getInstance().getActivePlayer().stealResource();
    }

}

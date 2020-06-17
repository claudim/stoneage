package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;

public class StartTurnGameState implements IGameState {

    private final GameState gameState;

    public StartTurnGameState(GameState gameState) {
        this.gameState = gameState;

    }

    @Override
    public void nextTurn() {

    }

    @Override
    public void winner() {

    }

    @Override
    public void takeAnotherTurn() {
    }

    @Override
    public void onNewSquare(int idForestToken) {

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
    public void stealResource(MPlayer player) {

    }

    @Override
    public void waitForTokenForest() {
        this.gameState.changeState(new WaitingForTokenForest(this.gameState));
    }

    @Override
    public void initState() {
        MPlayer activePlayer = MStoneAgeGame.getInstance().getActivePlayer();
        activePlayer.executeOnStartTurnAbility();
        activePlayer.playTurn();
    }
}

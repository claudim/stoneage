package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;

public class WaitingForHutTokenGameState implements IGameState {

    private final GameState gameState;

    public WaitingForHutTokenGameState(GameState gameState) {
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
        MStoneAgeGame.getInstance().getActivePlayer().buildHut(idHutToken);
        MStoneAgeGame.getInstance().getM_grid().forestTokenShuffle();
        this.gameState.changeState(new EndTurnGameState(this.gameState));
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

    }

    @Override
    public void initState() {
        this.builtHut();
    }

    public void builtHut() {
        int idHutToken = MStoneAgeGame.getInstance().getActivePlayer().chooseIdHutToken();
        MStoneAgeGame.getInstance().buildHut(idHutToken);
    }
}


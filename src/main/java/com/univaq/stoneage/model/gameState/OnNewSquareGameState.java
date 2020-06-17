package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.ActionResult;
import com.univaq.stoneage.model.squares.MSquare;

public class OnNewSquareGameState implements IGameState {

    private final GameState gameState;
    public OnNewSquareGameState(GameState gameState) {
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
        MPlayer activePlayer = MStoneAgeGame.getInstance().getActivePlayer();
        MSquare newSquare = activePlayer.getM_marker().getCurrentSquare();
        activePlayer.executeOnSquareAbility(); // esegui l'abilità del player se ne ha una
        ActionResult actionResult = newSquare.doAction(activePlayer);
        IStateFactory gameStateFactory = gameState.getGameStateFactory();
        gameState.changeState(gameStateFactory.createState(actionResult, gameState));
        gameState.initState();
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

    }
}

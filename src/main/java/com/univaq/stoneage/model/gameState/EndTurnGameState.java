package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;

public class EndTurnGameState implements IGameState {

    private final GameState gameState;

    public EndTurnGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void nextTurn() {
        // we are in EndTurn state and the event called is nextTurn
        //facciomogli fare quello che deve fare e poi cambiamo lo stato
        MStoneAgeGame.getInstance().setNextPlayerAsActivePlayer(); // activePlayer = getNextPlayer();
        this.gameState.changeState(new StartTurnGameState(this.gameState));
        // MStoneAgeGame.getInstance().getCurrentPlayer().playTurn();
    }

    @Override
    public void winner() {
        //facciomogli fare quello che deve fare e poi cambiamo lo stato
        this.gameState.changeState(new EndGameState(this.gameState));
    }

    @Override
    public void takeAnotherTurn() {
        this.gameState.changeState(new StartTurnGameState(this.gameState));
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
//        // checking for the victory
//        MPlayer activePlayer = MStoneAgeGame.getInstance().getActivePlayer();
//        if (activePlayer.isM_winner()) {
//            gameState.winner();
//            // visualizza vittoria
//        } else {
//            // next player play his turn
//            gameState.nextTurn();
//        }
    }

    @Override
    public void stealResource(String playerName) {

    }

    @Override
    public void waitForTokenForest() {

    }

    @Override
    public void initState() {
        MPlayer activePlayer = MStoneAgeGame.getInstance().getActivePlayer();
        activePlayer.executeOnEndTurnAbility();
    }
}

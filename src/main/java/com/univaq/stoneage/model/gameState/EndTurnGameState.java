package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.MStoneAgeGame;

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
        MStoneAgeGame.getInstance().setActivePlayer(); // activePlayer = getNextPlayer();
        this.gameState.changeState(new StartTurnGameState(this.gameState));
    }

    @Override
    public void winner() {
        //facciomogli fare quello che deve fare e poi cambiamo lo stato
        this.gameState.changeState(new EndGameState(this.gameState));
    }

    @Override
    public void onNewSquare(int idForestToken) {

    }

    @Override
    public void hutBuilt(int idHutToken) {
        System.out.println("EndTurnGameState");
    }

    @Override
    public void initialize() {

    }

    @Override
    public void doSquareAction() {

    }

    @Override
    public void endAction() {
        // MStoneAgeGame.getInstance().endTurnActions();
        // checking for the victory
        if (MStoneAgeGame.getInstance().getCurrentPlayer().isM_winner()) {
            gameState.winner();
            // visualizza vittoria
        } else {
            // next player play his turn
            gameState.nextTurn();
            //nextPlayerTurn();
        }
    }

    @Override
    public void stealResource(String playerName) {

    }
}

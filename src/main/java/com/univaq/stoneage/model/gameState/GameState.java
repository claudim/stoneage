package com.univaq.stoneage.model.gameState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class is responsible for setting the state and getting what state we are in
 */
public class GameState {
    private IGameState gameState;
    private boolean waitingForEvent;
    private PropertyChangeSupport support; // to implement the observer pattern

    public GameState() {
        // startGameState is the default game state
        this.gameState = new StartGameState(this);
        waitingForEvent = false;
        support = new PropertyChangeSupport(this);
    }

    public GameState(IGameState gameState) {
        this.gameState = gameState;
    }

    public IGameState getGameState() {
        return gameState;
    }

    public void setGameState(IGameState gameState) {
        this.gameState = gameState;
    }

    public void changeState(IGameState gameState) {
        notifyPropertyChangeListener("changeState", this.gameState, gameState);
        this.gameState = gameState;

    }

    // every method delegate IGameState to handle the method
    public void nextTurn() {
        //delegates to IGameState
        this.gameState.nextTurn();

    }

    public void winner() {
        this.gameState.winner();
    }

    public void playTurn(int idForestToken) {
        this.gameState.onNewSquare(idForestToken);
        while (!this.gameState.getClass().getSimpleName().equals(EndTurnGameState.class.getSimpleName()) && !waitingForEvent) {
            this.gameState.doSquareAction();
        }
        this.gameState.endAction();

    }

    public void hutBuilt(int idHutToken) {
        this.gameState.hutBuilt(idHutToken);
        this.waitingForEvent = false;
        this.gameState.endAction();
    }

    public void stealResource(String playerName) {
        this.gameState.stealResource(playerName);
        this.waitingForEvent = false;
        this.gameState.endAction();
    }

    public void initialize() {
        this.gameState.initialize();
    }

    public boolean isWaitingForEvent() {
        return waitingForEvent;
    }

    public void setWaitingForEvent(boolean waitingForEvent) {
        this.waitingForEvent = waitingForEvent;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void notifyPropertyChangeListener(String propertyName, Object oldValue, Object newValue) {
        support.firePropertyChange(propertyName, oldValue, newValue);
    }


}

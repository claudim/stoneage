package com.univaq.stoneage.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * Abstract Strategy class to identify the correct playing order of the players
 */
public abstract class MNextPlayerStrategy implements MINextPlayerStrategy {
    protected ArrayList<MPlayer> sortedPlayer;
    protected MPlayer currentPlayer;
    protected PropertyChangeSupport support; // to implement the observer pattern

    public MNextPlayerStrategy(ArrayList<MPlayer> players) {
        this.sortedPlayer = players;
        this.currentPlayer = null;
        this.support = new PropertyChangeSupport(this);
    }

    public ArrayList<MPlayer> getSortedPlayer() {
        return sortedPlayer;
    }

    public void setSortedPlayer(ArrayList<MPlayer> sortedPlayer) {
        this.sortedPlayer = sortedPlayer;
    }

    /**
     * Sort players according to the strategy implementation
     */
    protected abstract void sort();

    /**
     * Return the Player playing current turn
     *
     * @return current player
     */
    public abstract MPlayer getCurrentPlayer();

    /**
     * Return the next player according to the implemented strategy
     *
     * @return Next player to play
     */
    public abstract MPlayer getNextPlayer();

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setCurrentPlayer(MPlayer player) {
        this.notifyPropertyChange(player);
        this.currentPlayer = player;
    }

    public void notifyPropertyChange(MPlayer currentPlayer) {
        if (currentPlayer != null && this.currentPlayer != null)
            support.firePropertyChange("currentPlayer", this.currentPlayer.getMarkerName(), currentPlayer.getMarkerName());
        else if (currentPlayer != null)
            support.firePropertyChange("currentPlayer", "", currentPlayer.getMarkerName());


    }
}

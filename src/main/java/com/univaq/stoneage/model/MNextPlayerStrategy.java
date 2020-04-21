package com.univaq.stoneage.model;

import java.util.ArrayList;

/**
 * Abstract Strategy class to identify the correct playing order of the players
 */
public abstract class MNextPlayerStrategy implements MINextPlayerStrategy {
    private ArrayList<MPlayer> sortedPlayer;

    public MNextPlayerStrategy(ArrayList<MPlayer> players) {
        this.sortedPlayer = players;
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


}

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

    public abstract void sort();

    public abstract MPlayer getCurrentPlayer();

    public abstract MPlayer getNextPlayer();


}

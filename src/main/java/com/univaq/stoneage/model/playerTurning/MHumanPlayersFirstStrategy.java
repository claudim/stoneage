package com.univaq.stoneage.model.playerTurning;

import com.univaq.stoneage.model.players.MPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Implementation of strategy for choosing next player. With this strategy the human players take precedence over emulated ones.
 * Players are ordered by their type, human players first.
 */
public class MHumanPlayersFirstStrategy implements INextPlayerStrategy {
    private int indexOfCurrentPlayer;
    private int numberOfPlayer;

    /**
     * Constructor.
     *
     * @param numberOfPlayer The number of the players.
     */
    public MHumanPlayersFirstStrategy(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
        indexOfCurrentPlayer = 0;
    }

    public MHumanPlayersFirstStrategy() {
        this.numberOfPlayer = 0;
        indexOfCurrentPlayer = 0;
    }

    /**
     * Get the index of the active player.
     *
     * @return The active player index
     */
    @Override
    public int getIndexActivePlayer() {
        return this.indexOfCurrentPlayer;
    }

    /**
     * Get the index of the next active player.
     *
     * @return The next active player index
     */
    @Override
    public int getIndexNextPlayer() {
        indexOfCurrentPlayer = (indexOfCurrentPlayer + 1) % (numberOfPlayer);
        return indexOfCurrentPlayer;
    }

    /**
     * Sort the players. Players are ordered by their type, human players first.
     *
     * @param players The players to sort
     * @return The sorted players
     */
    @Override
    public ArrayList<MPlayer> sortPlayers(ArrayList<MPlayer> players) {
        Collections.sort(players, new Comparator<MPlayer>() {
            @Override
            public int compare(MPlayer mPlayer, MPlayer t1) {
                return t1.getClass().getSimpleName().compareTo(mPlayer.getClass().getSimpleName());
            }
        });
        return players;
    }

    /**
     * Set the number of players.
     *
     * @param numberOfPlayer the number of players
     */
    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }
}

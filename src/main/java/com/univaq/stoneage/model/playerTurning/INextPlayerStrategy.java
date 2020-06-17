package com.univaq.stoneage.model.playerTurning;

import com.univaq.stoneage.model.players.MPlayer;

import java.util.ArrayList;

/**
 * Define a common interface to manage the choice of the next player.
 */
public interface INextPlayerStrategy {
    /**
     * Get the index of the active player.
     *
     * @return The active player index
     */
    int getIndexActivePlayer();

    /**
     * Get the index of the next active player.
     *
     * @return The next active player index
     */
    int getIndexNextPlayer();

    /**
     * Sort the players.
     *
     * @param players The players to sort
     * @return The sorted players
     */
    ArrayList<MPlayer> sortPlayers(ArrayList<MPlayer> players);

    /**
     * Set the number of players.
     *
     * @param numberOfPlayer the number of players
     */
    void setNumberOfPlayer(int numberOfPlayer);

}

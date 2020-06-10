package com.univaq.stoneage.model.playerTurning;

import com.univaq.stoneage.model.players.MPlayer;

import java.util.ArrayList;

/**
 * Define a common interface to manage the choice of the next player
 */
public interface INextPlayerStrategy {
    int getIndexActivePlayer();

    int getIndexNextPlayer();

    ArrayList<MPlayer> sortPlayers(ArrayList<MPlayer> players);

}

package com.univaq.stoneage.model.players.playerTurning;

import com.univaq.stoneage.model.players.MPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Implementation of strategy for choosing next player. With this strategy the human players take precedence over emulated ones.
 * Players are ordered by their type, human players first.
 */
public class MHumanPlayersFirstStrategy extends MNextPlayerStrategy {
    private int indexOfCurrentPlayer;
    private final int numberOfPlayer;

    public MHumanPlayersFirstStrategy(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
        indexOfCurrentPlayer = 0;
   }

    @Override
    public int getIndexActivePlayer() {
        return this.indexOfCurrentPlayer;
    }

    @Override
    public int getIndexNextPlayer() {
        indexOfCurrentPlayer = (indexOfCurrentPlayer + 1) % (numberOfPlayer);
        return indexOfCurrentPlayer;
    }

    @Override
    public ArrayList<MPlayer> sortPlayers(ArrayList<MPlayer> players) {
        int j = 0;
        Collections.sort(players, new Comparator<MPlayer>() {
            @Override
            public int compare(MPlayer mPlayer, MPlayer t1) {
                return t1.getClass().getSimpleName().compareTo(mPlayer.getClass().getSimpleName());
            }
        });
        return players;
    }


}

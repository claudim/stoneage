package com.univaq.stoneage.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MANextPlayerStrategy extends MNextPlayerStrategy {
    private int indexOfCurrentPlayer;

    public MANextPlayerStrategy(ArrayList<MPlayer> a_players) {
        super(a_players);
        this.sort();
        this.indexOfCurrentPlayer = 0;
    }

    public void setIndexOfCurrentPlayer(int indexOfCurrentPlayer) {
        this.indexOfCurrentPlayer = indexOfCurrentPlayer % (this.getSortedPlayer().size());
    }

    @Override
    public MPlayer getCurrentPlayer() {
        return this.getSortedPlayer().get(this.indexOfCurrentPlayer);
    }

    @Override
    public MPlayer getNextPlayer() {
        this.setIndexOfCurrentPlayer(this.indexOfCurrentPlayer + 1);
        return this.getCurrentPlayer();
    }

    @Override
    public void sort() {
        ArrayList<MPlayer> players = this.getSortedPlayer();
        int j = 0;
        Collections.sort(players, new Comparator<MPlayer>() {
            @Override
            public int compare(MPlayer mPlayer, MPlayer t1) {
                return t1.getClass().getSimpleName().compareTo(mPlayer.getClass().getSimpleName());
            }
        });
        this.setSortedPlayer(players);
        //MStoneAgeGame.getInstance().setM_players(players);
    }


}

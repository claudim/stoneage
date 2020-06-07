package com.univaq.stoneage.model;

import com.univaq.stoneage.model.players.MPlayer;

public interface IGameGoalStrategy {
    boolean isWinner(MPlayer player);
}

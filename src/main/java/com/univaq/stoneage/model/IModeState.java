package com.univaq.stoneage.model;

import com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing.MINextForestTokenStrategy;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.players.playerTurning.MINextPlayerStrategy;
import com.univaq.stoneage.model.shuffle.IShuffleStrategy;

public interface IModeState {

    IGameGoalStrategy getGameGoalStrategy();

    MINextPlayerStrategy getNextPlayerStrategy(int aNumPlayers);

    ISquareFactory getSquareFactory();

    ITokenForestFactory getForestTokenFactory();

    IShuffleStrategy getShuffleStrategy();

    MINextForestTokenStrategy getNextForestTokenStrategy();
}

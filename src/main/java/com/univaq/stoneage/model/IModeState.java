package com.univaq.stoneage.model;

import com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing.MINextForestTokenStrategy;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.hutTokens.nextHutTokenChoosing.MINextHutTokenStrategy;
import com.univaq.stoneage.model.nextId.IGetNextIdStrategy;
import com.univaq.stoneage.model.players.playerTurning.MINextPlayerStrategy;
import com.univaq.stoneage.model.shuffle.IShuffleStrategy;
import com.univaq.stoneage.model.squares.resourceSquareState.squareStateFactory.ISquareStateFactory;
import com.univaq.stoneage.model.squares.squareSetup.MISetupSquareStrategyFactory;

public interface IModeState {

    IGameGoalStrategy getGameGoalStrategy();

    MINextPlayerStrategy getNextPlayerStrategy(int aNumPlayers);

    ISquareFactory getSquareFactory();

    ITokenForestFactory getForestTokenFactory();

    IShuffleStrategy getShuffleStrategy();

    MINextForestTokenStrategy getNextForestTokenStrategy();

    MINextHutTokenStrategy getNextHutIdStrategy();

    IGetNextIdStrategy getNextHutTokenIdToBuildStrategy();

    MISetupSquareStrategyFactory getSetupSquareStrategyFactory();

    ISquareStateFactory getSquareStateFactory();
}

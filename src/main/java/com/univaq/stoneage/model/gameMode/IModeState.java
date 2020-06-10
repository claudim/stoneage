package com.univaq.stoneage.model.gameMode;

import com.univaq.stoneage.model.forestTokens.forestTokenFactory.ITokenForestFactory;
import com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing.MINextForestTokenStrategy;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.hutTokens.nextHutTokenChoosing.MINextHutTokenStrategy;
import com.univaq.stoneage.model.nextId.IGetNextIdStrategy;
import com.univaq.stoneage.model.playerTurning.INextPlayerStrategy;
import com.univaq.stoneage.model.shuffle.IShuffleStrategy;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory.IResourceSquareStateFactory;
import com.univaq.stoneage.model.squares.squareSetup.MISetupSquareStrategyFactory;
import com.univaq.stoneage.model.squares.squaresFactory.ISquareFactory;

public interface IModeState {

    IGameGoalStrategy getGameGoalStrategy();

    INextPlayerStrategy getNextPlayerStrategy(int aNumPlayers);

    ISquareFactory getSquareFactory();

    ITokenForestFactory getForestTokenFactory();

    IShuffleStrategy getShuffleStrategy();

    MINextForestTokenStrategy getNextForestTokenStrategy();

    MINextHutTokenStrategy getNextHutIdStrategy();

    IGetNextIdStrategy getNextHutTokenIdToBuildStrategy();

    MISetupSquareStrategyFactory getSetupSquareStrategyFactory();

    IResourceSquareStateFactory getSquareStateFactory();
}

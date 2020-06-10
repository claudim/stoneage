package com.univaq.stoneage.model.gameMode;

import com.univaq.stoneage.model.forestTokens.forestTokenFactory.GreenTokenForestFactory;
import com.univaq.stoneage.model.forestTokens.forestTokenFactory.ITokenForestFactory;
import com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing.MINextForestTokenStrategy;
import com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing.MRandomNextForestTokenStrategy;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.gameGoal.ThreeHutTokenGoalStrategy;
import com.univaq.stoneage.model.hutTokens.nextHutTokenChoosing.MINextHutTokenStrategy;
import com.univaq.stoneage.model.hutTokens.nextHutTokenChoosing.MRandomNextHutTokenStrategy;
import com.univaq.stoneage.model.nextId.GetFirstIdStrategy;
import com.univaq.stoneage.model.nextId.IGetNextIdStrategy;
import com.univaq.stoneage.model.playerTurning.INextPlayerStrategy;
import com.univaq.stoneage.model.playerTurning.MHumanPlayersFirstStrategy;
import com.univaq.stoneage.model.shuffle.IShuffleStrategy;
import com.univaq.stoneage.model.shuffle.NoShuffleStrategy;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory.GreenResourceSquareStateFactory;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory.IResourceSquareStateFactory;
import com.univaq.stoneage.model.squares.squareSetup.MISetupSquareStrategyFactory;
import com.univaq.stoneage.model.squares.squareSetup.MSetupResourceSquareStrategyFactory;
import com.univaq.stoneage.model.squares.squaresFactory.GreenSquareFactory;
import com.univaq.stoneage.model.squares.squaresFactory.ISquareFactory;

public class GreenModeState implements IModeState {
    @Override
    public IGameGoalStrategy getGameGoalStrategy() {
        return new ThreeHutTokenGoalStrategy();
    }

    @Override
    public INextPlayerStrategy getNextPlayerStrategy(int aNumPlayers) {
        return new MHumanPlayersFirstStrategy(aNumPlayers);
    }

    @Override
    public ISquareFactory getSquareFactory() {
        return new GreenSquareFactory();
    }

    @Override
    public ITokenForestFactory getForestTokenFactory() {
        return new GreenTokenForestFactory();
    }

    @Override
    public IShuffleStrategy getShuffleStrategy() {
        return new NoShuffleStrategy();
    }

    @Override
    public MINextForestTokenStrategy getNextForestTokenStrategy() {
        return new MRandomNextForestTokenStrategy();
    }

    @Override
    public MINextHutTokenStrategy getNextHutIdStrategy() {
        return new MRandomNextHutTokenStrategy();
    }

    @Override
    public IGetNextIdStrategy getNextHutTokenIdToBuildStrategy() {
        return new GetFirstIdStrategy();
    }

    @Override
    public MISetupSquareStrategyFactory getSetupSquareStrategyFactory() {
        return new MSetupResourceSquareStrategyFactory();
    }

    @Override
    public IResourceSquareStateFactory getSquareStateFactory() {
        return new GreenResourceSquareStateFactory();
    }

}

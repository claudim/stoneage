package com.univaq.stoneage.model;

import com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing.MINextForestTokenStrategy;
import com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing.MRandomNextForestTokenStrategy;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.gameGoal.ThreeHutTokenGoalStrategy;
import com.univaq.stoneage.model.hutTokens.nextHutTokenChoosing.MINextHutTokenStrategy;
import com.univaq.stoneage.model.hutTokens.nextHutTokenChoosing.MRandomNextHutTokenStrategy;
import com.univaq.stoneage.model.nextId.IGetNextIdStrategy;
import com.univaq.stoneage.model.nextId.MinNumberStrategy;
import com.univaq.stoneage.model.players.playerTurning.MHumanPlayersFirstStrategy;
import com.univaq.stoneage.model.players.playerTurning.MINextPlayerStrategy;
import com.univaq.stoneage.model.shuffle.CollectionsShuffleStrategy;
import com.univaq.stoneage.model.shuffle.IShuffleStrategy;
import com.univaq.stoneage.model.squares.resourceSquareState.squareStateFactory.ISquareStateFactory;
import com.univaq.stoneage.model.squares.squareSetup.MISetupSquareStrategyFactory;
import com.univaq.stoneage.model.squares.squareSetup.MSetupResourceSquareStrategyFactory;

public class GreenModeState implements IModeState {
    @Override
    public IGameGoalStrategy getGameGoalStrategy() {
        return new ThreeHutTokenGoalStrategy();
    }

    @Override
    public MINextPlayerStrategy getNextPlayerStrategy(int aNumPlayers) {
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
        return new CollectionsShuffleStrategy();
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
        return new MinNumberStrategy();
    }

    @Override
    public MISetupSquareStrategyFactory getSetupSquareStrategyFactory() {
        return new MSetupResourceSquareStrategyFactory();
    }

    @Override
    public ISquareStateFactory getSquareStateFactory() {
        return new GreenSquareStateFactory();
    }

}

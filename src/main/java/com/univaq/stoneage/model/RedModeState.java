package com.univaq.stoneage.model;

import com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing.MINextForestTokenStrategy;
import com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing.MRandomNextForestTokenStrategy;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.gameGoal.ThreeHutTokenGoalStrategy;
import com.univaq.stoneage.model.players.playerTurning.MHumanPlayersFirstStrategy;
import com.univaq.stoneage.model.players.playerTurning.MINextPlayerStrategy;
import com.univaq.stoneage.model.shuffle.CollectionsShuffleStrategy;
import com.univaq.stoneage.model.shuffle.IShuffleStrategy;

public class RedModeState implements IModeState {
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
        return new RedSquareFactory();
    }

    @Override
    public ITokenForestFactory getForestTokenFactory() {
        return new RedTokenForestFactory();
    }

    @Override
    public IShuffleStrategy getShuffleStrategy() {
        return new CollectionsShuffleStrategy();
    }

    @Override
    public MINextForestTokenStrategy getNextForestTokenStrategy() {
        return new MRandomNextForestTokenStrategy();
    }
}

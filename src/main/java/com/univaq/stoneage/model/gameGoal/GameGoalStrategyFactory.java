package com.univaq.stoneage.model.gameGoal;

import com.univaq.stoneage.model.gameMode.GameMode;

/**
 * Concrete factory to create the right game goal strategy.
 */
public class GameGoalStrategyFactory implements IGameGoalStrategyFactory {

    /**
     * Create the right game goal strategy
     *
     * @return the right game goal strategy
     */
    @Override
    public IGameGoalStrategy createGameGoalStrategy() {

        return new ThreeHutTokenGoalStrategy();
    }

    @Override
    public IGameGoalStrategy createGameGoalStrategy(GameMode mode) {

        return null;
    }
}

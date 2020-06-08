package com.univaq.stoneage.model.gameGoal;

import com.univaq.stoneage.model.GameMode;

/**
 * Interface factory to create the right game goal strategy.
 */
public interface IGameGoalStrategyFactory {

    /**
     * Create the right game goal strategy
     *
     * @return the right game goal strategy
     */
    IGameGoalStrategy createGameGoalStrategy();

    IGameGoalStrategy createGameGoalStrategy(GameMode mode);
}

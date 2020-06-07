package com.univaq.stoneage.model;

public class GameGoalStrategyFactory implements IGameGoalStrategyFactory {
    @Override
    public IGameGoalStrategy createGameGoalStrategy() {
        return new ThreeHutTokenGoalStrategy();
    }
}

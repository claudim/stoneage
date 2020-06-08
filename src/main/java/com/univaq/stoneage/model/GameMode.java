package com.univaq.stoneage.model;

import com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing.MINextForestTokenStrategy;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.hutTokens.nextHutTokenChoosing.MINextHutTokenStrategy;
import com.univaq.stoneage.model.nextId.IGetNextIdStrategy;
import com.univaq.stoneage.model.players.playerTurning.MINextPlayerStrategy;
import com.univaq.stoneage.model.shuffle.IShuffleStrategy;
import com.univaq.stoneage.model.squares.resourceSquareState.squareStateFactory.ISquareStateFactory;
import com.univaq.stoneage.model.squares.squareSetup.MISetupSquareStrategyFactory;

public class GameMode {
    private IModeState modeState;

    public GameMode(IModeState modeState) {
        this.modeState = modeState;
    }

    public GameMode(String nameMode) {
        if (nameMode.equals("Verde") || nameMode.equals("Green")) {
            this.modeState = new GreenModeState();
        } else {
            this.modeState = new RedModeState();
        }
    }

    public IModeState getModeState() {
        return modeState;
    }

    public void setModeState(IModeState modeState) {
        this.modeState = modeState;
    }

    public IGameGoalStrategy getGameGoalStrategy() {
        return modeState.getGameGoalStrategy();
    }

    public MINextPlayerStrategy getNextPlayerStrategy(int aNumPlayers) {
        return modeState.getNextPlayerStrategy(aNumPlayers);
    }

    public ISquareFactory getSquareFactory() {
        return modeState.getSquareFactory();
    }

    public ITokenForestFactory getForestTokenFactory() {
        return modeState.getForestTokenFactory();
    }

    public IShuffleStrategy getShuffleStrategy() {
        return modeState.getShuffleStrategy();
    }

    public MINextForestTokenStrategy getNextForestTokenStrategy() {
        return modeState.getNextForestTokenStrategy();
    }

    public MINextHutTokenStrategy getNextHutIdStrategy() {
        return modeState.getNextHutIdStrategy();
    }

    public IGetNextIdStrategy getNextHutTokenIdToBuildStrategy() {
        return modeState.getNextHutTokenIdToBuildStrategy();
    }

    public MISetupSquareStrategyFactory getSetupSquareStrategyFactory() {
        return modeState.getSetupSquareStrategyFactory();
    }

    public ISquareStateFactory getSquareStateFactory() {
        return modeState.getSquareStateFactory();
    }
}

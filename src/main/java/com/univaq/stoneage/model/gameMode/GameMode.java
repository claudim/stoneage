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

/**
 * It is responsible to change the game mode.
 * Provide behaviours for any game element deriving from the game mode.
 */
public class GameMode {
    /**
     * The current game mode
     */
    private IModeState modeState;

    /**
     * Constructor.
     *
     * @param modeState The current game mode
     */
    public GameMode(IModeState modeState) {
        this.modeState = modeState;
    }

    /**
     * Constructor.
     *
     * @param nameMode The game mode name
     */
    public GameMode(String nameMode) {
        if (nameMode.equals("Verde") || nameMode.equals("Green")) {
            this.modeState = new GreenModeState(this);
        } else {
            this.modeState = new RedModeState(this);
        }
    }

    /**
     * Get the current game mode.
     *
     * @return the current game mode
     */
    public IModeState getModeState() {
        return modeState;
    }

    /**
     * Set the current game mode.
     *
     * @param modeState the current game mode
     */
    public void setModeState(IModeState modeState) {
        this.modeState = modeState;
    }

    /**
     * Delegate the current mode to get the strategy to get the game goal.
     *
     * @return The strategy
     */
    public IGameGoalStrategy getGameGoalStrategy() {
        return modeState.getGameGoalStrategy();
    }

    /**
     * Delegate the current mode to get the strategy for sorting the game players and get the next player.
     *
     * @param aNumPlayers The players number
     * @return The strategy
     */
    public INextPlayerStrategy getNextPlayerStrategy(int aNumPlayers) {
        return modeState.getNextPlayerStrategy(aNumPlayers);
    }

    /**
     * Delegate the current mode to get the square factory.
     *
     * @return The square factory according to the currend game mode
     */
    public ISquareFactory getSquareFactory() {
        return modeState.getSquareFactory();
    }

    /**
     * Delegate the current mode to get the factory for the creation of the forest tokens according to the current game mode.
     *
     * @return The forest token factory
     */
    public ITokenForestFactory getForestTokenFactory() {
        return modeState.getForestTokenFactory();
    }

    /**
     * Delegate the current mode to get the strategy to shuffle according to the current game mode.
     *
     * @return the strategy to shuffle
     */
    public IShuffleStrategy getShuffleStrategy() {
        return modeState.getShuffleStrategy();
    }

    /**
     * Delegate the current mode to get the strategy to choose a next forest token according to the current game mode.
     *
     * @return The strategy to get the next forest token id
     */
    public MINextForestTokenStrategy getNextForestTokenStrategy() {
        return modeState.getNextForestTokenStrategy();
    }

    /**
     * Delegate the current mode to get the strategy to choose a next hut token according to the current game mode.
     *
     * @return The strategy to get the next hut token id
     */
    public MINextHutTokenStrategy getNextHutIdStrategy() {
        return modeState.getNextHutIdStrategy();
    }

    /**
     * Delegate the current mode to get the strategy to choose a next hut token to face up according to the current game mode.
     *
     * @return The strategy to get the next hut token id to face up
     */
    public IGetNextIdStrategy getNextHutTokenIdToFaceUpStrategy() {
        return modeState.getNextHutTokenIdToFaceUpStrategy();
    }

    /**
     * Delegate the current mode to get the factory for the creation of the right strategy for the square setup according to the current game mode.
     *
     * @return the setup square startegy factory
     */
    public MISetupSquareStrategyFactory getSetupSquareStrategyFactory() {
        return modeState.getSetupSquareStrategyFactory();
    }

    /**
     * Delegate the current mode to get the resource square state factory according to the current game mode.
     *
     * @return the resource square state factory.
     */
    public IResourceSquareStateFactory getSquareStateFactory() {
        return modeState.getSquareStateFactory();
    }
}

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

/**
 * Implement the behavior associated with green mode.
 * It is a concrete state (STATE PATTERN).
 */
public class GreenModeState implements IModeState {

    /**
     * Reference to the context game mode.
     */
    private final GameMode mode;

    /**
     * Constructor.
     *
     * @param mode The game mode
     */
    public GreenModeState(GameMode mode) {
        this.mode = mode;
    }

    /**
     * Get the green mode strategy to get the game goal.
     *
     * @return The goal game strategy
     */
    @Override
    public IGameGoalStrategy getGameGoalStrategy() {
        return new ThreeHutTokenGoalStrategy();
    }

    /**
     * Get the green mode strategy for sorting the game players and get the next player.
     *
     * @param aNumPlayers The players number
     * @return The strategy
     */
    @Override
    public INextPlayerStrategy getNextPlayerStrategy(int aNumPlayers) {
        return new MHumanPlayersFirstStrategy(aNumPlayers);
    }

    /**
     * Get the green square factory.
     *
     * @return The square factory
     */
    @Override
    public ISquareFactory getSquareFactory() {
        return new GreenSquareFactory(mode);
    }

    /**
     * Get the green mode factory for the creation of the forest tokens.
     *
     * @return The forest token factory
     */
    @Override
    public ITokenForestFactory getForestTokenFactory() {
        return new GreenTokenForestFactory();
    }

    /**
     * Get the green mode strategy to shuffle.
     *
     * @return the strategy to shuffle
     */
    @Override
    public IShuffleStrategy getShuffleStrategy() {
        return new NoShuffleStrategy();
    }

    /**
     * Get the green mode strategy to choose a next forest token.
     *
     * @return The strategy to get the next forest token id
     */
    @Override
    public MINextForestTokenStrategy getNextForestTokenStrategy() {
        return new MRandomNextForestTokenStrategy();
    }

    /**
     * Get the green mode strategy to choose a next hut token.
     *
     * @return The strategy to get the next hut token id
     */
    @Override
    public MINextHutTokenStrategy getNextHutIdStrategy() {
        return new MRandomNextHutTokenStrategy();
    }

    /**
     * Get the green mode strategy to choose a next hut token to face up.
     *
     * @return The strategy to get the next hut token id to face up
     */
    @Override
    public IGetNextIdStrategy getNextHutTokenIdToFaceUpStrategy() {
        return new GetFirstIdStrategy();
    }

    /**
     * Get the green mode factory for the creation of the right strategy for the square setup.
     *
     * @return the setup square startegy factory
     */
    @Override
    public MISetupSquareStrategyFactory getSetupSquareStrategyFactory() {
        return new MSetupResourceSquareStrategyFactory();
    }

    /**
     * Get the resource square state factory for the green mode.
     *
     * @return the resource square state factory.
     */
    @Override
    public IResourceSquareStateFactory getSquareStateFactory() {
        return new GreenResourceSquareStateFactory();
    }

}

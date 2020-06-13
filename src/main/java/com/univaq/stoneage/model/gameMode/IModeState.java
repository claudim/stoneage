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
 * Define a common interface for any concrete mode.
 * Encapsulate the behavior associated with each mode.
 */
public interface IModeState {

    /**
     * Get the strategy to get the game goal.
     *
     * @return The goal game strategy
     */
    IGameGoalStrategy getGameGoalStrategy();

    /**
     * Get the strategy for sorting the game players and get the next player.
     *
     * @param aNumPlayers The players number
     * @return The strategy
     */
    INextPlayerStrategy getNextPlayerStrategy(int aNumPlayers);

    /**
     * Get the square factory.
     *
     * @return The square factory according to the current game mode
     */
    ISquareFactory getSquareFactory();

    /**
     * Get the factory for the creation of the forest tokens according to the current game mode.
     *
     * @return The forest token factory
     */
    ITokenForestFactory getForestTokenFactory();

    /**
     * Get the strategy to shuffle according to the current game mode.
     *
     * @return the strategy to shuffle
     */
    IShuffleStrategy getShuffleStrategy();

    /**
     * Get the strategy to choose a next forest token according to the current game mode.
     *
     * @return The strategy to get the next forest token id
     */
    MINextForestTokenStrategy getNextForestTokenStrategy();

    /**
     * Get the strategy to choose a next hut token according to the current game mode.
     *
     * @return The strategy to get the next hut token id
     */
    MINextHutTokenStrategy getNextHutIdStrategy();

    /**
     * Get the strategy to choose a next hut token to face up according to the current game mode.
     *
     * @return The strategy to get the next hut token id to face up
     */
    IGetNextIdStrategy getNextHutTokenIdToFaceUpStrategy();

    /**
     * Get the factory for the creation of the right strategy for the square setup according to the current game mode.
     *
     * @return the setup square startegy factory
     */
    MISetupSquareStrategyFactory getSetupSquareStrategyFactory();

    /**
     * Get the resource square state factory according to the current game mode.
     *
     * @return the resource square state factory.
     */
    IResourceSquareStateFactory getSquareStateFactory();
}

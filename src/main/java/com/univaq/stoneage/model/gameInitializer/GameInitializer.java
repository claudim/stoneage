package com.univaq.stoneage.model.gameInitializer;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.forestTokens.grid.MGrid;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.gameState.GameState;
import com.univaq.stoneage.model.playerTurning.INextPlayerStrategy;
import com.univaq.stoneage.model.players.playerFactory.MPlayerFactory;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.board.MBoard;
import com.univaq.stoneage.utility.shuffle.IShuffleStrategyFactory;

import java.beans.PropertyChangeSupport;

/**
 * It is responsible for the game initialization,for the creation of the board, grid; for the creation of game goal and
 * turning strategy and manages the players creation.
 */
public abstract class GameInitializer {

    /**
     * Initialize the game.
     *
     * @param mStoneAgeGame The game
     * @param aNumPlayers   Number of players
     * @param aMarkerName   Human player's name
     */
    public void initializeStoneAgeGame(MStoneAgeGame mStoneAgeGame, int aNumPlayers, String aMarkerName) {
        //creates gamestate
        GameState gameState = makeGameState();
        mStoneAgeGame.setM_gameState(gameState);

        // create support to be observable
        mStoneAgeGame.setSupport(new PropertyChangeSupport(mStoneAgeGame));

        mStoneAgeGame.setNumPlayer(aNumPlayers);
        setPlayerNumber(aNumPlayers);

        // creates board and squares
        MBoard board = makeBoard();
        mStoneAgeGame.setM_board(board);

        MSquare startSquare = board.getStartSquare();

        //players
        MPlayerFactory mPlayerFactory = new MPlayerFactory();
        mPlayerFactory.createPlayers(aNumPlayers, aMarkerName);
        mPlayerFactory.setStartSquare(startSquare);

        // creates grid and forestTokens
        MGrid grid = makeGrid();

        IShuffleStrategyFactory shuffleStrategyFactory = makeShuffleStrategyFactory();
        grid.setM_shuffleStrategy(shuffleStrategyFactory.getShuffleStrategy(mStoneAgeGame.getNumPlayer()));
        mStoneAgeGame.setM_grid(grid);

        mStoneAgeGame.setM_gameGoalStrategy(makeGameGoalStrategy());

        INextPlayerStrategy nextPlayerStrategy = makeTurningStrategy();
        nextPlayerStrategy.setNumberOfPlayer(aNumPlayers);
        mStoneAgeGame.setM_nextPlayerStrategy(nextPlayerStrategy);

        // set the right strategy to identify the players order and set the players.
        mStoneAgeGame.setM_players(nextPlayerStrategy.sortPlayers(mPlayerFactory.getPlayers()));

        gameState.initialize();
    }

    /**
     * Initialize the appropriate board
     *
     * @return Game Board
     */
    abstract MBoard makeBoard();

    /**
     * Initialize the appropriate grid
     *
     * @return Token Forest grid
     */
    abstract MGrid makeGrid();

    /**
     * Initialize the appropriate game state
     *
     * @return The appropriate game state according to the mode
     */
    abstract GameState makeGameState();

    /**
     * Initialize the appropriate game goal strategy
     *
     * @return The appropriate game goal strategy according to the mode
     */
    abstract IGameGoalStrategy makeGameGoalStrategy();

    /**
     * Initialize the appropriate turning strategy
     *
     * @return The appropriate next player strategy according to the mode
     */
    abstract INextPlayerStrategy makeTurningStrategy();

    /**
     * Initialize the appropriate shuffle strategy factory
     *
     * @return The appropriate shuffle strategy factory according to the mode
     */
    abstract IShuffleStrategyFactory makeShuffleStrategyFactory();

    /**
     * Initialize the player number
     *
     * @param playerNumber number of players
     */
    abstract void setPlayerNumber(int playerNumber);
}

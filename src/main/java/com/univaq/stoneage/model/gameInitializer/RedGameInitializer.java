package com.univaq.stoneage.model.gameInitializer;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.forestTokens.grid.MGrid;
import com.univaq.stoneage.model.forestTokens.grid.MRedGrid;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.gameGoal.ThreeHutTokenGoalStrategy;
import com.univaq.stoneage.model.gameState.GameState;
import com.univaq.stoneage.model.playerTurning.INextPlayerStrategy;
import com.univaq.stoneage.model.playerTurning.MHumanPlayersFirstStrategy;
import com.univaq.stoneage.model.players.playerFactory.MPlayerFactory;
import com.univaq.stoneage.model.squares.MBoard;
import com.univaq.stoneage.model.squares.MRedBoard;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy.MResourceSquareRedSetupStrategy;
import com.univaq.stoneage.utility.shuffle.IShuffleStrategyFactory;
import com.univaq.stoneage.utility.shuffle.RedShuffleStrategyFactory;

import java.beans.PropertyChangeSupport;

/**
 * It is responsible for the red mode game initialization,for the creation of the board, grid; for the creation of game goal and
 * turning strategy and manages the players creation.
 */
public class RedGameInitializer implements IGameInitializer {

    /**
     * Initializes stone age game in red mode and it's elements.
     *
     * @param mStoneAgeGame The game
     * @param aNumPlayers   Number of players
     * @param aMarkerName   Human player's name
     */
    @Override
    public void initializeStoneAgeGame(MStoneAgeGame mStoneAgeGame, int aNumPlayers, String aMarkerName) {
        //creates gamestate
        GameState gameState = makeGameState();
        mStoneAgeGame.setM_gameState(gameState);

        // create support to be observable
        mStoneAgeGame.setSupport(new PropertyChangeSupport(mStoneAgeGame));

        mStoneAgeGame.setNumPlayer(aNumPlayers);
        MResourceSquareRedSetupStrategy.setPlayersNumber(aNumPlayers);

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

        IShuffleStrategyFactory shuffleStrategyFactory = new RedShuffleStrategyFactory();
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
     * @return The appropriate board according to the mode
     */
    @Override
    public MBoard makeBoard() {
        return new MRedBoard();
    }


    /**
     * Initialize the appropriate grid
     *
     * @return The appropriate grid according to the mode
     */
    @Override
    public MGrid makeGrid() {
        return new MRedGrid();
    }

    /**
     * Initialize the appropriate game state
     *
     * @return The appropriate game state according to the mode
     */
    public GameState makeGameState() {
        return new GameState();
    }

    /**
     * Initialize the appropriate game goal strategy
     *
     * @return The appropriate gaem Goal strategy according to the mode
     */
    public IGameGoalStrategy makeGameGoalStrategy() {
        return new ThreeHutTokenGoalStrategy();
    }

    /**
     * Initialize the appropriate turning strategy
     *
     * @return The appropriate turning strategy according to the mode
     */
    public INextPlayerStrategy makeTurningStrategy() {
        return new MHumanPlayersFirstStrategy();
    }

    /**
     *
     */
    public void initializeBoard() {

    }
}

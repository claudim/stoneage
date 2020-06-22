package com.univaq.stoneage.model.gameInitializer;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.forestTokens.grid.MGreenGrid;
import com.univaq.stoneage.model.forestTokens.grid.MGrid;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.gameGoal.ThreeHutTokenGoalStrategy;
import com.univaq.stoneage.model.gameState.GameState;
import com.univaq.stoneage.model.playerTurning.INextPlayerStrategy;
import com.univaq.stoneage.model.playerTurning.MHumanPlayersFirstStrategy;
import com.univaq.stoneage.model.players.playerFactory.MPlayerFactory;
import com.univaq.stoneage.model.squares.MBoard;
import com.univaq.stoneage.model.squares.MGreenBoard;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy.MResourceSquareGreenSetupStrategy;
import com.univaq.stoneage.utility.shuffle.GreenShuffleStrategyFactory;
import com.univaq.stoneage.utility.shuffle.IShuffleStrategyFactory;

import java.beans.PropertyChangeSupport;

/**
 * It is responsible for the green mode game initialization,for the creation of the board, grid; for the creation of game goal and
 * turning strategy and manages the players creation.
 */
public class GreenGameInitializer implements IGameInitializer {

    /**
     * Initializes stone age game in green mode and it's elements.
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
        MResourceSquareGreenSetupStrategy.setPlayersNumber(aNumPlayers);


        // creates board and squares
        MBoard board = makeBoard();
//        ArrayList<MSquare> squares = makeSquares();
//        board.setM_squares(squares);
        mStoneAgeGame.setM_board(board);

        MSquare startSquare = board.getStartSquare();

        //players
        MPlayerFactory mPlayerFactory = new MPlayerFactory();
        mPlayerFactory.createPlayers(aNumPlayers, aMarkerName);
        mPlayerFactory.setStartSquare(startSquare);

        // creates grid and forestTokens
        MGrid grid = makeGrid();
//        grid.setM_tokens(makeForestTokens());
//        grid.setM_shuffleStrategy(makeShuffleStrategy());
//        grid.setM_nextForestTokenStrategy(makeNextForestTokenStrategy());

        IShuffleStrategyFactory shuffleStrategyFactory = new GreenShuffleStrategyFactory();
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
        return new MGreenBoard();
    }

    /**
     * Initialize the appropriate grid
     *
     * @return The appropriate grid according to the mode
     */
    @Override
    public MGrid makeGrid() {
        return new MGreenGrid();
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
     * @return The appropriate game goal strategy according to the mode
     */
    public IGameGoalStrategy makeGameGoalStrategy() {
        return new ThreeHutTokenGoalStrategy();
    }

    /**
     * Initialize the appropriate turning strategy
     *
     * @return The appropriate next player strategy according to the mode
     */
    public INextPlayerStrategy makeTurningStrategy() {
        return new MHumanPlayersFirstStrategy();
    }


}

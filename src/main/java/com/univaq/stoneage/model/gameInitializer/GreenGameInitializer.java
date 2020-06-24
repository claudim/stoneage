package com.univaq.stoneage.model.gameInitializer;

import com.univaq.stoneage.model.forestTokens.grid.MGreenGrid;
import com.univaq.stoneage.model.forestTokens.grid.MGrid;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.gameGoal.ThreeHutTokenGoalStrategy;
import com.univaq.stoneage.model.gameState.GameState;
import com.univaq.stoneage.model.playerTurning.INextPlayerStrategy;
import com.univaq.stoneage.model.playerTurning.MHumanPlayersFirstStrategy;
import com.univaq.stoneage.model.squares.board.MBoard;
import com.univaq.stoneage.model.squares.board.MGreenBoard;
import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy.MResourceSquareGreenSetupStrategy;
import com.univaq.stoneage.utility.shuffle.GreenShuffleStrategyFactory;
import com.univaq.stoneage.utility.shuffle.IShuffleStrategyFactory;

/**
 * It is responsible for the green mode game initialization,for the creation of the board, grid; for the creation of game goal and
 * turning strategy and manages the players creation.
 */
public class GreenGameInitializer extends GameInitializer {

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

    /**
     * Initialize the appropriate shuffle strategy factory
     *
     * @return The appropriate shuffle strategy factory according to the mode
     */
    @Override
    IShuffleStrategyFactory makeShuffleStrategyFactory() {
        return new GreenShuffleStrategyFactory();
    }

    /**
     * Initialize the player number for green mode
     *
     * @param playerNumber number of players
     */
    @Override
    void setPlayerNumber(int playerNumber) {
        MResourceSquareGreenSetupStrategy.setPlayersNumber(playerNumber);
    }

}

package com.univaq.stoneage.model.gameInitializer;

import com.univaq.stoneage.model.forestTokens.grid.MGrid;
import com.univaq.stoneage.model.forestTokens.grid.MRedGrid;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.gameGoal.ThreeHutTokenGoalStrategy;
import com.univaq.stoneage.model.gameState.GameState;
import com.univaq.stoneage.model.playerTurning.INextPlayerStrategy;
import com.univaq.stoneage.model.playerTurning.MHumanPlayersFirstStrategy;
import com.univaq.stoneage.model.squares.board.MBoard;
import com.univaq.stoneage.model.squares.board.MRedBoard;
import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy.MResourceSquareRedSetupStrategy;
import com.univaq.stoneage.utility.shuffle.IShuffleStrategyFactory;
import com.univaq.stoneage.utility.shuffle.RedShuffleStrategyFactory;

/**
 * It is responsible for the red mode game initialization,for the creation of the board, grid; for the creation of game goal and
 * turning strategy and manages the players creation.
 */
public class RedGameInitializer extends GameInitializer {

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
     * Initialize the appropriate shuffle strategy factory
     *
     * @return The appropriate shuffle strategy factory according to the mode
     */
    @Override
    IShuffleStrategyFactory makeShuffleStrategyFactory() {
        return new RedShuffleStrategyFactory();
    }

    /**
     * Initialize the player number for red mode
     *
     * @param playerNumber number of players
     */
    @Override
    void setPlayerNumber(int playerNumber) {
        MResourceSquareRedSetupStrategy.setPlayersNumber(playerNumber);
    }


}

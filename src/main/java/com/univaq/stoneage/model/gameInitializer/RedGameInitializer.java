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

public class RedGameInitializer implements IGameInitializer {
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

    @Override
    public MBoard makeBoard() {
        return new MRedBoard();
    }


    @Override
    public MGrid makeGrid() {
        return new MRedGrid();
    }


    public GameState makeGameState() {
        return new GameState();
    }

    public IGameGoalStrategy makeGameGoalStrategy() {
        return new ThreeHutTokenGoalStrategy();
    }

    public INextPlayerStrategy makeTurningStrategy() {
        return new MHumanPlayersFirstStrategy();
    }

    public void initializeBoard() {

    }
}

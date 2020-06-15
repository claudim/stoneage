package com.univaq.stoneage.model.gameInitializer;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.forestTokens.MGrid;
import com.univaq.stoneage.model.gameMode.GameMode;
import com.univaq.stoneage.model.gameState.GameState;
import com.univaq.stoneage.model.playerTurning.INextPlayerStrategy;
import com.univaq.stoneage.model.players.playerFactory.MPlayerFactory;
import com.univaq.stoneage.model.squares.MBoard;
import com.univaq.stoneage.model.squares.MSquare;

import java.beans.PropertyChangeSupport;

/**
 * It is responsible for the game initialization,for the creation of the board, grid; for the creation of game goal and turning strateg and manages the players creation.
 */
public class GameInitializer implements IGameInitializer {
    /**
     * Initialize the game.
     *
     * @param mStoneAgeGame The game
     * @param aMode         The game mode
     * @param aNumPlayers   Number of players
     * @param aMarkerName   Human player's name
     */
    @Override
    public void initializeStoneAgeGame(MStoneAgeGame mStoneAgeGame, String aMode, int aNumPlayers, String aMarkerName) {

        GameState gameState = new GameState();
        mStoneAgeGame.setM_gameState(gameState);
        GameMode gameMode = new GameMode(aMode);
        mStoneAgeGame.setM_mode(gameMode);
        mStoneAgeGame.setSupport(new PropertyChangeSupport(mStoneAgeGame));
        mStoneAgeGame.setNumPlayer(aNumPlayers);

        // create a board
        MBoard mBoard = new MBoard(gameMode);
        mStoneAgeGame.setM_board(mBoard);
        // create a grid
        mStoneAgeGame.setM_grid(new MGrid(gameMode));

        MSquare startSquare = mBoard.getStartSquare();

        MPlayerFactory mPlayerFactory = new MPlayerFactory();
        mPlayerFactory.createPlayers(aNumPlayers, aMarkerName);
        mPlayerFactory.setStartSquare(startSquare);
        // m_players = mPlayerFactory.getPlayers();

        mStoneAgeGame.setM_gameGoalStrategy(gameMode.getGameGoalStrategy());

        INextPlayerStrategy nextPlayerStrategy = gameMode.getNextPlayerStrategy(aNumPlayers);
        mStoneAgeGame.setM_nextPlayerStrategy(nextPlayerStrategy);

        // set the right strategy to identify the players order and set the players.
        mStoneAgeGame.setM_players(nextPlayerStrategy.sortPlayers(mPlayerFactory.getPlayers()));

        gameState.initialize();
    }
}

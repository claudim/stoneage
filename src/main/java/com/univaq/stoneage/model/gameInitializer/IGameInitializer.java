package com.univaq.stoneage.model.gameInitializer;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.forestTokens.grid.MGrid;
import com.univaq.stoneage.model.squares.MBoard;


/**
 * It is responsible for the game initialization,for the creation of the board, grid; for the creation of game goal and turning strateg and manages the players creation.
 */
public interface IGameInitializer {

    /**
     * Initialize the game.
     *
     * @param mStoneAgeGame The game
     * @param aNumPlayers   Number of players
     * @param aMarkerName   Human player's name
     */
    void initializeStoneAgeGame(MStoneAgeGame mStoneAgeGame, int aNumPlayers, String aMarkerName);

    MBoard makeBoard();
    MGrid makeGrid();


}

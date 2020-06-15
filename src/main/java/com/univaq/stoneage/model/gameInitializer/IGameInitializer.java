package com.univaq.stoneage.model.gameInitializer;

import com.univaq.stoneage.model.MStoneAgeGame;

/**
 * It is responsible for the game initialization,for the creation of the board, grid; for the creation of game goal and turning strateg and manages the players creation.
 */
public interface IGameInitializer {

    /**
     * Initialize the game.
     *
     * @param mStoneAgeGame The game
     * @param aMode         The game mode
     * @param aNumPlayers   Number of players
     * @param aMarkerName   Human player's name
     */
    void initializeStoneAgeGame(MStoneAgeGame mStoneAgeGame, String aMode, int aNumPlayers, String aMarkerName);
}

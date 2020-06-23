package com.univaq.stoneage.model.gameInitializer.gameInitializerFactory;

import com.univaq.stoneage.model.gameInitializer.GameInitializer;

/**
 * Factory Method pattern. Factory responsible to create the appropriate game initializer according to the mode
 */
public interface IGameInitializerFactory {

    /**
     * Get the appropriate game initializer according to the mode
     *
     * @param gameMode name of game mode
     * @return GameInitializer for the provided mode
     */
    GameInitializer getGameInitializer(String gameMode);
}

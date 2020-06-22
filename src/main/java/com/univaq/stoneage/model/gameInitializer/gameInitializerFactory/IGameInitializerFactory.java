package com.univaq.stoneage.model.gameInitializer.gameInitializerFactory;

import com.univaq.stoneage.model.gameInitializer.IGameInitializer;

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
    IGameInitializer getGameInitializer(String gameMode);
}

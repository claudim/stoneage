package com.univaq.stoneage.model.gameInitializer.gameInitializerFactory;

import com.univaq.stoneage.model.gameInitializer.GreenGameInitializer;
import com.univaq.stoneage.model.gameInitializer.IGameInitializer;
import com.univaq.stoneage.model.gameInitializer.RedGameInitializer;

/**
 * Concrete game initializer factory. Simple Factory + Singleton Pattern
 */
public class GameInitializerFactory implements IGameInitializerFactory {

    /* Instance of the game initializer factory. Singleton Pattern */
    private static GameInitializerFactory instance;

    /**
     * Singleton Pattern
     *
     * @return Instance of gameInitializerFactory
     */
    public static GameInitializerFactory getInstance() {

        if (instance == null) {
            instance = new GameInitializerFactory();
        }
        return instance;
    }

    /**
     * Get the appropriate game initializer according to the mode
     *
     * @param gameMode name of game mode
     * @return GameInitializer for the provided mode
     */
    @Override
    public IGameInitializer getGameInitializer(String gameMode) {
        IGameInitializer gameInitializer;
        if (gameMode.equals("Rossa")) {
            gameInitializer = new RedGameInitializer();
        } else {
            gameInitializer = new GreenGameInitializer();
        }
        return gameInitializer;
    }
}

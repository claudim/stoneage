package com.univaq.stoneage.model.gameInitializer.gameInitializerFactory;

import com.univaq.stoneage.model.gameInitializer.GreenGameInitializer;
import com.univaq.stoneage.model.gameInitializer.IGameInitializer;
import com.univaq.stoneage.model.gameInitializer.RedGameInitializer;

public class GameInitializerFactory implements IGameInitializerFactory {

    private static GameInitializerFactory instance;

    public static GameInitializerFactory getInstance() {

        if (instance == null) {
            instance = new GameInitializerFactory();
        }
        return instance;
    }

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

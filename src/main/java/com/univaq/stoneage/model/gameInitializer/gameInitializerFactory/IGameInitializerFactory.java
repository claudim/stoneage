package com.univaq.stoneage.model.gameInitializer.gameInitializerFactory;

import com.univaq.stoneage.model.gameInitializer.IGameInitializer;

public interface IGameInitializerFactory {

    IGameInitializer getGameInitializer(String gameMode);
}

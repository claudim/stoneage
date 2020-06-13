package com.univaq.stoneage.model.forestTokens.forestTokenFactory;

import com.univaq.stoneage.model.forestTokens.MTokenForest;

import java.util.ArrayList;

/**
 * Interface for the forest token factory.
 */
public interface ITokenForestFactory {

    /**
     * Create all the game forest tokens.
     *
     * @return The forest tokens
     */
    ArrayList<MTokenForest> createForestTokens();
}

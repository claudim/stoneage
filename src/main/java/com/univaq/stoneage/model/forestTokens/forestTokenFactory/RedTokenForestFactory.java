package com.univaq.stoneage.model.forestTokens.forestTokenFactory;

import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.persistence.IPersistentGeneric;
import com.univaq.stoneage.persistence.PersistenceServiceFactory;

import java.util.ArrayList;

/**
 * It is responsible to create the forest token for the red mode.
 */
public class RedTokenForestFactory implements ITokenForestFactory {

    /**
     * Create all the game forest tokens according to the red mode.
     *
     * @return The forest tokens
     */
    public ArrayList<MTokenForest> createForestTokens() {
        IPersistentGeneric dao = PersistenceServiceFactory.getInstance().getPersistenceClass(MTokenForest.class.getSimpleName(), "rossa");
        return dao.findAll();
    }
}

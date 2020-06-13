package com.univaq.stoneage.model.forestTokens.forestTokenFactory;

import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.persistence.IPersistentGeneric;
import com.univaq.stoneage.persistence.PersistenceServiceFactory;

import java.util.ArrayList;

/**
 * It is responsible to create the forest token for the green mode.
 */
public class GreenTokenForestFactory implements ITokenForestFactory {
    /**
     * Create all the game forest tokens according to the green mode.
     *
     * @return The forest tokens
     */
    @Override
    public ArrayList<MTokenForest> createForestTokens() {
        IPersistentGeneric dao = PersistenceServiceFactory.getInstance().getPersistenceClass(MTokenForest.class.getSimpleName(), "verde");
        return dao.findAll();
    }
}

package com.univaq.stoneage.model.forestTokens.forestTokenFactory;

import com.univaq.stoneage.dao.IGenericDAO;
import com.univaq.stoneage.dao.PersistenceServiceFactory;
import com.univaq.stoneage.model.forestTokens.MTokenForest;

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
        IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MTokenForest.class.getSimpleName(), "rossa");
        return dao.findAll();
    }
}

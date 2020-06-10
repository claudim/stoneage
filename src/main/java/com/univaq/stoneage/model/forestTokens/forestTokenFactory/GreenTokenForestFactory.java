package com.univaq.stoneage.model.forestTokens.forestTokenFactory;

import com.univaq.stoneage.dao.IGenericDAO;
import com.univaq.stoneage.dao.PersistenceServiceFactory;
import com.univaq.stoneage.model.forestTokens.MTokenForest;

import java.util.ArrayList;

public class GreenTokenForestFactory implements ITokenForestFactory {
    @Override
    public ArrayList<MTokenForest> createForestTokens() {
        IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MTokenForest.class.getSimpleName(), "verde");
        return dao.findAll();
    }
}

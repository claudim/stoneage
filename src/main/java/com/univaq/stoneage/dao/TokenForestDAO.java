package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.forestTokens.MTokenForest;

/**
 * Class that handle persistence for Forest Token objects
 */
public class TokenForestDAO extends GenericHibernateDAO<MTokenForest> {

    /**
     * Constructor
     */
    public TokenForestDAO() {
        super();
        setClazz(MTokenForest.class);
    }

}



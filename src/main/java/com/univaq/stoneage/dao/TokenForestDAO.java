package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.MTokenForest;

public class TokenForestDAO extends GenericHibernateDAO<MTokenForest> {
    public TokenForestDAO() {
        super();
        setClazz(MTokenForest.class);
    }

}

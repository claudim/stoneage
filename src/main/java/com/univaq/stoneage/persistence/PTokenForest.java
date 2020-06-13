package com.univaq.stoneage.persistence;

import com.univaq.stoneage.model.forestTokens.MTokenForest;

/**
 * Class that handle persistence for Forest Token objects
 */
public class PTokenForest extends PGenericHibernate {

    /**
     * Constructor
     */
    public PTokenForest() {
        super();
        setClazz(MTokenForest.class);
    }

}



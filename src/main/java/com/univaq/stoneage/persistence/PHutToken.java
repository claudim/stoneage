package com.univaq.stoneage.persistence;

import com.univaq.stoneage.model.hutTokens.MHutToken;

/**
 * Class that handle persistence for the hut tokens objects
 */
public class PHutToken extends PGenericHibernate {

    /**
     * Constructor
     */
    public PHutToken() {
        super();
        this.setClazz(MHutToken.class);
    }
}

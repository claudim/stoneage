package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.hutTokens.MHutToken;

/**
 * Class that handle persistence for the hut tokens objects
 */
public class HutTokenDAO extends GenericHibernateDAO<MHutToken> {

    /**
     * Constructor
     */
    public HutTokenDAO() {
        super();
        this.setClazz(MHutToken.class);
    }
}

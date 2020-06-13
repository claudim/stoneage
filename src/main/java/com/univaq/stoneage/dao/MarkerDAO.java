package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.players.MMarker;

/**
 * Class that handle persistence for markers objects
 */
public class MarkerDAO extends GenericHibernateDAO<MMarker> {

    /**
     * Constructor
     */
    public MarkerDAO() {
        super();
        this.setClazz(MMarker.class);
    }
}





package com.univaq.stoneage.persistence;

import com.univaq.stoneage.model.players.MMarker;

/**
 * Class that handle persistence for markers objects
 */
public class PMarker extends PGenericHibernate {

    /**
     * Constructor
     */
    public PMarker() {
        super();
        this.setClazz(MMarker.class);
    }
}





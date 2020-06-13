package com.univaq.stoneage.persistence;

import com.univaq.stoneage.model.MResource;

/**
 * Class that handle persistence for Resource objects
 */
public class PResource extends PGenericHibernate {

    /**
     * Constructor
     */
    public PResource() {
        super();
        this.setClazz(MResource.class);
    }
}

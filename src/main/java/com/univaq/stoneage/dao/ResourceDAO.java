package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.MResource;

/**
 * Class that handle persistence for Resource objects
 */
public class ResourceDAO extends GenericHibernateDAO<MResource> {

    /**
     * Constructor
     */
    public ResourceDAO() {
        super();
        this.setClazz(MResource.class);
    }
}

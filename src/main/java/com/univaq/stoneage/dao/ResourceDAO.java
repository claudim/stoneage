package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.MResource;

public class ResourceDAO extends GenericHibernateDAO<MResource> {
    public ResourceDAO() {
        super();
        this.setClazz(MResource.class);
    }
}

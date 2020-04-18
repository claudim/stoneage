package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.MMarker;

public class MarkerDAO extends GenericHibernateDAO<MMarker> {
    public MarkerDAO() {
        super();
        this.setClazz(MMarker.class);
    }
}





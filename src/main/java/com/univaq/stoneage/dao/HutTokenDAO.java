package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.MHutToken;

public class HutTokenDAO extends GenericHibernateDAO<MHutToken> {
    public HutTokenDAO() {
        super();
        this.setClazz(MHutToken.class);
    }
}

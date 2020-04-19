package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.MSquare;

public class SquareDAO extends GenericHibernateDAO<MSquare> {

    public SquareDAO() {
        super();
        this.setClazz(MSquare.class);
    }
}
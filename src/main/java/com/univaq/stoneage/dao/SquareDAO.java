package com.univaq.stoneage.dao;

import com.univaq.stoneage.model.squares.MSquare;

/**
 * Class that handle persistence for Square objects
 */
public class SquareDAO extends GenericHibernateDAO<MSquare> {

    /**
     * Constructor
     */
    public SquareDAO() {
        super();
        this.setClazz(MSquare.class);
    }
}
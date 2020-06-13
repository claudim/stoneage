package com.univaq.stoneage.persistence;

import com.univaq.stoneage.model.squares.MSquare;

/**
 * Class that handle persistence for Square objects
 */
public class PSquare extends PGenericHibernate {

    /**
     * Constructor
     */
    public PSquare() {
        super();
        this.setClazz(MSquare.class);
    }

}
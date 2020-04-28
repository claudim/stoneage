package com.univaq.stoneage.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * MSquareTokenForest is a persistence entity, concrete subclass of MTokenForest<String>.
 */
@Entity
@DiscriminatorValue("squaretokenforest")
public class MSquareTokenForest extends MTokenForest<String> {
    public MSquareTokenForest() {
        super();
    }

    @Column(name = "square_value")
    private String m_squareName;

    public MSquareTokenForest(int position, String tokenForestValue) {
        super(position);
        this.m_squareName = tokenForestValue;
    }

    /**
     * Get the forest token value. The value is a square name.
     *
     * @return String The forest token value
     */
    @Override
    public String getValue() {
        return this.m_squareName;
    }

    /**
     * Set the forest token value. The value is a square name.
     *
     * @param value String The forest token value
     */
    @Override
    public void setValue(String value) {
        this.m_squareName = value;
    }
}
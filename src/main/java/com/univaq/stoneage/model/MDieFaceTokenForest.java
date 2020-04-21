package com.univaq.stoneage.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * MDieFaceTokenForest is a persistence, concrete subclass of MTokenForest<Integer>.
 */
@Entity
//@Table(name = "diefacetokenforest")
@DiscriminatorValue("diefacetokenforest")
public class MDieFaceTokenForest extends MTokenForest<Integer> {
    public MDieFaceTokenForest() {
    }

    @Column(name = "die_value")
    private int m_dieFace;

    public MDieFaceTokenForest(int position, int tokenForestValue) {
        super(position);
        this.m_dieFace = tokenForestValue;
    }

    /**
     * Get the forest token value. The value is a die face number.
     *
     * @return Integer The forest token value
     */
    @Override
    public Integer getValue() {
        return this.m_dieFace;
    }

    /**
     * Set the forest token value. The value is a die face number.
     *
     * @param value Integer The forest token value
     */
    @Override
    public void setValue(Integer value) {
        this.m_dieFace = value;
    }
}
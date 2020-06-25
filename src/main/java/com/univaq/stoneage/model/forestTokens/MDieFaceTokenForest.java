package com.univaq.stoneage.model.forestTokens;


import com.univaq.stoneage.model.players.findingSquare.MDieFaceTFFindNewSquareStrategy;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import static com.univaq.stoneage.utility.TokenState.FACEDOWN;

/**
 * MDieFaceTokenForest is a persistence entity, concrete subclass of MTokenForest<Integer>.
 */
@Entity
@DiscriminatorValue("diefacetokenforest")
public class MDieFaceTokenForest extends MTokenForest<Integer> {
    public MDieFaceTokenForest() {
        super();
        super.findNewSquareStrategy = new MDieFaceTFFindNewSquareStrategy();
    }

    @Column(name = "die_value")
    private int m_dieFace;

    /**
     * Constructor.
     *
     * @param tokenForestValue The value
     */
    public MDieFaceTokenForest(int tokenForestValue) {
        super();
        super.m_state = FACEDOWN;
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
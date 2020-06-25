package com.univaq.stoneage.model.forestTokens;

import com.univaq.stoneage.model.players.findingSquare.MSquareTFFindNewSquareStrategy;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import static com.univaq.stoneage.utility.TokenState.FACEDOWN;

/**
 * MSquareTokenForest is a persistence entity, concrete subclass of MTokenForest<String>.
 */
@Entity
@DiscriminatorValue("squaretokenforest")
public class MSquareTokenForest extends MTokenForest<String> {
    public MSquareTokenForest() {
        super();
        super.findNewSquareStrategy = new MSquareTFFindNewSquareStrategy();
    }

    @Column(name = "square_value")
    private String m_squareName;

    /**
     * Constructor.
     *
     * @param tokenForestValue The value
     */
    public MSquareTokenForest(String tokenForestValue) {
        super();
        super.m_state = FACEDOWN;
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
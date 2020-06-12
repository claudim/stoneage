package com.univaq.stoneage.model.squares.squareSetup;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;

/**
 * NumberResourceSquareSetupStrategy is a class responsible to setup a MResourceSquare
 * with a constant number (RESOURCENUMBER) of MResource.
 * RESOURCENUMBER is 2
 * MResource type is the same type of the resourceType of the square
 * This strategy implements the rule N.5 of the StoneAge Supplementary Specification
 */
public class NumberResourceSquareSetupStrategy implements MISquareSetupStrategy {

    private final int resourceNumber = 2;

    /**
     * Default constructor.
     */
    public NumberResourceSquareSetupStrategy() {
    }

    /**
     * Setup a resource square with a constant number (RESOURCENUMBER) of MResource.
     * RESOURCENUMBER is 2.
     *
     * @param square The resource square
     */
    @Override
    public void setupSquare(MResourceSquare square) {
        for (int i = 0; i < resourceNumber; i++)
            square.getM_resources().add(new MResource(square.getm_resourceType()));
    }
}

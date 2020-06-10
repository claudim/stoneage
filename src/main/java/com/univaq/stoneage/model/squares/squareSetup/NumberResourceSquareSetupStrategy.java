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
    private int resourceNumber = 2;

    public NumberResourceSquareSetupStrategy() {
    }

    public NumberResourceSquareSetupStrategy(int resourceNumber) {
        this.resourceNumber = resourceNumber;
    }

    @Override
    public void setupSquare(MResourceSquare square) {
        for (int i = 0; i < resourceNumber; i++)
            square.getM_resources().add(new MResource(square.getm_resourceType()));
    }
}

package com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory.IResourceSquareStateFactory;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory.RedResourceSquareStateFactory;

/**
 * NumberResourceSquareSetupStrategy is a class responsible to setup a MResourceSquare
 * with a constant number (RESOURCENUMBER) of MResource.
 * RESOURCENUMBER is 2
 * MResource type is the same type of the resourceType of the square
 * This strategy implements the rule N.5 of the StoneAge Supplementary Specification
 */
public class FixedNumberResourceSquareRedSetupStrategy implements MISquareSetupStrategy {

    private static int resourceNumber = 2;

    /**
     * Default constructor.
     */
    public FixedNumberResourceSquareRedSetupStrategy() {
    }

    /**
     * Static method to set the number of resources.
     *
     * @param aResourceNumber tthe number of resources
     */
    public static void setResourceNumber(int aResourceNumber) {
        resourceNumber = aResourceNumber;
    }

    /**
     * Setup a resource square with a constant number (RESOURCENUMBER) of MResource.
     * RESOURCENUMBER is 2.
     *
     * @param square The resource square
     */
    @Override
    public void setupSquare(MSquare square) {
        MResourceSquare resourceSquare = (MResourceSquare) square;
        for (int i = 0; i < resourceNumber; i++)
            resourceSquare.getM_resources().add(new MResource(resourceSquare.getm_resourceType()));
        IResourceSquareStateFactory resourceSquareStateFactory = new RedResourceSquareStateFactory();
        resourceSquare.setM_squareStateFactory(resourceSquareStateFactory);
        resourceSquare.setM_squareState(resourceSquareStateFactory.createState(resourceSquare, null));

    }
}

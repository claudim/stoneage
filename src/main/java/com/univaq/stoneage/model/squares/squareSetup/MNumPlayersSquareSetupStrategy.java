package com.univaq.stoneage.model.squares.squareSetup;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;

/**
 * MNumPlayersSquareSetupStrategy is a class responsible to setup a MResourceSquare
 * with a NumPlayers + ADDNUMBER of MResource.
 * ADDNUMBER is 1
 * MResource type is the same type of the resourceType of the square
 * This strategy implements the rule N.5 of the StoneAge Supplementary Specification
 */
public class MNumPlayersSquareSetupStrategy implements MISquareSetupStrategy {
    private final int addNumber = 1;

    /**
     * Default constructor.
     */
    public MNumPlayersSquareSetupStrategy() {
    }

    /**
     * Setup a resource square with a NumPlayers + ADDNUMBER of MResource.
     * ADDNUMBER is 1.
     * MResource type is the same type of the resourceType of the square
     *
     * @param square The resource square
     */
    @Override
    public void setupSquare(MResourceSquare square) {
        int numPlayer = MStoneAgeGame.getInstance().getNumPlayer();
        for (int i = 0; i < numPlayer + addNumber; i++)
            square.getM_resources().add(new MResource(square.getm_resourceType()));
    }
}

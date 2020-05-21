package com.univaq.stoneage.model.squares.squareSetup;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.squares.MResourceSquare;

/**
 * MNumPlayersSquareSetupStrategy is a class responsible to setup a MResourceSquare
 * with a NumPlayers + ADDNUMBER of MResource.
 * ADDNUMBER is 1
 * MResource type is the same type of the resourceType of the square
 * This strategy implements the rule N.5 of the StoneAge Supplementary Specification
 */
public class MNumPlayersSquareSetupStrategy implements MISquareSetupStrategy {
    private int addNumber = 1;

    public MNumPlayersSquareSetupStrategy() {
    }

    public MNumPlayersSquareSetupStrategy(int addNumber) {
        this.addNumber = addNumber;
    }

    @Override
    public void setupSquare(MResourceSquare square) {
        int numPlayer = MStoneAgeGame.getInstance().getNumPlayer();
        for (int i = 0; i < numPlayer + addNumber; i++)
            square.getM_resources().add(new MResource(square.getm_resourceType()));
    }
}

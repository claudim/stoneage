package com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory.IResourceSquareStateFactory;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory.RedResourceSquareStateFactory;

/**
 * MNumPlayersSquareSetupStrategy is a class responsible to setup a MResourceSquare
 * with a NumGamePlayers + ADDNUMBER of MResource.
 * ADDNUMBER is 1
 * MResource type is the same type of the resourceType of the square
 * This strategy implements the rule N.5 of the StoneAge Supplementary Specification
 */
public class MResourceSquareRedSetupStrategy implements MISquareSetupStrategy {
    private static final int addNumber = 1;
    public static int numGamePlayers = 2;


    /**
     * Default constructor.
     */
    public MResourceSquareRedSetupStrategy() {
    }

    /**
     * Static method to set the number of players.
     *
     * @param playersNumber the number of players
     */
    public static void setPlayersNumber(int playersNumber) {
        numGamePlayers = playersNumber;
    }

    /**
     * Setup a resource square with a NumPlayers + ADDNUMBER of MResource.
     * ADDNUMBER is 1.
     * MResource type is the same type of the resourceType of the square
     *
     * @param square The resource square
     */
    @Override
    public void setupSquare(MSquare square) {

        MResourceSquare resourceSquare = (MResourceSquare) square;
        for (int i = 0; i < numGamePlayers + addNumber; i++)
            resourceSquare.getM_resources().add(new MResource(resourceSquare.getm_resourceType()));

        IResourceSquareStateFactory resourceSquareStateFactory = new RedResourceSquareStateFactory();
        resourceSquare.setM_squareStateFactory(resourceSquareStateFactory);
        resourceSquare.setM_squareState(resourceSquareStateFactory.createState(resourceSquare, null));
    }
}

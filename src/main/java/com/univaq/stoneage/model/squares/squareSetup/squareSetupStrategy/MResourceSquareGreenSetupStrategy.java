package com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory.GreenResourceSquareStateFactory;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory.IResourceSquareStateFactory;

public class MResourceSquareGreenSetupStrategy implements MISquareSetupStrategy {

    /* Resource number = player number + addNumber*/
    private static final int addNumber = 1;
    private static int numGamePlayers = 2;


    /**
     * Constructor
     */
    public MResourceSquareGreenSetupStrategy() {
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

        IResourceSquareStateFactory resourceSquareStateFactory = new GreenResourceSquareStateFactory();
        resourceSquare.setM_squareStateFactory(resourceSquareStateFactory);
        resourceSquare.setM_squareState(resourceSquareStateFactory.createState(resourceSquare, null));
    }
}

package com.univaq.stoneage.model.players.findingSquare;

import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.squares.MSquare;

/**
 * MSquareTFFindNewSquareStrategy is a class responsible to find the new square if the forest token value is a square name.
 */
public class MSquareTFFindNewSquareStrategy implements MIFindNewSquareStrategy {
    /**
     * Default constructor.
     */
    public MSquareTFFindNewSquareStrategy() {
    }

    /**
     * Find the new square according to the forest token value.
     *
     * @param aCurrentSquare The square where the marker is on.
     * @param aMTokenForest  The forest token choosen
     * @return MSquare The square where the marker will be on.
     */
    @Override
    public MSquare findNewSquare(MSquare aCurrentSquare, MTokenForest aMTokenForest) {
        MSquare newSquare = aCurrentSquare;
        while (!newSquare.getM_name().equals(aMTokenForest.getValue()))
            newSquare = newSquare.getM_nextSquare();
        return newSquare;
    }
}

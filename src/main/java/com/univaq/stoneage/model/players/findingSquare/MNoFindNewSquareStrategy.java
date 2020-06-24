package com.univaq.stoneage.model.players.findingSquare;

import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.squares.MSquare;

/**
 * MNoFindNewSquareStrategy is a class responsible to find the new square when the forest token is not of MDieFaceTokenForest or MSquareTokenForest type.
 */
public class MNoFindNewSquareStrategy implements MIFindNewSquareStrategy {
    /**
     * Default constructor.
     */
    public MNoFindNewSquareStrategy() {
    }

    /**
     * Find the new square according to the forest token.
     *
     * @param aCurrentSquare The square where the marker is on.
     * @param aMTokenForest  The forest token choosen
     * @return MSquare The square where the marker will be on.
     */
    @Override
    public MSquare findNewSquare(MSquare aCurrentSquare, MTokenForest aMTokenForest) {
        return aCurrentSquare;
    }
}

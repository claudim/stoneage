package com.univaq.stoneage.model;

/**
 * MIFindNewSquareStrategy is Strategy Interface to find the new square according to the forest token value.
 */
public interface MIFindNewSquareStrategy {

    /**
     * Find the new square according to the forest token value.
     *
     * @param aCurrentSquare The square where the marker is on.
     * @param aMTokenForest  The forest token choosen
     * @return MSquare The square where the marker will be on.
     */
    MSquare findNewSquare(MSquare aCurrentSquare, MTokenForest aMTokenForest);
}

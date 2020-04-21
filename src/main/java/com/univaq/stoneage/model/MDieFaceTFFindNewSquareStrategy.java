package com.univaq.stoneage.model;

/**
 * MDieFaceTFFindNewSquareStrategy is a class responsible to find the new square if the forest token value is a number.
 */
public class MDieFaceTFFindNewSquareStrategy implements MIFindNewSquareStrategy {
    public MDieFaceTFFindNewSquareStrategy() {
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
        int tokenForestValue = (int) aMTokenForest.getValue();
        MSquare newSquare = aCurrentSquare;
        for (int i = 1; i <= tokenForestValue; i++) {
            newSquare = newSquare.getM_nextSquare();
        }
        return newSquare;
    }
}

package com.univaq.stoneage.Model;

public class MDieFaceTFFindNewSquareStrategy implements MIFindNewSquareStrategy {
    public MDieFaceTFFindNewSquareStrategy() {
    }

    //DieFaceTFFIndNewSquare
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

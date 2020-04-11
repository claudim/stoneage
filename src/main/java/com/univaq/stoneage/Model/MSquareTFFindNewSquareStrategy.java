package com.univaq.stoneage.Model;

public class MSquareTFFindNewSquareStrategy implements MIFindNewSquareStrategy {
    public MSquareTFFindNewSquareStrategy() {
    }

    @Override
    public MSquare findNewSquare(MSquare aCurrentSquare, MTokenForest aMTokenForest) {
        MSquare newSquare = aCurrentSquare;
        while(!newSquare.getM_name().equals((String) aMTokenForest.getValue()))
            newSquare = newSquare.getM_nextSquare();
        return newSquare;
    }
}

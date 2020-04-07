package com.univaq.stoneage.Model;

public class DieFaceTFFindNewSquareStrategy implements IFindNewSquareStrategy{
    public DieFaceTFFindNewSquareStrategy() {
    }

    //DieFaceTFFIndNewSquare
    @Override
    public Square findNewSquare(Square aCurrentSquare, TokenForest aTokenForest) {
        int tokenForestValue = (int) aTokenForest.getValue();
        Square newSquare = aCurrentSquare;
        for (int i = 1; i <= tokenForestValue; i++) {
            newSquare = newSquare.getM_nextSquare();
        }
        return newSquare;
    }
}

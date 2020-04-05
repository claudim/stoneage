package com.univaq.stoneage.Model;

public class DieFaceTFFindNewSquareStrategy implements IFindNewSquareStrategy{
    public DieFaceTFFindNewSquareStrategy() {
    }

    //DieFaceTFFIndNewSquare
    @Override
    public Square findNewSquare(Square aCurrentSquare, Object aTokenForestValue) {
        int tokenForestValue = (int)aTokenForestValue;
        Square newSquare = aCurrentSquare;
        for (int i = 1; i <= tokenForestValue; i++) {
            newSquare = newSquare.getM_nextSquare();
        }
        return newSquare;
    }
}

package com.univaq.stoneage.Model;

public class SquareTFFindNewSquareStrategy implements IFindNewSquareStrategy{
    public SquareTFFindNewSquareStrategy() {
    }

    @Override
    public Square findNewSquare(Square aCurrentSquare, TokenForest aTokenForest) {
        Square newSquare = aCurrentSquare;
        while(!newSquare.getM_name().equals((String)aTokenForest.getValue()))
            newSquare = newSquare.getM_nextSquare();
        return newSquare;
    }
}

package com.univaq.stoneage.Model;

public class SquareTFFindNewSquareStrategy implements IFindNewSquareStrategy{
    public SquareTFFindNewSquareStrategy() {
    }

    @Override
    public Square findNewSquare(Square aCurrentSquare, Object aTokenForestValue) {
        Square newSquare = aCurrentSquare;
        while(!newSquare.getM_name().equals((String)aTokenForestValue))
            newSquare = newSquare.getM_nextSquare();
        return newSquare;
    }
}

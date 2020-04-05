package com.univaq.stoneage.Model;

public class NoFindNewSquareStrategy implements IFindNewSquareStrategy {
    public NoFindNewSquareStrategy() {
    }

    @Override
    public Square findNewSquare(Square aCurrentSquare, Object aTokenForestValue) {
        return aCurrentSquare;
    }
}

package com.univaq.stoneage.model;

public class MNoFindNewSquareStrategy implements MIFindNewSquareStrategy {
    public MNoFindNewSquareStrategy() {
    }

    @Override
    public MSquare findNewSquare(MSquare aCurrentSquare, MTokenForest aMTokenForest) {
        return aCurrentSquare;
    }
}

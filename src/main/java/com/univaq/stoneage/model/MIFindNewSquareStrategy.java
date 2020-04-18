package com.univaq.stoneage.model;

public interface MIFindNewSquareStrategy {

    MSquare findNewSquare(MSquare aCurrentSquare, MTokenForest aMTokenForest);
}

package com.univaq.stoneage.Model;

public interface IFindNewSquareStrategy{

    Square findNewSquare(Square aCurrentSquare, TokenForest aTokenForest);
}

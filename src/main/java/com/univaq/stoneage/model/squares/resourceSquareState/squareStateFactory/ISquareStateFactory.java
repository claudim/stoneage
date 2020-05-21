package com.univaq.stoneage.model.squares.resourceSquareState.squareStateFactory;


import com.univaq.stoneage.model.squares.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquareState.ISquareState;

public interface ISquareStateFactory {
    ISquareState createState(String type, MResourceSquare square);
}

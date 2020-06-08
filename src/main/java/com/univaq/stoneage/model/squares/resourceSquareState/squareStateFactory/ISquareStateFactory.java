package com.univaq.stoneage.model.squares.resourceSquareState.squareStateFactory;


import com.univaq.stoneage.model.squares.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquareState.ISquareState;
import org.springframework.lang.Nullable;


public interface ISquareStateFactory {
    ISquareState createState(MResourceSquare square, @Nullable String type);
}

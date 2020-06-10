package com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory;


import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.ISquareState;
import org.springframework.lang.Nullable;


public interface IResourceSquareStateFactory {
    ISquareState createState(MResourceSquare square, @Nullable String type);
}

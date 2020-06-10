package com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory;

import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.ISquareState;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.NoResourceState;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.WithResourceState;

public class GreenResourceSquareStateFactory implements IResourceSquareStateFactory {
    @Override
    public ISquareState createState(MResourceSquare square, String type) {
        ISquareState iSquareState;
        if (square.getM_resources().size() == 0) {
            iSquareState = new NoResourceState(square);
        } else {
            iSquareState = new WithResourceState(square);
        }
        return iSquareState;
    }
}

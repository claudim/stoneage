package com.univaq.stoneage.model;

import com.univaq.stoneage.model.squares.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquareState.ISquareState;
import com.univaq.stoneage.model.squares.resourceSquareState.NoResourceState;
import com.univaq.stoneage.model.squares.resourceSquareState.WithResourceState;
import com.univaq.stoneage.model.squares.resourceSquareState.squareStateFactory.ISquareStateFactory;

public class GreenSquareStateFactory implements ISquareStateFactory {
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

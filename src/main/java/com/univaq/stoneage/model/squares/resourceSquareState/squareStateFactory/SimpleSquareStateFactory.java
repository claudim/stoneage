package com.univaq.stoneage.model.squares.resourceSquareState.squareStateFactory;

import com.univaq.stoneage.model.squares.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquareState.ISquareState;
import com.univaq.stoneage.model.squares.resourceSquareState.StealResourceState;

public class SimpleSquareStateFactory implements ISquareStateFactory {

    @Override
    public ISquareState createState(String type, MResourceSquare square) {
        ISquareState iSquareState;
        switch (type) {
            default: //Modalità rossa
            {
                iSquareState = new StealResourceState(square);
                break;
            }

        }
        return iSquareState;
    }
}

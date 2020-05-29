package com.univaq.stoneage.model.squares.resourceSquareState.squareStateFactory;

import com.univaq.stoneage.model.squares.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquareState.ISquareState;
import com.univaq.stoneage.model.squares.resourceSquareState.StealResourceState;
import com.univaq.stoneage.model.squares.resourceSquareState.WithResourceState;

public class SimpleSquareStateFactory implements ISquareStateFactory {

    @Override
    public ISquareState createState(String type, MResourceSquare square) {
        ISquareState iSquareState;
        switch (type) {
            default: //Modalità rossa
            {
                if (square.getM_resources().size() == 0) {
                    iSquareState = new StealResourceState(square);
                } else {
                    iSquareState = new WithResourceState(square);
                }
                break;
            }

        }
        return iSquareState;
    }
}

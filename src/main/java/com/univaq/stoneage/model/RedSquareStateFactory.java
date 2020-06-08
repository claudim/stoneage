package com.univaq.stoneage.model;


import com.univaq.stoneage.model.squares.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquareState.ISquareState;
import com.univaq.stoneage.model.squares.resourceSquareState.Release2ResourcesState;
import com.univaq.stoneage.model.squares.resourceSquareState.StealResourceState;
import com.univaq.stoneage.model.squares.resourceSquareState.WithResourceState;
import com.univaq.stoneage.model.squares.resourceSquareState.squareStateFactory.ISquareStateFactory;
import org.springframework.lang.Nullable;

public class RedSquareStateFactory implements ISquareStateFactory {
    @Override
    public ISquareState createState(MResourceSquare square, @Nullable String type) {
        ISquareState iSquareState;
        if (type != null) {
            switch (type) {
                case "Take2": {
                    if (square.getM_resources().size() >= 2) {
                        iSquareState = new Release2ResourcesState(square);
                    } else {
                        iSquareState = square.getM_squareState();
                    }
                    break;
                }
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
        } else {
            if (square.getM_resources().size() == 0) {
                iSquareState = new StealResourceState(square);
            } else {
                iSquareState = new WithResourceState(square);
            }
        }


        return iSquareState;

    }
}

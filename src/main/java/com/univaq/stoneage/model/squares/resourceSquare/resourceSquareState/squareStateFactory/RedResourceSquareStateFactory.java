package com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory;

import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.ISquareState;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.Release2ResourcesState;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.StealResourceState;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.WithResourceState;
import org.springframework.lang.Nullable;

/**
 * RedResourceSquareStateFactory is responsible for the resource square state creation if the game mode is red.
 */
public class RedResourceSquareStateFactory implements IResourceSquareStateFactory {
    /**
     * Create the resource square state for the red mode.
     *
     * @param square The resource square
     * @param type   It could be nullable
     * @return The resource square state
     */
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

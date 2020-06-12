package com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory;

import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.ISquareState;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.NoResourceState;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.WithResourceState;

/**
 * GreenResourceSquareStateFactory is responsible for the resource square state creation if the game mode is green.
 */
public class GreenResourceSquareStateFactory implements IResourceSquareStateFactory {

    /**
     * Create the resource square state for the green mode.
     *
     * @param square The resource square
     * @param type   It could be nullable
     * @return The resource square state
     */
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

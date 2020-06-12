package com.univaq.stoneage.model.squares.squareSetup;

import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;

/**
 * MISquareSetupStrategy is Strategy Interface to setup the square.
 */
public interface MISquareSetupStrategy {
    /**
     * Setup a resource square.
     *
     * @param square The resource square
     */
    void setupSquare(MResourceSquare square);
}

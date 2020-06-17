package com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategyFactory;

import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy.MISquareSetupStrategy;

/**
 * Interface responsible for creating strategies to identifies the right setup square strategy.
 */
public interface MISetupSquareStrategyFactory {

    /**
     * Get the square setup strategy.
     *
     * @param square The square to setup
     * @return The square setup strategy
     */
    MISquareSetupStrategy getSetupSquareStrategy(MSquare square);

    /**
     * Get the resource square setup strategy.
     *
     * @param square The resource square to setup
     * @return The square setup strategy
     */
    MISquareSetupStrategy getSetupSquareByResourceTypeStrategy(MSquare square);

}

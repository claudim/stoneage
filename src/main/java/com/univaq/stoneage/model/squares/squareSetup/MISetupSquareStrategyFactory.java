package com.univaq.stoneage.model.squares.squareSetup;

/**
 * Interface responsible for creating strategies to identifies the right setup square strategy.
 */
public interface MISetupSquareStrategyFactory {

    /**
     * Get the square setup strategy.
     *
     * @param squareResourceType The resource name of the square
     * @return The square setup strategy
     */
    MISquareSetupStrategy getSetupSquareStrategy(String squareResourceType);
}

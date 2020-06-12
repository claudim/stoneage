package com.univaq.stoneage.model.squares.squareSetup;

/**
 * Java class responsible for creating strategies to setup the square.
 * With this class it is possible to dynamically modify the square setup policy
 * by specifying a different Strategy class to be created.
 */
public class MSetupResourceSquareStrategyFactory implements MISetupSquareStrategyFactory {

    /**
     * Get the square setup strategy.
     *
     * @param squareResourceType The resource name of the square
     * @return The square setup strategy
     */
    public MISquareSetupStrategy getSetupSquareStrategy(String squareResourceType) {
        switch (squareResourceType) {
            case "cane":
                return new NumberResourceSquareSetupStrategy();
            default: // "dente", "bacca", "anfora", "freccia", "pesce"
                return new MNumPlayersSquareSetupStrategy();
        }
    }
}

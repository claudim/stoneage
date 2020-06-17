package com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategyFactory;

import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;
import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy.FixedNumberResourceSquareRedSetupStrategy;
import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy.MISquareSetupStrategy;
import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy.MResourceSquareRedSetupStrategy;

/**
 * Java class responsible for creating strategies to setup the square.
 * With this class it is possible to dynamically modify the square setup policy
 * by specifying a different Strategy class to be created.
 */
public class MSetupResourceSquareStrategyFactory implements MISetupSquareStrategyFactory {

    /**
     * Get the resource square setup strategy.
     *
     * @param square The resource square to setup
     * @return The square setup strategy
     */
    public MISquareSetupStrategy getSetupSquareStrategy(MSquare square) {
        MResourceSquare resourceSquare = (MResourceSquare) square;
        switch (resourceSquare.getm_resourceType()) {
            case "cane":
                return new FixedNumberResourceSquareRedSetupStrategy();
            default: // "dente", "bacca", "anfora", "freccia", "pesce"
                return new MResourceSquareRedSetupStrategy();
        }
    }

    @Override
    public MISquareSetupStrategy getSetupSquareByResourceTypeStrategy(MSquare square) {
        return null;
    }
}

package com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategyFactory;

import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;
import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy.*;

public class RedSetupSquareFactory implements MISetupSquareStrategyFactory {
    @Override
    public MISquareSetupStrategy getSetupSquareStrategy(MSquare square) {

        MISquareSetupStrategy squareSetupStrategy;
        switch (square.getSquareType()) {
            case "MBuildingSiteSquare":
                squareSetupStrategy = new RedBuildingSiteSquareSetupStrategy();
                break;
            case "MResourceSquare":
                MResourceSquare resourceSquare = (MResourceSquare) square;
                squareSetupStrategy = getSetupSquareByResourceTypeStrategy(resourceSquare);
                break;
            case "MSurpriseSquare":
                squareSetupStrategy = new RedSurpriseSquareSetupStrategy();
                break;
            default:
                squareSetupStrategy = new NoSetupSquareStrategy();
                break;
        }
        return squareSetupStrategy;
    }

    /**
     * Get the resource square setup strategy.
     *
     * @param square The resource square to setup
     * @return The square setup strategy
     */
    public MISquareSetupStrategy getSetupSquareByResourceTypeStrategy(MSquare square) {
        MResourceSquare resourceSquare = (MResourceSquare) square;
        switch (resourceSquare.getm_resourceType()) {
            case "cane":
                return new FixedNumberResourceSquareRedSetupStrategy();
            default: // "dente", "bacca", "anfora", "freccia", "pesce"
                return new MResourceSquareRedSetupStrategy();
        }
    }
}

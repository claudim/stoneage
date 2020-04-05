package com.univaq.stoneage.Model;

/**
 * Java class responsible for creating strategies to identifies the new square where move the marker.
 * With this class it is possible to dynamically modify the new square determination policy
 * by specifying a different Strategy class to be created.
 */
public class FindNewSquareStrategyFactory {

    public IFindNewSquareStrategy getFindNewSquareStrategy(String accountType) {
        switch (accountType) {
            case "String": return new SquareTFFindNewSquareStrategy();
            case "Integer": return new DieFaceTFFindNewSquareStrategy();
            default: return new NoFindNewSquareStrategy();

        }
    }

}

package com.univaq.stoneage.Model;

/**
 * Java class responsible for creating strategies to identifies the new square where move the marker.
 * With this class it is possible to dynamically modify the new square determination policy
 * by specifying a different Strategy class to be created.
 */
public class MFindNewSquareStrategyFactory {

    private static MFindNewSquareStrategyFactory instance;
    private static MIFindNewSquareStrategy squareTFFindNewSquareStrategy;
    private static MIFindNewSquareStrategy dieFaceTFFindNewSquareStrategy;
    private static MIFindNewSquareStrategy noFindNewSquareStrategy;


    public static MFindNewSquareStrategyFactory getInstance() {

        if (instance == null) {
            instance = new MFindNewSquareStrategyFactory();
            squareTFFindNewSquareStrategy = new MSquareTFFindNewSquareStrategy();
            dieFaceTFFindNewSquareStrategy = new MDieFaceTFFindNewSquareStrategy();
            noFindNewSquareStrategy = new MNoFindNewSquareStrategy();
        }
        return instance;
    }

    //A factory can create a new instance of a class for each request,
    // but since our strategies are stateless(no attributes),
    //we can hang on to a single instance of each strategy and return that whenever someone asks for it.
    public MIFindNewSquareStrategy getFindNewSquareStrategy(String tokenType) {
        switch (tokenType) {
            case "SquareTokenForest": return squareTFFindNewSquareStrategy;
            case "DieFaceTokenForest": return dieFaceTFFindNewSquareStrategy;
            default: return noFindNewSquareStrategy;
        }
    }
}

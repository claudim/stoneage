package com.univaq.stoneage.Model;

/**
 * Java class responsible for creating strategies to identifies the new square where move the marker.
 * With this class it is possible to dynamically modify the new square determination policy
 * by specifying a different Strategy class to be created.
 */
public class FindNewSquareStrategyFactory {

    private static FindNewSquareStrategyFactory instance;
    private static IFindNewSquareStrategy squareTFFindNewSquareStrategy;
    private static IFindNewSquareStrategy dieFaceTFFindNewSquareStrategy;
    private static IFindNewSquareStrategy noFindNewSquareStrategy;


    public static FindNewSquareStrategyFactory getInstance() {

        if (instance == null) {
            instance = new FindNewSquareStrategyFactory();
            squareTFFindNewSquareStrategy = new SquareTFFindNewSquareStrategy();
            dieFaceTFFindNewSquareStrategy = new DieFaceTFFindNewSquareStrategy();
            noFindNewSquareStrategy = new NoFindNewSquareStrategy();
        }
        return instance;
    }

    //A factory can create a new instance of a class for each request,
    // but since our strategies are stateless(no attributes),
    //we can hang on to a single instance of each strategy and return that whenever someone asks for it.
    public IFindNewSquareStrategy getFindNewSquareStrategy(String tokenType) {
        switch (tokenType) {
            case "SquareTokenForest": return squareTFFindNewSquareStrategy;
            case "DieFaceTokenForest": return dieFaceTFFindNewSquareStrategy;
            default: return noFindNewSquareStrategy;
        }
    }
}

package com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy;

import com.univaq.stoneage.model.squares.MSquare;

import java.util.ArrayList;

public abstract class CompositeSetupSquareStrategy implements MISquareSetupStrategy {

    ArrayList<MISquareSetupStrategy> setupSquareStrategies;

    public abstract void setupSquare(MSquare square);

}

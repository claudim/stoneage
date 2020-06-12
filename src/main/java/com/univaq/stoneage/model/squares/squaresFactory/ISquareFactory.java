package com.univaq.stoneage.model.squares.squaresFactory;

import com.univaq.stoneage.model.squares.MSquare;

import java.util.ArrayList;

/**
 * Interface for all the SquareFactory. SquareFactory is responsible for the game squares creation.
 */
public interface ISquareFactory {
    /**
     * Create all the game squares.
     *
     * @return The game squares
     */
    ArrayList<MSquare> createSquares();
}

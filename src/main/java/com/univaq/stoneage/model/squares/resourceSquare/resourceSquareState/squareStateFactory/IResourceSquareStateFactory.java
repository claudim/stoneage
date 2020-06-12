package com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory;


import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.ISquareState;
import org.springframework.lang.Nullable;

/**
 * Interface for all the ResourceSquareStateFactory. ResourceSquareStateFactory is responsible for the resource square state creation.
 */
public interface IResourceSquareStateFactory {
    /**
     * Create the resource square state.
     *
     * @param square The resource square
     * @param type   It could be nullable
     * @return The resource square state
     */
    ISquareState createState(MResourceSquare square, @Nullable String type);
}

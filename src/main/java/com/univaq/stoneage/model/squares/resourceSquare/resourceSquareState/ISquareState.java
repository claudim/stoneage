package com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.ActionResult;

/**
 * Interface to define all the behaviour of a resource square state.
 */
public interface ISquareState {
    /**
     * Perform the action if the marker's player lands on the resource square.
     *
     * @param player The player who lands on the square
     * @return The action result
     */
    ActionResult doSquareAction(MPlayer player);

    /**
     * The action to perform when a resource is added to the square.
     */
    void addedResource();
}

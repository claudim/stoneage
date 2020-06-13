package com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken;

import com.univaq.stoneage.model.squares.ActionResult;

/**
 * Interface for all the surprise token to perform a generic operation.
 * COMMAND PATTERN
 */
public interface ISurpriseTokenCommand {

    /**
     * Perform a generic action.
     *
     * @return The action result
     */
    ActionResult execute();
    // void undo();
}

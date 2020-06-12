package com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken;

import com.univaq.stoneage.model.squares.ActionResult;

/**
 * Interface for all the surprise token.
 * COMMAND PATTERN
 */
public interface ISurpriseTokenCommand {

    ActionResult execute();
    // void undo();
}

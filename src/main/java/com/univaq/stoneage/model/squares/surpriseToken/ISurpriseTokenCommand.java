package com.univaq.stoneage.model.squares.surpriseToken;

import com.univaq.stoneage.model.squares.ActionResult;

public interface ISurpriseTokenCommand {
    void setReceiver(Object receiver);

    ActionResult execute();
    // void undo();
}

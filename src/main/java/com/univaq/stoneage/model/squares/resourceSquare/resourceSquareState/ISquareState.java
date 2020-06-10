package com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.ActionResult;

public interface ISquareState {
    ActionResult doSquareAction(MPlayer player);

    void addedResource();
}

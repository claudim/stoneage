package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.squares.ActionResult;

public interface IStateFactory {
    IGameState createState(ActionResult actionResult, GameState gameState);
}

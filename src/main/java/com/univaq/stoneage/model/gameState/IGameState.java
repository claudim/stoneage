package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.players.MPlayer;

public interface IGameState {

    // inserire un metodo per ogni comportamento da richiamare

    void initialize();

    void initState();

    void waitForTokenForest();

    void onNewSquare(int idForestToken);

    void doSquareAction();

    void hutBuilt(int idHutToken);

    void stealResource(MPlayer player);

    void endAction();

    void nextTurn();

    void winner();

    void takeAnotherTurn();
}

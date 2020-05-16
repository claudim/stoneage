package com.univaq.stoneage.model.gameState;

public interface IGameState {

    // inserire un metodo per ogni comportamento da richiamare
    void nextTurn();

//    void gotResource();
//
//    void hutTokenCheckDone();

    void winner();

    void onNewSquare(int idForestToken);

    void hutBuilt(int idHutToken);

    void initialize();

    void doSquareAction();

    void endAction();
}

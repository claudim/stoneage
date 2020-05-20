package com.univaq.stoneage.model.gameState;

public interface IGameState {

    // inserire un metodo per ogni comportamento da richiamare

    void initialize();

    void initState();

    void waitForTokenForest();

    void onNewSquare(int idForestToken);

    void doSquareAction();

    void hutBuilt(int idHutToken);

    void stealResource(String playerName);

    void endAction();

    void nextTurn();

    void winner();


}

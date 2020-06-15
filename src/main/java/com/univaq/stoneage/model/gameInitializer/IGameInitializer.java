package com.univaq.stoneage.model.gameInitializer;

import com.univaq.stoneage.model.MStoneAgeGame;


public interface IGameInitializer {

    void initializeStoneAgeGame(MStoneAgeGame mStoneAgeGame, String aMode, int aNumPlayers, String aMarkerName);
}

package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.hutTokens.MHutToken;
import com.univaq.stoneage.model.players.MPlayer;

import java.util.ArrayList;

public class BuildingHutGameState implements IGameState {
    private final GameState gameState;

    public BuildingHutGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void nextTurn() {
        System.out.println("nextTurn   BuildignHutGameState");
    }

    @Override
    public void winner() {
        System.out.println("winner   onBuildingHut");
    }

    @Override
    public void onNewSquare(int idForestToken) {
        System.out.println("onNewSquare   onBuildingHut");
    }

    @Override
    public void hutBuilt(int idHutToken) {
        System.out.println("hutBuilt   onBuildingHut");
        MPlayer activePlayer = MStoneAgeGame.getInstance().getCurrentPlayer();
        activePlayer.buildHut(idHutToken);
        MStoneAgeGame.getInstance().getM_grid().forestTokenShuffle();
        this.gameState.changeState(new EndTurnGameState(this.gameState));
    }

    @Override
    public void initialize() {

    }

    @Override
    public void doSquareAction() {
        MPlayer activePlayer = MStoneAgeGame.getInstance().getCurrentPlayer();
        ArrayList<MHutToken> m_playerBuildableMHutTokens = MStoneAgeGame.getInstance().getM_board().getBuildingSiteSquare().getM_playerBuildableMHutTokens();
        if (m_playerBuildableMHutTokens.size() == 0) {
            MStoneAgeGame.getInstance().getM_grid().forestTokenShuffle();
            this.gameState.changeState(new EndTurnGameState(this.gameState));
        } else {
            activePlayer.buildHut(m_playerBuildableMHutTokens);
        }
    }

    @Override
    public void endAction() {

    }
}

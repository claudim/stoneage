package com.univaq.stoneage.Model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoneAgeGameTest {
    private StoneAgeGame sag = new StoneAgeGame();


    @Test
    void playTurn() {
        sag.initializeStoneAgeGame("Rossa", 4, "Martin");
        /*sag.playTurn(1);
        assertEquals(sag.getM_players().firstElement().getM_marker().getCurrentSquare().getM_name(),"Cane");
        assertEquals(sag.getM_players().firstElement().getM_marker().getM_markerName(),"Martin");
        assertTrue(sag.getM_grid().getPosition(1).getTokenForest().getState());
        assertEquals(sag.getM_grid().getM_idPositionsFaceDownForestTokens().size(), 12);*/

        sag.playTurn(14);
        assertEquals(sag.getM_players().firstElement().getM_marker().getCurrentSquare().getM_name(),"campoDiBattaglia");
        assertEquals(sag.getM_players().firstElement().getM_marker().getM_markerName(),"Martin");
        assertTrue(sag.getM_grid().getPosition(14).getTokenForest().getState());
        assertEquals(sag.getM_grid().getM_idPositionsFaceDownForestTokens().size(), 12);

    }


    @Test
    void getNextPlayer() {
        sag.initializeStoneAgeGame("Rossa", 4, "Martin");
        assertEquals(sag.getNextPlayer().getM_marker().getM_markerName(), "Jono");

    }


    @Test
    void initializeStoneAgeGame() {
        sag.initializeStoneAgeGame("Rossa", 4, "Martin");
        assertEquals(sag.getM_players().size(), 4);
        assertEquals(sag.getM_players().firstElement().getClass().getSimpleName(), "HumanPlayer");
        assertEquals(sag.getM_players().elementAt(1).getClass().getSimpleName(), "EmulatedPlayer");
        assertEquals(sag.getM_players().firstElement().getM_marker().getCurrentSquare().getM_name(), "Cantiere");
        assertEquals(sag.getM_players().elementAt(1).getM_marker().getCurrentSquare().getM_name(), "Cantiere");
        assertEquals(sag.getM_players().elementAt(2).getM_marker().getCurrentSquare().getM_name(), "Cantiere");
        assertEquals(sag.getM_players().elementAt(3).getM_marker().getCurrentSquare().getM_name(), "Cantiere");
        assertEquals(sag.getM_players().elementAt(3).getM_marker().getCurrentSquare().getM_nextSquare().getM_name(), "Cane");
        assertEquals(sag.getM_players().firstElement().getM_marker().getM_markerName(), "Martin");
        assertEquals(sag.getM_board().getStartSquare().getM_name(), "Cantiere");
        assertEquals(sag.getM_board().getM_squares().size(), 10);
        assertEquals(sag.getM_board().getM_squares().firstElement().getM_name(), "Cantiere");
        assertEquals(sag.getM_board().getM_squares().firstElement().getM_nextSquare().getM_name(), "Cane");
        assertEquals(sag.getM_grid().getM_positions().size(), 16);
        assertFalse(sag.getM_grid().getM_positions().get(0).getTokenForest().getState());
        assertEquals(sag.getM_grid().getM_positions().get(1).getTokenForest().getValue(), "1");

    }
}
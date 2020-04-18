package com.univaq.stoneage.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MStoneAgeGameTest {
    private MStoneAgeGame sag = new MStoneAgeGame();


    @Test
    void playTurn() {
        sag.initializeStoneAgeGame("Rossa", 4, "Martin");
        sag.playTurn(1);
        assertEquals(sag.getM_players().get(0).getM_marker().getCurrentSquare().getM_name(),"Cane");
        assertEquals(sag.getM_players().get(0).getM_marker().getM_markerName(),"Martin");

        sag.playTurn(14);
        assertEquals(sag.getM_players().get(0).getM_marker().getCurrentSquare().getM_name(),"CampoDiBattaglia");
        assertEquals(sag.getM_players().get(0).getM_marker().getM_markerName(),"Martin");

    }


/*
    @Test
    void getNextPlayer() {
        sag.initializeStoneAgeGame("Rossa", 4, "Martin");
        assertEquals(sag.getNextPlayer().getM_marker().getM_markerName(), "Jono");

    }
*/


    @Test
    void initializeStoneAgeGame() {
        sag.initializeStoneAgeGame("Rossa", 4, "Martin");
        assertEquals(sag.getM_players().size(), 4);
        assertEquals(sag.getM_players().get(0).getClass().getSimpleName(), "HumanPlayer");
        assertEquals(sag.getM_players().get(1).getClass().getSimpleName(), "EmulatedPlayer");
        assertEquals(sag.getM_players().get(0).getM_marker().getCurrentSquare().getM_name(), "Cantiere");
        assertEquals(sag.getM_players().get(1).getM_marker().getCurrentSquare().getM_name(), "Cantiere");
        assertEquals(sag.getM_players().get(2).getM_marker().getCurrentSquare().getM_name(), "Cantiere");
        assertEquals(sag.getM_players().get(3).getM_marker().getCurrentSquare().getM_name(), "Cantiere");
        assertEquals(sag.getM_players().get(3).getM_marker().getCurrentSquare().getM_nextSquare().getM_name(), "Cane");
        assertEquals(sag.getM_players().get(0).getM_marker().getM_markerName(), "Martin");
        assertEquals(sag.getM_board().getStartSquare().getM_name(), "Cantiere");
        assertEquals(sag.getM_board().getM_squares().size(), 10);
        assertEquals(sag.getM_board().getM_squares().get(0).getM_name(), "Cantiere");
        assertEquals(sag.getM_board().getM_squares().get(0).getM_nextSquare().getM_name(), "Cane");
        assertEquals(sag.getM_grid().getM_tokens().size(), 16);

    }
}
package com.univaq.stoneage.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {


    @Test
    void moveMarker() {
        Board board = new Board();
        HumanPlayer player = new HumanPlayer("Martin", board.getStartSquare());
        player.moveMarker("Cava", board);
        assertEquals(player.getM_marker().getCurrentSquare().getM_name(), "Cava");
        player.moveMarker("3", board);
        assertEquals(player.getM_marker().getCurrentSquare().getM_name(), "Mercato");
    }
}
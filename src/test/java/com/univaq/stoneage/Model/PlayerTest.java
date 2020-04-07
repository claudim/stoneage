package com.univaq.stoneage.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void moveMarker() {
        Board board = new Board();
        HumanPlayer player = new HumanPlayer("Martin", board.getStartSquare());
        TokenForest tokenForest = new SquareTokenForest(13, "Cava");
        TokenForest tokenForest2 = new DieFaceTokenForest(3, 3);
        player.moveMarker(tokenForest, board);
        assertEquals(player.getM_marker().getCurrentSquare().getM_name(), "Cava");
        player.moveMarker(tokenForest2, board);
        assertEquals(player.getM_marker().getCurrentSquare().getM_name(), "Mercato");
    }
}
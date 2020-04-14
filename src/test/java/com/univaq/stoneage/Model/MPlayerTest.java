package com.univaq.stoneage.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MPlayerTest {

    @Test
    void moveMarker() {
        MBoard MBoard = new MBoard();
        MHumanPlayer player = new MHumanPlayer();
        player.createMarker("Martin", MBoard.getStartSquare());
        MTokenForest MTokenForest = new MSquareTokenForest(13, "Cava");
        MTokenForest MTokenForest2 = new MDieFaceTokenForest(3, 3);
        player.moveMarker(MTokenForest, MBoard);
        assertEquals(player.getM_marker().getCurrentSquare().getM_name(), "Cava");
        player.moveMarker(MTokenForest2, MBoard);
        assertEquals(player.getM_marker().getCurrentSquare().getM_name(), "Mercato");
    }
}
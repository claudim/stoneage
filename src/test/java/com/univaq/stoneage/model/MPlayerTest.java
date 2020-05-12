package com.univaq.stoneage.model;

import com.univaq.stoneage.model.forestTokens.MDieFaceTokenForest;
import com.univaq.stoneage.model.forestTokens.MSquareTokenForest;
import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.players.MHumanPlayer;
import com.univaq.stoneage.model.squares.MBoard;
import com.univaq.stoneage.model.squares.MSquare;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MPlayerTest {

    @Test
    void moveMarker() {
        MBoard MBoard = new MBoard();
        MHumanPlayer player = new MHumanPlayer();
        MSquare startSquare = MBoard.getStartSquare();
        if (startSquare != null) {
            player.createMarker("Martin", startSquare);
            MTokenForest MTokenForest = new MSquareTokenForest("Cava");
            MTokenForest MTokenForest2 = new MDieFaceTokenForest(3);
            player.moveMarker(MTokenForest, MBoard);
            assertEquals(player.getM_marker().getCurrentSquare().getM_name(), "Cava");
            player.moveMarker(MTokenForest2, MBoard);
            assertEquals(player.getM_marker().getCurrentSquare().getM_name(), "Mercato");
        }
    }
}
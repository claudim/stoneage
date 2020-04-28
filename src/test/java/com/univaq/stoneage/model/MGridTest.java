package com.univaq.stoneage.model;

import com.univaq.stoneage.model.forestTokens.MGrid;
import com.univaq.stoneage.model.forestTokens.MTokenForest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MGridTest {

    private final MGrid g = new MGrid();

    @Test
    void faceUpTokenForest() {
        MTokenForest MTokenForest = g.faceUpTokenForest(1);
        assertEquals(MTokenForest.getValue(), 1);
        assertTrue(g.searchTFbyPosition(1).getState());

       MTokenForest MTokenForest2 = g.faceUpTokenForest(11);
        assertEquals(MTokenForest2.getValue(), "foresta");
        assertTrue(g.searchTFbyPosition(11).getState());
        assertFalse(g.searchTFbyPosition(10).getState());
    }

}
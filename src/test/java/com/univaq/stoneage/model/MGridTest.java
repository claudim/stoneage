package com.univaq.stoneage.model;

import com.univaq.stoneage.model.forestTokens.MGrid;
import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.utility.TokenState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MGridTest {

    private final MGrid g = new MGrid();

    @Test
    void faceUpTokenForest() {
        MTokenForest MTokenForest = g.faceUpTokenForest(1);
        assertEquals(MTokenForest.getValue(), 1);
        assertEquals(g.searchTFbyId(1).getState(), TokenState.FACEUP);

        MTokenForest MTokenForest2 = g.faceUpTokenForest(11);
        assertEquals(MTokenForest2.getValue(), "foresta");
        assertEquals(g.searchTFbyId(11).getState(), TokenState.FACEUP);
        assertEquals(g.searchTFbyId(10).getState(), TokenState.FACEDOWN);
    }

}
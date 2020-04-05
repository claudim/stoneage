package com.univaq.stoneage.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    private Grid g = new Grid();

    @Test
    void chooseRandomTokenForest() {
        int id = g.chooseRandomTokenForest();
        assertTrue(0 <= id && id <= 15);
    }

    @Test
    void faceUpTokenForest() {
        Object tokenForestValue = g.faceUpTokenForest(1);
        assertEquals(tokenForestValue, 1);
        assertTrue(g.searchTFbyPosition(1).getState());

        Object tokenForestValue2 = g.faceUpTokenForest(11);
        assertEquals(tokenForestValue2, "foresta");
        assertTrue(g.searchTFbyPosition(11).getState());
        assertFalse(g.searchTFbyPosition(10).getState());


    }

}
package com.univaq.stoneage.Model;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board = new Board();

    @Test
    void findNewSquare() {

        Square currentSquare = board.getStartSquare();

        Square newSquare = board.findNewSquare(currentSquare,"1");
        assertEquals(newSquare.getM_name(), "Cane");
        newSquare = board.findNewSquare(currentSquare,"2");
        assertEquals(newSquare.getM_name(), "Sorpresa");
        newSquare = board.findNewSquare(currentSquare,"3");
        assertEquals(newSquare.getM_name(), "Prateria");
        newSquare = board.findNewSquare(currentSquare,"4");
        assertEquals(newSquare.getM_name(), "Foresta");
        newSquare = board.findNewSquare(currentSquare,"5");
        assertEquals(newSquare.getM_name(), "Artigiano");
        newSquare = board.findNewSquare(currentSquare,"6");
        assertEquals(newSquare.getM_name(), "Cava");
        newSquare = board.findNewSquare(currentSquare,"Cava");
        assertEquals(newSquare.getM_name(), "Cava");
        newSquare = board.findNewSquare(currentSquare,"Sorpresa");
        assertEquals(newSquare.getM_name(), "Sorpresa");


    }

}
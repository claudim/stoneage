package com.univaq.stoneage.Model;

public class HumanPlayer extends Player {
    public HumanPlayer(String aMarkerName, Square startSquare) {
        super(new Marker(aMarkerName, startSquare));
    }
}
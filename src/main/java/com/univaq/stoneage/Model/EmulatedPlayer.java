package com.univaq.stoneage.Model;

public class EmulatedPlayer extends Player {

    public EmulatedPlayer(String aMarkerName, Square startSquare) {
        super(new Marker(aMarkerName, startSquare));
    }
}
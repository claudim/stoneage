package com.univaq.stoneage.model;

import com.univaq.stoneage.model.squares.MSquare;

import java.util.ArrayList;

public interface ISquareFactory {
    ArrayList<MSquare> createSquares();
}

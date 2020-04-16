package com.univaq.stoneage.service;

import com.univaq.stoneage.Model.MSquare;

import java.util.List;

public interface ISquareManager {
    void addSquare(MSquare employee);

    List<MSquare> getAllSquares();

    void deleteSquare(String squareName);
}

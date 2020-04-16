package com.univaq.stoneage.persistence.dao;

import com.univaq.stoneage.Model.MSquare;

import java.util.List;

public interface ISquareDAO {
    //    Insert
    void addSquare(MSquare square);

    List<MSquare> getAllSquares();

    //    Delete
    void deleteSquare(String squareName);

}

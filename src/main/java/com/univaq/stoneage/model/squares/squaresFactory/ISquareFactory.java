package com.univaq.stoneage.model.squares.squaresFactory;

import com.univaq.stoneage.model.gameMode.GameMode;
import com.univaq.stoneage.model.squares.MSquare;

import java.util.ArrayList;

public interface ISquareFactory {
    ArrayList<MSquare> createSquares(GameMode mode);
}

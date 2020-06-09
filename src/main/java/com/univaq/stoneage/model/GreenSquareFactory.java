package com.univaq.stoneage.model;

import com.univaq.stoneage.dao.IGenericDAO;
import com.univaq.stoneage.dao.PersistenceServiceFactory;
import com.univaq.stoneage.model.squares.MSquare;

import java.util.ArrayList;

public class GreenSquareFactory implements ISquareFactory {

    @Override
    public ArrayList<MSquare> createSquares(GameMode mode) {
        IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MSquare.class.getSimpleName(), "verde");
        ArrayList<MSquare> squares = dao.findAll();
        for (MSquare square : squares) {
            square.setupSquare(mode);
        }
        return squares;
    }
}

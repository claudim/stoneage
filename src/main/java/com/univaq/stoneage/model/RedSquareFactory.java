package com.univaq.stoneage.model;

import com.univaq.stoneage.dao.IGenericDAO;
import com.univaq.stoneage.dao.PersistenceServiceFactory;
import com.univaq.stoneage.model.squares.MSquare;

import java.util.ArrayList;

public class RedSquareFactory implements ISquareFactory {

    @Override
    public ArrayList<MSquare> createSquares() {
        IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MSquare.class.getSimpleName());
        return dao.findAll();
    }
}

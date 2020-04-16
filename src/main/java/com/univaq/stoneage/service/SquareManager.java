package com.univaq.stoneage.service;

import com.univaq.stoneage.Model.MSquare;
import com.univaq.stoneage.persistence.dao.SquareDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SquareManager implements ISquareManager {

    //@Autowired
    private SquareDAO squareDao;

    @Override
    @Transactional
    public void addSquare(MSquare square) {
        squareDao.addSquare(square);
    }

    @Override
    @Transactional
    public List<MSquare> getAllSquares() {
        return squareDao.getAllSquares();
    }

    @Override
    @Transactional
    public void deleteSquare(String squareName) {
        squareDao.deleteSquare(squareName);
    }

    public void setSquareDao(SquareDAO squareDao) {
        this.squareDao = squareDao;
    }
}

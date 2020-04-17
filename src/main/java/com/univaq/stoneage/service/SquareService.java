package com.univaq.stoneage.service;

import com.univaq.stoneage.Model.MSquare;
import com.univaq.stoneage.repository.ISquareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SquareService implements ISquareService {

    @Autowired
    private ISquareRepository squareRepository;

    //    @Override
//    public void getAllSquares() {
//         squareRepository.findAll();
//    }
    @Override
    public List<MSquare> getAllSquares() {
        return squareRepository.findAll();
    }
}

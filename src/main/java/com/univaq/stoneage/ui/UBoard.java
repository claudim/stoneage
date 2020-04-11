package com.univaq.stoneage.ui;

import com.univaq.stoneage.Model.MSquare;
import com.univaq.stoneage.Model.MStoneAgeGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UBoard extends JPanel{

    private ArrayList<USquare> uSquares;
    private JPanel boardPanel;

    public int getSquareNumber() {
        return squareNumber;
    }

    private int squareNumber;

    public void initSquares(){
        uSquares = new ArrayList<>();
        boardPanel.removeAll();
        boardPanel.setLayout(new FlowLayout());
        ArrayList<MSquare> squares = MStoneAgeGame.getInstance().getAllSquare();
        this.squareNumber = squares.size();
        for (MSquare square : squares){
            USquare uSquare = new USquare(square.getM_name());
            uSquares.add(uSquare);
            boardPanel.add(uSquare.getSquarePane());
        }

    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }

    public USquare findUSquareByName(String name)
    {
        for(USquare usq: uSquares) {
            if (usq.getSquareName().equals(name)) {
                return usq;
            }
        }
        return null;
    }
}

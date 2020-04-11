package com.univaq.stoneage.ui;

import com.univaq.stoneage.Model.MSquare;
import com.univaq.stoneage.Model.MStoneAgeGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UBoard extends JPanel{

    private JPanel boardPanel;

    public int getSquareNumber() {
        return squareNumber;
    }

    private int squareNumber;

    public void initSquares(){

        boardPanel.removeAll();
        boardPanel.setLayout(new FlowLayout());
        ArrayList<MSquare> squares = MStoneAgeGame.getInstance().getAllSquare();
        this.squareNumber = squares.size();
        for (MSquare square : squares){
            USquare uSquare = new USquare(square.getM_name());
            boardPanel.add(uSquare.getSquarePane());
        }

    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }
}

package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MSquare;
import com.univaq.stoneage.model.MStoneAgeGame;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class UBoard extends JPanel implements PropertyChangeListener {

    private ArrayList<USquare> uSquares;
    private JPanel boardPanel;
    private JPanel leftPathPanel;
    private JPanel rightPathPanel;
    private JPanel topPathPanel;
    private JPanel bottomPathPanel;
    private JPanel topBottomPanel;
    private UGrid gridPanel;
    private JPanel panel1;
    //private UMarker currentMarker;

    public int getSquareNumber() {
        return squareNumber;
    }

    private int squareNumber;

    public void initSquares() {
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // trovati il marker del current player
        String[] propertyName = evt.getPropertyName().split("_");
        USquare newusq = this.findUSquareByName((String) evt.getNewValue()); // USquare of the newValue
        USquare oldusq = this.findUSquareByName((String) evt.getOldValue());// USquare of the oldValue
        UMarker uMarker = oldusq.getUMarkerByName(propertyName[0]);
        newusq.getuMarkers().add(uMarker);
        oldusq.getuMarkers().remove(uMarker);
        newusq.getMarkersPanel().setLayout(new GridLayout());
        newusq.getMarkersPanel().add(uMarker.getMarkerPanel());

    }

    public void init() {
        initSquares2();
        initGrid();

    }

    private void initGrid() {
        gridPanel.initGrid();
    }

    private void initSquares2() {
        uSquares = new ArrayList<>();
        ArrayList<MSquare> squares = MStoneAgeGame.getInstance().getAllSquare();

        leftPathPanel.setLayout(new GridLayout(2, 1));
        rightPathPanel.setLayout(new GridLayout(2, 1));
        topPathPanel.setLayout(new GridLayout(1, 3));
        bottomPathPanel.setLayout(new GridLayout(1, 3));

        USquare uSquare = new USquare(squares.get(0).getM_name());
        uSquares.add(uSquare);
        bottomPathPanel.add(uSquare.getSquarePane());

        USquare uSquare1 = new USquare(squares.get(1).getM_name());
        uSquares.add(uSquare1);
        bottomPathPanel.add(uSquare1.getSquarePane());

        USquare uSquare2 = new USquare(squares.get(2).getM_name());
        uSquares.add(uSquare2);
        bottomPathPanel.add(uSquare2.getSquarePane());

        USquare uSquare3 = new USquare(squares.get(3).getM_name());
        uSquares.add(uSquare3);
        leftPathPanel.add(uSquare3.getSquarePane());

        USquare uSquare4 = new USquare(squares.get(4).getM_name());
        uSquares.add(uSquare4);
        leftPathPanel.add(uSquare4.getSquarePane());

        USquare uSquare5 = new USquare(squares.get(5).getM_name());
        uSquares.add(uSquare5);
        topPathPanel.add(uSquare5.getSquarePane());

        USquare uSquare6 = new USquare(squares.get(6).getM_name());
        uSquares.add(uSquare6);
        topPathPanel.add(uSquare6.getSquarePane());

        USquare uSquare7 = new USquare(squares.get(7).getM_name());
        uSquares.add(uSquare7);
        topPathPanel.add(uSquare7.getSquarePane());

        USquare uSquare8 = new USquare(squares.get(8).getM_name());
        uSquares.add(uSquare8);
        rightPathPanel.add(uSquare8.getSquarePane());

        USquare uSquare9 = new USquare(squares.get(9).getM_name());
        uSquares.add(uSquare9);
        rightPathPanel.add(uSquare9.getSquarePane());

    }

//    public void setCurrentMarker(UMarker uMarker) {
//        this.currentMarker = uMarker;
//    }
//
//    public UMarker getCurrentMarker(){
//        return this.currentMarker;
//    }

}

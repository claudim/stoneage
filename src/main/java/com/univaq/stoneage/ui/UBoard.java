package com.univaq.stoneage.ui;

import com.univaq.stoneage.Model.MSquare;
import com.univaq.stoneage.Model.MStoneAgeGame;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class UBoard extends JPanel implements PropertyChangeListener {

    private ArrayList<USquare> uSquares;
    private JPanel boardPanel;
    //private UMarker currentMarker;

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

//    public void setCurrentMarker(UMarker uMarker) {
//        this.currentMarker = uMarker;
//    }
//
//    public UMarker getCurrentMarker(){
//        return this.currentMarker;
//    }

}

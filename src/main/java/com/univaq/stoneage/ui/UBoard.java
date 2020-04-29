package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MMarker;
import com.univaq.stoneage.model.squares.MResourceSquare;
import com.univaq.stoneage.model.squares.MSquare;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class UBoard extends JPanel implements PropertyChangeListener {

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
        for (MSquare square : squares) {
            USquare uSquare;
            if (square.getSquareType().equals(MResourceSquare.class.getSimpleName())) {
                uSquare = new UResourceSquare(square.getM_name());
            } else {
                uSquare = new USquare(square.getM_name());
            }
            square.addPropertyChangeListener(uSquare); // add uSquare observer to MSquare
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

        if (evt.getPropertyName().equals("square")) {
            try {
                MMarker marker = (MMarker) evt.getSource();
                USquare newusq = this.findUSquareByName((String) evt.getNewValue()); // USquare of the newValue
                USquare oldusq = this.findUSquareByName((String) evt.getOldValue());// USquare of the oldValue
                UMarker uMarker = oldusq.getUMarkerByName(marker.getM_markerName());
                if (newusq.getuMarkers().size() == 0) {
                    newusq.getMarkersPanel().setLayout(new GridLayout());
                }
                newusq.getuMarkers().add(uMarker);
                oldusq.getuMarkers().remove(uMarker);
                newusq.getMarkersPanel().add(uMarker.getMarkerPanel());
                newusq.getMarkersPanel().revalidate();
                newusq.getMarkersPanel().repaint();
                if (oldusq.getuMarkers().size() == 0) {
                    oldusq.getMarkersPanel().remove(uMarker.getMarkerPanel());
                    oldusq.getMarkersPanel().revalidate();
                    oldusq.getMarkersPanel().repaint();
                }
            } catch (Exception e) {
                System.out.println("errore");
            }
        }


    }

//    public void setCurrentMarker(UMarker uMarker) {
//        this.currentMarker = uMarker;
//    }
//
//    public UMarker getCurrentMarker(){
//        return this.currentMarker;
//    }

}

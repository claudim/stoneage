package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MMarker;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.buildingSiteSquare.MBuildingSiteSquare;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * GUI class for representing the board, it contains squares
 */
public class UBoard extends JPanel implements PropertyChangeListener {

    /* List containing squares to display on the board */
    private ArrayList<USquare> uSquares;
    private JPanel boardPanel;

    public int getSquareNumber() {
        return squareNumber;
    }

    private int squareNumber;

    /**
     * Square initializer, it renders squares in the right way on the board
     */
    public void initSquares() {
        uSquares = new ArrayList<>();
        boardPanel.removeAll();
        boardPanel.setLayout(new FlowLayout());
        ArrayList<MSquare> squares = MStoneAgeGame.getInstance().getAllSquare();
        this.squareNumber = squares.size();
        for (MSquare square : squares) {
            USquare uSquare;
            //todo usare una factory?
            if (square.getSquareType().equals(MResourceSquare.class.getSimpleName())) {
                uSquare = new UResourceSquare(square.getM_name());
            } else if (square.getSquareType().equals(MBuildingSiteSquare.class.getSimpleName())) {
                uSquare = new UBuildingSiteSquare(square.getM_name());
                ((UBuildingSiteSquare) uSquare).setHutTokens(((MBuildingSiteSquare) square).getFaceUpHutTokens());
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

    /**
     * Finds square by name
     *
     * @param name name of the square to search
     * @return the found square
     */
    public USquare findUSquareByName(String name) {
        for (USquare usq : uSquares) {
            if (usq.getSquareName().equals(name)) {
                return usq;
            }
        }
        return null;
    }

    /**
     * Property change listener, it observes changes on the squares in the model
     *
     * @param evt event fired in the model
     */
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

}

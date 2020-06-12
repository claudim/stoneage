package com.univaq.stoneage.ui;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * Superclass for all kind of squares
 */
public class USquare extends JPanel implements PropertyChangeListener {

    private JPanel squarePanel;
    private ArrayList<UMarker> uMarkers;
    private JLabel squareName;
    private JPanel markersPanel;
    protected JPanel childPanel;

    public USquare(String name) {
        super();
        this.uMarkers = new ArrayList<>();
        this.squareName.setText(name);
        squareName.setPreferredSize(new Dimension(-1, 100));
        childPanel.setLayout(new GridLayout());
    }

    public JPanel getMarkersPanel() {
        return markersPanel;
    }

    public JPanel getSquarePane() {
        return squarePanel;
    }

    public String getSquareName() {
        return this.squareName.getText();
    }

    public ArrayList<UMarker> getuMarkers() {
        return uMarkers;
    }

    public void setuMarkers(ArrayList<UMarker> uMarkers) {
        this.uMarkers = uMarkers;
    }

    /**
     * Search markers on the square with the given name
     *
     * @param markerName the name of the marker
     * @return the marker found if is on the square, null otherwise
     */
    public UMarker getUMarkerByName(String markerName) {
        for (UMarker uMarker : uMarkers) {
            if (uMarker.getMarkerName().equals(markerName))
                return uMarker;
        }
        return null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}

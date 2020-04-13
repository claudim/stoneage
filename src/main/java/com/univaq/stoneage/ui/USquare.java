package com.univaq.stoneage.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class USquare extends JPanel {

    private JPanel squarePanel;
    private ArrayList<UMarker> uMarkers;

    private JLabel squareName;

    private JPanel markersPanel;

    public USquare(String name) {
            super();
            this.uMarkers = new ArrayList<>();
            this.squareName.setText(name);
            this.squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.squarePanel.setPreferredSize(new Dimension(100, 150));
    }

    public JPanel getMarkersPanel() {
        return markersPanel;
    }

    public JPanel getSquarePane() {
       return squarePanel;
    }

    public String getSquareName()
    {
        return this.squareName.getText();
    }

    public ArrayList<UMarker> getuMarkers() {
        return uMarkers;
    }

    public void setuMarkers(ArrayList<UMarker> uMarkers) {
        this.uMarkers = uMarkers;
    }

    public UMarker getUMarkerByName(String markerName){
        for (UMarker uMarker: uMarkers)
        {
            if (uMarker.getMarkerName().equals(markerName))
                return uMarker;
        }
        return null;
    }
}

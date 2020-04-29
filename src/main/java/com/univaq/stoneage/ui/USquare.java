package com.univaq.stoneage.ui;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

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
        this.setUSquareStyle();
        childPanel.setLayout(new GridLayout());
    }


    private void setUSquareStyle() {
        squarePanel.setLayout(new GridLayout(0, 1));
        squareName.setHorizontalAlignment(JLabel.CENTER);
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

    public UMarker getUMarkerByName(String markerName) {
        for (UMarker uMarker : uMarkers) {
            if (uMarker.getMarkerName().equals(markerName))
                return uMarker;
        }
        return null;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

//        if (evt.getPropertyName().equals("square")) {
//            try {
//                MMarker marker = (MMarker) evt.getSource();
//                String newUSquareName = (String) evt.getNewValue();
//                String oldUSquareName = (String) evt.getOldValue();
//                if (newUSquareName.equals(this.squareName.getText()))
//                {
//
//                    this.getMarkersPanel().add(uMarker.getMarkerPanel());
//                }
//                if (oldUSquareName.equals(this.squareName.getText()))
//                {
//                    UMarker uMarker = this.getUMarkerByName(marker.getM_markerName());
//                    this.getMarkersPanel().remove(uMarker.getMarkerPanel());
//                    this.getuMarkers().remove(uMarker);
//
//                }
//                UMarker uMarker = oldusq.getUMarkerByName(marker.getM_markerName());
//                newusq.getuMarkers().add(uMarker);
//                oldusq.getuMarkers().remove(uMarker);
//                newusq.getMarkersPanel().setLayout(new GridLayout());
//                newusq.getMarkersPanel().add(uMarker.getMarkerPanel());
//
//            } catch (Exception e) {
//
//            }
//        }

    }


}

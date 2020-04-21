package com.univaq.stoneage.ui;

import com.univaq.stoneage.utility.PlayerColors;

import javax.swing.*;

public class UMarker extends JPanel {
    private JPanel markerPanel;
    private JLabel markerLabel;
    private String markerName;

    //TODO i nomi dei player vanno recuperati da qualche parte

    public String getMarkerName() {
        return this.markerName;
    }

    public void setMarkerName(String markerName) {
        this.markerName = markerName;
    }

    public void setMarkerPanel(JPanel markerPanel) {
        this.markerPanel = markerPanel;
    }

    public JPanel getMarkerPanel() {
        return markerPanel;
    }

    public void markerStyle(){
        this.markerLabel.setText("  ");
        String n = this.markerName.toUpperCase();
        this.markerLabel.setBackground(PlayerColors.valueOf(n).markerColor);
        this.markerLabel.setOpaque(true);

    }

}
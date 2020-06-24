package com.univaq.stoneage.ui.players;

import com.univaq.stoneage.utility.PlayerColors;

import javax.swing.*;

/**
 * Sets marker style and displays it on squares
 */
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

    /**
     * Sets the style of the marker
     */
    public void markerStyle() {
        this.markerLabel.setText("  ");
        String n = this.markerName.toUpperCase();
        this.markerLabel.setBackground(PlayerColors.valueOf(n).markerColor);
        this.markerLabel.setOpaque(true);

    }

}
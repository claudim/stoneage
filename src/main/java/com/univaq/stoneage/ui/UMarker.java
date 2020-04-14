package com.univaq.stoneage.ui;

import javax.swing.*;
import java.awt.*;

public class UMarker extends JPanel {
    private JPanel markerPanel;
    private JLabel markerLabel;
    private String markerName;

    //TODO i nomi dei player vanno recuperati da qualche parte
    private enum Colori {
        JONO(Color.blue),
        JADA(Color.magenta),
        GUFF(Color.green),
        MARTIN(Color.yellow);

        public final Color markerColor;

        Colori(Color label) {
            this.markerColor = label;
        }
    }

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
        this.markerLabel.setBackground(Colori.valueOf(n).markerColor);
        this.markerLabel.setOpaque(true);

    }

}
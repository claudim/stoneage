package com.univaq.stoneage.ui;

import javax.swing.*;
import java.awt.*;

public class UMarker extends JPanel {
    private JPanel markerPanel;
    private JLabel markerLabel;

    public void setMarkerName(String markerName) {
        this.markerName = markerName;
    }

    private String markerName;


    private enum Colori {
        JONO(Color.blue),
        JADA(Color.magenta),
        GUFF(Color.green),
        MARTIN(Color.yellow);

        public final Color markerColor;

        private Colori(Color label) {
            this.markerColor = label;
        }
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
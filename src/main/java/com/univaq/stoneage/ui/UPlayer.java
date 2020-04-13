package com.univaq.stoneage.ui;

import javax.swing.*;
import java.awt.*;

public class UPlayer extends JPanel {


    private JLabel playerName;
    private JPanel playerPanel;
    private String name;


    public void playerStyle() {
        String n = name.toUpperCase();
        this.playerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.playerPanel.setPreferredSize(new Dimension(100, 100));
        this.playerName.setBackground(Colori.valueOf(n).markerColor);
        this.playerName.setOpaque(true);
    }

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

    @Override
    public void setName(String name) {
        this.playerName.setText(name);
        this.name = name;

    }

    public JPanel getPlayerPanel() {
        return playerPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

package com.univaq.stoneage.ui;

import javax.swing.*;
import java.awt.*;

public class UPlayer extends JPanel {


    private JLabel playerName;
    private JPanel playerPanel;

    public UPlayer() {
        super();
        this.playerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.playerPanel.setPreferredSize(new Dimension(100, 150));
    }

    @Override
    public void setName(String name) {
        this.playerName.setText(name);
    }

    public JPanel getPlayerPanel() {
        return playerPanel;
    }
}

package com.univaq.stoneage.ui;

import javax.swing.*;

public class UPlayer extends JPanel{


    private JLabel playerName;
    private JPanel playerPanel;

    @Override
    public void setName(String name) {
        this.playerName.setText(name);
    }

    public JPanel getPlayerPanel() {
        return playerPanel;
    }
}

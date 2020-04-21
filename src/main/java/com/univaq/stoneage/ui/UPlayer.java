package com.univaq.stoneage.ui;

import com.univaq.stoneage.utility.PlayerColors;

import javax.swing.*;
import java.awt.*;

public class UPlayer extends JPanel {

    private JLabel playerName;
    private JPanel playerPanel;

    @Override
    public String getName() {
        return name;
    }

    private String name;

    public void playerStyle() {
        String n = name.toUpperCase();
        this.playerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.playerPanel.setPreferredSize(new Dimension(100, 100));
        this.playerName.setBackground(PlayerColors.valueOf(n).markerColor);
        this.playerName.setOpaque(true);
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

    public void setCurrentPlayer(boolean currentPlayer){
        if(currentPlayer) {
            this.playerName.setText(name.toUpperCase());
        }
        else this.playerName.setText(name.toLowerCase());
    }
}

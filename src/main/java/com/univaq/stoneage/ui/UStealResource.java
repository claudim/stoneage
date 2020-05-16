package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MStoneAgeGame;

import javax.swing.*;

public class UStealResource {
    private JPanel stealResourcePanel;
    private JLabel stealResourceLabel;
    private JPanel stealResourceButtonsPanel;

    public UStealResource() {
        setLabel("Da chi vuoi prendere la risorsa?");
        intiButtons();
    }

    public void setLabel(String label) {
        stealResourceLabel.setText(label);
    }

    public void intiButtons() {
        MStoneAgeGame.getInstance().getM_players().forEach(mPlayer -> {
            JButton button = new JButton(mPlayer.getMarkerName());
            button.setActionCommand(button.getText());
            button.addActionListener(e -> onClick(e.getActionCommand()));
            stealResourceButtonsPanel.add(button);
        });

    }

    private void onClick(String playerName) {
        //ruba la risorsa al player indicato
        MStoneAgeGame.getInstance().stealResource(playerName);
    }
}

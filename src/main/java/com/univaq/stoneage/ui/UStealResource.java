package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MStoneAgeGame;

import javax.swing.*;

/**
 * Page shown when player is going to steal a resource
 */
public class UStealResource {
    public JPanel getStealResourcePanel() {
        return stealResourcePanel;
    }

    public void setStealResourcePanel(JPanel stealResourcePanel) {
        this.stealResourcePanel = stealResourcePanel;
    }

    private JPanel stealResourcePanel;
    private JLabel stealResourceLabel;
    /* Holds button to choose from which player steal*/
    private JPanel stealResourceButtonsPanel;

    /**
     * Constructor
     */
    public UStealResource() {
        setLabel("Da chi vuoi prendere la risorsa?");
        intiButtons();
    }

    public void setLabel(String label) {
        stealResourceLabel.setText(label);
    }

    /**
     * Display buttons to choose from which player steal a resource
     */
    public void intiButtons() {
        MStoneAgeGame.getInstance().getM_players().forEach(mPlayer -> {
            if (!mPlayer.getMarkerName().equals(MStoneAgeGame.getInstance().getActivePlayer().getMarkerName())) {
                JButton button = new JButton(mPlayer.getMarkerName());
                button.setActionCommand(button.getText());
                button.addActionListener(e -> onClick(e.getActionCommand()));
                stealResourceButtonsPanel.add(button);
            }
        });

    }

    private void onClick(String playerName) {
        UMainFrame.getInstance().getMainContainer().remove(this.getStealResourcePanel());
        UMainFrame.getInstance().getRootPane().repaint();
        //ruba la risorsa al player indicato
        MStoneAgeGame.getInstance().stealResource(playerName);

    }
}

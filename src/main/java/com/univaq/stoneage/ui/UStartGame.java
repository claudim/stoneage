package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MStoneAgeGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Start game page
 */
public class UStartGame extends JPanel {
    public JPanel getContentPane() {
        return contentPane;
    }

    private JPanel contentPane;
    private JButton playButton;
    private JButton tutorialButton;
    private JPanel content;
    private JPanel buttons;
    private JLabel winnerLabel;
    private JPanel optionsPanel;
    private JComboBox playerComboBox;
    private JComboBox modeComboBox;

    /**
     * Constructor
     */
    public UStartGame() {

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPlay();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onTutorial();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public void setWinnerName(String winnerName) {
        winnerLabel.setText(winnerName + " ha vinto!");
    }

    private void onPlay() {
        playButton.setEnabled(false);
        MStoneAgeGame.resetInstance();
        MStoneAgeGame.getInstance().playStoneAge(modeComboBox.getSelectedItem().toString(), 4, playerComboBox.getSelectedItem().toString());
        UMainFrame.getInstance().setGamePage();
        MStoneAgeGame.getInstance().getM_gameState().addPropertyChangeListener(UMainFrame.getInstance());
        UMainFrame.getInstance().setVisible(true);
    }

    private void onTutorial() {
        // add your code here if necessary
//        dispose();
    }

}

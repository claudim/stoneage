package com.univaq.stoneage.ui;

import javax.swing.*;
import java.awt.event.*;

public class StartGame extends JDialog {
    private JPanel contentPane;
    private JButton playButton;
    private JButton tutorialButton;
    private JButton tutorialButton1;

    public StartGame() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(playButton);

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPlay();
            }
        });

        tutorialButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onTutorial();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onTutorial();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onTutorial();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onPlay() {
        // add your code here
        dispose();
    }

    private void onTutorial() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        StartGame dialog = new StartGame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

package com.univaq.stoneage.ui;

import com.univaq.stoneage.Model.MStoneAgeGame;

import javax.swing.*;
import java.awt.event.*;

public class UStartGame extends JPanel {
    public JPanel getContentPane() {
        return contentPane;
    }

    private JPanel contentPane;
    private JButton playButton;
    private JButton tutorialButton;
    private JPanel content;
    private JPanel buttons;

    public UStartGame() {

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPlay();
            }
        });

       /* tutorialButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onTutorial();
            }
        });*/

        // call onCancel() when cross is clicked
//        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                onTutorial();
//            }
//        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onTutorial();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onPlay() {
        playButton.setEnabled(false);
        MStoneAgeGame.getInstance().initializeStoneAgeGame("Rossa", 4, "Martin");
        UMainFrame.getInstance().setGamePage();
        UMainFrame.getInstance().setVisible(true);
    }



    private void onTutorial() {
        // add your code here if necessary
//        dispose();
    }

}

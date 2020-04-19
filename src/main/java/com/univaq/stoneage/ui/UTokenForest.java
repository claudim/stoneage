package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MStoneAgeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UTokenForest extends JButton {
    private String tokenValue;
    private int position;
    private  boolean state = false; //facedown= false

    public boolean isFaceUp() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }


    public UTokenForest(String tokenValue, int position) {
        super();
        this.tokenValue = tokenValue;
        this.position = position;

        this.setContentAreaFilled(true);
        this.setOpaque(true);
        this.setBackground(new Color(10, 93, 0));
        this.setForeground(Color.ORANGE);
        this.setPreferredSize(new Dimension(150, 70));

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
    }

    private void onClick() {
        this.setText(this.tokenValue);
        this.setState(true);
        UMainFrame.getInstance().getuGamePlane().getuGrid().disableAllTokens();
        MStoneAgeGame.getInstance().playTurn(this.position);
        UMainFrame.getInstance().getuGamePlane().getuGrid().ableAllTokensFaceDown();
    }
}

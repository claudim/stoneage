package com.univaq.stoneage.ui;

import com.univaq.stoneage.Model.MStoneAgeGame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UTokenForest extends JButton {
    private String tokenValue;
    private int position;

    public UTokenForest(String tokenValue, int position) {
        super();
        this.tokenValue = tokenValue;
        this.position = position;


        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
    }

    private void onClick() {
        this.setText(this.tokenValue);
        MStoneAgeGame.getInstance().playTurn(this.position);
    }


}

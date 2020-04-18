package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MStoneAgeGame;

import javax.swing.*;
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


        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
    }

    private void onClick() {
        this.setText(this.tokenValue);
        this.setState(true);
        UMainFrame.getInstance().getuGameBoard().getuGrid().disableAllTokens();
        MStoneAgeGame.getInstance().playTurn(this.position);
        UMainFrame.getInstance().getuGameBoard().getuGrid().ableAllTokensFaceDown();
    }
}

package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.utility.TokenState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UTokenForest extends JButton implements PropertyChangeListener {
    private String tokenValue;
    private int idToken;
    private TokenState state = TokenState.FACEDOWN;

    public UTokenForest(String tokenValue, int idToken) {
        super();
        this.tokenValue = tokenValue;
        this.idToken = idToken;

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
    }

    public TokenState getState() {
        return state;
    }

    public void setState(TokenState state) {
        this.state = state;
    }

    public int getIdToken() {
        return idToken;
    }

    public void setIdToken(int idToken) {
        this.idToken = idToken;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }


    private void onClick() {
        UMainFrame.getInstance().getuGameBoard().getuGrid().disableAllTokens();
        MStoneAgeGame.getInstance().playTurn(this.idToken);
        UMainFrame.getInstance().getuGameBoard().getuGrid().enableAllTokensFaceDown();
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals("token_state")) {
            MTokenForest mTokenForest = (MTokenForest) evt.getSource();
            if (mTokenForest.getValue().toString().equals(tokenValue)) {
                setState((TokenState) evt.getNewValue());
                if (state.equals(TokenState.FACEUP)) {
                    this.setText(this.tokenValue);
                } else {
                    this.setText("");
                    this.setEnabled(true);
                }
            }
        }
    }
}

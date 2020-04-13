package com.univaq.stoneage.ui;

import com.univaq.stoneage.Model.MStoneAgeGame;
import com.univaq.stoneage.Model.MTokenForest;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UGrid extends JPanel {

    public ArrayList<UTokenForest> getUTokenForests() {
        return uTokenForests;
    }

    private ArrayList<UTokenForest> uTokenForests;

    private JPanel gridPanel;

    public void setGridPanel(JPanel gridPanel) {
        this.gridPanel = gridPanel;
    }

    public JPanel getGridPanel() {
        return gridPanel;
    }

    public void initGrid(){
        this.uTokenForests = new ArrayList<>();
        gridPanel.removeAll();
        //todo dimensionare la griglia in modo dinamico???
        gridPanel.setLayout(new GridLayout(4, 4, 15, 5));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(40, 150, 40, 150));
        for (MTokenForest tf : MStoneAgeGame.getInstance().getAllTokenForest()) {
            UTokenForest buttonTF = new UTokenForest(tf.getValue().toString(), tf.getM_position());
            buttonTF.setContentAreaFilled(true);
            buttonTF.setOpaque(true);
            buttonTF.setBackground(new Color(10, 93, 0));
            buttonTF.setForeground(Color.ORANGE);
            this.uTokenForests.add(buttonTF);
            gridPanel.add(buttonTF);
        }

    }

    public void disableAllTokens(){
        for (UTokenForest utf : this.uTokenForests) {
            utf.setEnabled(false);
        }
    }

    public void ableAllTokens(){
        for (UTokenForest utf : this.uTokenForests) {
            utf.setEnabled(true);
        }
    }

    public void ableAllTokensFaceDown(){
        for (UTokenForest utf : this.uTokenForests) {
            if (!utf.isFaceUp())
            {
                utf.setEnabled(true);
            }
        }
    }
}

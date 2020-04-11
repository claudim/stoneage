package com.univaq.stoneage.ui;

import com.univaq.stoneage.Model.MStoneAgeGame;
import com.univaq.stoneage.Model.MTokenForest;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UGrid extends JPanel {

    private ArrayList<UTokenForest> tokenForests;

    private JPanel gridPanel;

    public void setGridPanel(JPanel gridPanel) {
        this.gridPanel = gridPanel;
    }

    public JPanel getGridPanel() {
        return gridPanel;
    }

    public void initGrid(){

        gridPanel.removeAll();
        //todo dimensionare la griglia in modo dinamico???
        gridPanel.setLayout(new GridLayout(4, 4));
        for (MTokenForest tf : MStoneAgeGame.getInstance().getAllTokenForest()) {
            UTokenForest buttonTF = new UTokenForest(tf.getValue().toString(), tf.getM_position());
            buttonTF.setContentAreaFilled(true);
            buttonTF.setOpaque(true);
            buttonTF.setBackground(new Color(10, 93, 0));
            buttonTF.setForeground(Color.ORANGE);
            gridPanel.add(buttonTF);
        }

    }
}

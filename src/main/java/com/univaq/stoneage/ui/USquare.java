package com.univaq.stoneage.ui;

import javax.swing.*;
import java.awt.*;

public class USquare extends JPanel {

    private JPanel squarePanel;

    public JPanel getSquarePanel() {
        return squarePanel;
    }

    private JLabel squareName;

    public USquare(String name) {
            super();
            this.squareName.setText(name);
            this.squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.squarePanel.setPreferredSize(new Dimension(100, 150));
    }

    public JPanel getSquarePane() {
       return squarePanel;
    }

    public String getSquareName()
    {
        return this.squareName.getText();
    }
}

package com.univaq.stoneage.ui;

import javax.swing.*;
import java.awt.*;

public class USquare extends JPanel {

    private JPanel squarePanel;
    private JLabel squareName;

    public USquare(String name) {
            super();
            this.squareName.setText(name);
            this.squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public JPanel getSquarePane() {
       return squarePanel;
    }

}

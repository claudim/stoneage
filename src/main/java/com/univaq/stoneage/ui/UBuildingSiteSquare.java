package com.univaq.stoneage.ui;

import javax.swing.*;
import java.awt.*;

public class UBuildingSiteSquare extends USquare {

    private JPanel HutTokenPanel;
    private JButton buildButton1;
    private JButton buildButton2;
    private JButton buildButton3;
    private JPanel resourcesHut1Panel;
    private JPanel resourcesHut2Panel;
    private JPanel resourcesHut3Panel;


    public UBuildingSiteSquare(String name) {
        super(name);
        childPanel.add(HutTokenPanel);
//        MHutToken hutToken = MStoneAgeGame.getInstance().getNewHutToken();
        resourcesHut1Panel.setLayout(new GridLayout(0, 1));
        resourcesHut1Panel.add(new JLabel("ciao"));
        resourcesHut1Panel.add(new JLabel("ciao2"));
        resourcesHut1Panel.add(new JLabel("ciao3"));

    }

}

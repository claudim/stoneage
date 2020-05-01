package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MHutToken;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UBuildingSiteSquare extends USquare {

    private JPanel HutTokenPanel;
    private JButton buildButton1;
    private JButton buildButton2;
    private JButton buildButton3;
    private JPanel resourcesHut1Panel;
    private JPanel resourcesHut2Panel;
    private JPanel resourcesHut3Panel;
    private JPanel hut1Panel;
    private JPanel hut2Panel;
    private JPanel hut3Panel;


    public UBuildingSiteSquare(String name) {
        super(name);
        childPanel.add(HutTokenPanel);
//        MHutToken hutToken = MStoneAgeGame.getInstance().getNewHutToken();
        resourcesHut1Panel.setLayout(new GridLayout(0, 1));
        resourcesHut2Panel.setLayout(new GridLayout(0, 1));
        resourcesHut3Panel.setLayout(new GridLayout(0, 1));

    }

    public void setHutTokens(ArrayList<MHutToken> faceUpHutTokens) {

        faceUpHutTokens.get(0).getM_resources().forEach((key, value) -> resourcesHut1Panel.add(new JLabel(key.getM_type() + ": " + value)));
        faceUpHutTokens.get(1).getM_resources().forEach((key, value) -> resourcesHut2Panel.add(new JLabel(key.getM_type() + ": " + value)));
        faceUpHutTokens.get(2).getM_resources().forEach((key, value) -> resourcesHut3Panel.add(new JLabel(key.getM_type() + ": " + value)));
    }
}

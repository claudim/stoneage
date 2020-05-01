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

        faceUpHutTokens.get(0).getResources().entrySet().stream().forEach(e -> resourcesHut1Panel.add(new JLabel(e.getKey() + ": " + e.getValue())));
        faceUpHutTokens.get(1).getResources().entrySet().stream().forEach(e -> resourcesHut2Panel.add(new JLabel(e.getKey() + ": " + e.getValue())));
        faceUpHutTokens.get(2).getResources().entrySet().stream().forEach(e -> resourcesHut3Panel.add(new JLabel(e.getKey() + ": " + e.getValue())));
//        resourcesHut1Panel.add(new JLabel());
//        resourcesHut1Panel.add(new JLabel("ciao2"));
//        resourcesHut1Panel.add(new JLabel("ciao3"));
//        resourcesHut2Panel.add(new JLabel("ciao"));
//        resourcesHut2Panel.add(new JLabel("ciao2"));
//        resourcesHut2Panel.add(new JLabel("ciao3"));
//        resourcesHut3Panel.add(new JLabel("ciao"));
//        resourcesHut3Panel.add(new JLabel("ciao2"));
//        resourcesHut3Panel.add(new JLabel("ciao3"));
    }
}

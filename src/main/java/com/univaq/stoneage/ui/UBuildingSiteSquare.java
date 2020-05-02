package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MHutToken;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    private final Map<Integer, JButton> buttonHutTokenMapping = new HashMap<>();

    public UBuildingSiteSquare(String name) {
        super(name);
        childPanel.add(HutTokenPanel);
//        MHutToken hutToken = MStoneAgeGame.getInstance().getNewHutToken();
        resourcesHut1Panel.setLayout(new GridLayout(0, 1));
        resourcesHut2Panel.setLayout(new GridLayout(0, 1));
        resourcesHut3Panel.setLayout(new GridLayout(0, 1));

    }

    public void setHutTokens(ArrayList<MHutToken> faceUpHutTokens) {
        faceUpHutTokens.forEach(this::subscribe);
        faceUpHutTokens.get(0).getM_resources().forEach((key, value) -> resourcesHut1Panel.add(new JLabel(key.getM_type() + ": " + value)));
        buttonHutTokenMapping.put(faceUpHutTokens.get(0).getIdHutToken(), buildButton1);
        faceUpHutTokens.get(1).getM_resources().forEach((key, value) -> resourcesHut2Panel.add(new JLabel(key.getM_type() + ": " + value)));
        buttonHutTokenMapping.put(faceUpHutTokens.get(1).getIdHutToken(), buildButton2);
        faceUpHutTokens.get(2).getM_resources().forEach((key, value) -> resourcesHut3Panel.add(new JLabel(key.getM_type() + ": " + value)));
        buttonHutTokenMapping.put(faceUpHutTokens.get(2).getIdHutToken(), buildButton3);
    }

    public void subscribe(MHutToken hutToken) {
        hutToken.addPropertyChangeListener(this); // add uSquare observer to MHutToken
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("hutTokenBuildable")) {
            MHutToken mHutToken = (MHutToken) evt.getSource();
            //abilita o diabilita il button
            buttonHutTokenMapping.get(mHutToken.getIdHutToken()).setEnabled((boolean) evt.getNewValue());

        }
    }
}

package com.univaq.stoneage.ui;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.hutTokens.MHutToken;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Building site square. Holds huts to build
 */
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

    /**
     * Constructor
     *
     * @param name name
     */
    public UBuildingSiteSquare(String name) {
        super(name);
        childPanel.add(HutTokenPanel);
//        MHutToken hutToken = MStoneAgeGame.getInstance().getNewHutToken();
        resourcesHut1Panel.setLayout(new GridLayout(0, 1));
        resourcesHut2Panel.setLayout(new GridLayout(0, 1));
        resourcesHut3Panel.setLayout(new GridLayout(0, 1));

        buildButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPlay(buildButton1);
            }
        });
        buildButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPlay(buildButton2);
            }
        });
        buildButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPlay(buildButton3);
            }
        });

    }

    /**
     * Display hut tokens that can be built by the players
     *
     * @param faceUpHutTokens hut tokens buildable
     */
    public void setHutTokens(ArrayList<MHutToken> faceUpHutTokens) {
        faceUpHutTokens.forEach(this::subscribe);
        faceUpHutTokens.get(0).getM_resources().forEach((key, value) -> resourcesHut1Panel.add(new JLabel(key.getM_type() + ": " + value)));
        buttonHutTokenMapping.put(faceUpHutTokens.get(0).getIdToken(), buildButton1);
        faceUpHutTokens.get(1).getM_resources().forEach((key, value) -> resourcesHut2Panel.add(new JLabel(key.getM_type() + ": " + value)));
        buttonHutTokenMapping.put(faceUpHutTokens.get(1).getIdToken(), buildButton2);
        faceUpHutTokens.get(2).getM_resources().forEach((key, value) -> resourcesHut3Panel.add(new JLabel(key.getM_type() + ": " + value)));
        buttonHutTokenMapping.put(faceUpHutTokens.get(2).getIdToken(), buildButton3);
    }

    public void subscribe(MHutToken hutToken) {
        hutToken.addPropertyChangeListener(this); // add uSquare observer to MHutToken
    }

    /**
     * Listens if the hut is buildable by the player landed on the square.
     *
     * @param evt
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("hutTokenBuildable")) {
            MHutToken mHutToken = (MHutToken) evt.getSource();
            //enable or disable the button
            buttonHutTokenMapping.get(mHutToken.getIdToken()).setEnabled((((Boolean) evt.getNewValue()).booleanValue()));
        }

        if (evt.getPropertyName().equals("hutTokenRemoved")) {
            MHutToken mHutTokenRemoved = (MHutToken) evt.getOldValue();
            JButton buttonToReplace = buttonHutTokenMapping.get(mHutTokenRemoved.getIdToken());
            // delete from buttonHutTokenMapping the token associated to the id  elimina nella mappa il token con quell'id
            buttonHutTokenMapping.remove(mHutTokenRemoved.getIdToken());

            //get the resource panel associated to the button to change
            JPanel resourcesHutPanel = (JPanel) buttonToReplace.getParent().getComponent(0);
            resourcesHutPanel.removeAll();

            // request for a hut token  richiedi un nuovo hut token
            MHutToken nextHutTokenToBuild = MStoneAgeGame.getInstance().getHutToken();
            if (nextHutTokenToBuild != null) {
                nextHutTokenToBuild.addPropertyChangeListener(this); // add observer
                // insert the got hut token  inserisci l'hut token ottenuto
                nextHutTokenToBuild.getM_resources().forEach((key, value) -> resourcesHutPanel.add(new JLabel(key.getM_type() + ": " + value)));
                buttonHutTokenMapping.put(nextHutTokenToBuild.getIdToken(), buttonToReplace);
            }
            buildButton1.setEnabled(false);
            buildButton2.setEnabled(false);
            buildButton3.setEnabled(false);
        }

    }

    private void onPlay(JButton uButton) {
        uButton.setEnabled(false);
        MStoneAgeGame.getInstance().buildHut(getIdHutTokenByBottom(uButton));
    }

    public <K, V> Stream<K> getKeys(Map<K, V> map, V value) {
        return map
                .entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey);
    }

    public int getIdHutTokenByBottom(JButton uButton) {
        Stream<Integer> idHutTokens = getKeys(buttonHutTokenMapping, uButton);
        return idHutTokens.findFirst().get();

    }
}

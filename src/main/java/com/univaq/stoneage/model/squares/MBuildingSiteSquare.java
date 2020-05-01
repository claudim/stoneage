package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.MHutToken;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.utility.TokenState;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * MBuildingSiteSquare is a persistence entity.
 * It also knows the action to perform if the marker lands on it. Indeed, it manage the action.
 * It is responsible for the creation of all hut tokens and it knows them.
 */
@Entity
@DiscriminatorValue(value = "buildingsitesquare")
public class MBuildingSiteSquare extends MSquare {

    @Transient
    ArrayList<MHutToken> MHutTokens = new ArrayList<>();

    public MBuildingSiteSquare() {
//        super();
    }

    public MBuildingSiteSquare(String a_squareName) {
        super(a_squareName);
    }

    @PostLoad
    private void initTokens() {

        Map<String, Integer> res = Map.of("bacca", 3, "anfora", 2);
        Map<String, Integer> res1 = Map.of("dente", 1, "freccia", 2);
        Map<String, Integer> res2 = Map.of("freccia", 4, "dente", 5);
        Map<String, Integer> res3 = Map.of("pesce", 6, "dente", 3);
        MHutToken token = new MHutToken(TokenState.FACEUP, false);
        token.setResources(res);
        MHutToken token1 = new MHutToken(TokenState.FACEUP, false);
        token1.setResources(res1);
        MHutToken token2 = new MHutToken(TokenState.FACEDOWN, false);
        token2.setResources(res2);
        MHutToken token3 = new MHutToken(TokenState.FACEUP, false);
        token3.setResources(res3);
        MHutTokens.add(token);
        MHutTokens.add(token1);
        MHutTokens.add(token2);
        MHutTokens.add(token3);
    }

    @Override
    public void doAction(MPlayer mPlayer) {
        ArrayList<MHutToken> playerBuildableMHutTokens = new ArrayList<>();
        //system checks if the player has enough resources to build an hut.
        for (MHutToken hutToken : MHutTokens) {
            if (hutToken.getM_state().equals(TokenState.FACEUP)) {
                Map<String, Integer> hutTokenResources = hutToken.getResources();
                Map<String, Integer> stlResources = mPlayer.getM_settlement().getM_resources();

                Iterator it = hutTokenResources.entrySet().iterator();
                while (hutToken.isM_buildableByActivePlayer() && it.hasNext()) {
                    Map.Entry<String, Integer> hutResource = (Map.Entry<String, Integer>) it.next();
                    if (hutResource.getValue() > stlResources.get(hutResource.getKey())) {
                        hutToken.setM_buildableByActivePlayer(false);
                    }
                }
                if (hutToken.isM_buildableByActivePlayer()) playerBuildableMHutTokens.add(hutToken);
                //reset for the next active player
                hutToken.setM_buildableByActivePlayer(true);
            }
        }
        mPlayer.buildHut(playerBuildableMHutTokens);
    }


    @Override
    public String getSquareType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pcl) {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener pcl) {

    }

    @Override
    public void notifyPropertyChange(Object object) {
        //no-op
    }

    public ArrayList<MHutToken> getFaceUpHutTokens() {
        ArrayList<MHutToken> faceUpHutTokens = new ArrayList<>();
        for (MHutToken hutToken : MHutTokens) {
            if (hutToken.getM_state().equals(TokenState.FACEUP)) {
                faceUpHutTokens.add(hutToken);
            }
        }
        return faceUpHutTokens;
    }
}

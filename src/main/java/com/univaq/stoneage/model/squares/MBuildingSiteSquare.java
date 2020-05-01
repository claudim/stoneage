package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.dao.IGenericDAO;
import com.univaq.stoneage.dao.PersistenceServiceFactory;
import com.univaq.stoneage.model.MHutToken;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.utility.TokenState;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * MBuildingSiteSquare is a persistence entity.
 * It also knows the action to perform if the marker lands on it. Indeed, it manage the action.
 * It is responsible for the creation of all hut tokens and it knows them.
 */
@Entity
@DiscriminatorValue(value = "buildingsitesquare")
public class MBuildingSiteSquare extends MSquare {

    @Transient
    ArrayList<MHutToken> m_hutTokens = new ArrayList<>();

    public MBuildingSiteSquare() {
//        super();
    }

    public MBuildingSiteSquare(String a_squareName) {
        super(a_squareName);
    }


    @Override
    public void doAction(MPlayer mPlayer) {
        ArrayList<MHutToken> playerBuildableMHutTokens = new ArrayList<>();
        //system checks if the player has enough resources to build an hut.
        for (MHutToken mHutToken : m_hutTokens) {
            if (mHutToken.getM_state().equals(TokenState.FACEUP)) {
                mHutToken.setM_buildableByActivePlayer(true);
                mHutToken.getM_resources().entrySet().stream().forEach(
                        e -> {
                            Integer playerResNum = mPlayer.getM_settlement().getM_resources().get(e.getKey().getM_type());
                            if (playerResNum < e.getValue())
                                mHutToken.setM_buildableByActivePlayer(false);
                        }
                );
                if (mHutToken.isM_buildableByActivePlayer()) playerBuildableMHutTokens.add(mHutToken);
                //reset for the next active player
                mHutToken.setM_buildableByActivePlayer(false);

//                Map<String, Integer> hutTokenResources = MHutToken.getResources();
//                Map<String, Integer> stlResources = mPlayer.getM_settlement().getM_resources();
//
//                Iterator it = hutTokenResources.entrySet().iterator();
//                while (MHutToken.isM_buildableByActivePlayer() && it.hasNext()) {
//                    Map.Entry<String, Integer> hutResource = (Map.Entry<String, Integer>) it.next();
//                    if (hutResource.getValue() > stlResources.get(hutResource.getKey())) {
//                        MHutToken.setM_buildableByActivePlayer(false);
//                    }
//                }
//                if (MHutToken.isM_buildableByActivePlayer()) playerBuildableMHutTokens.add(MHutToken);
//                //reset for the next active player
//                MHutToken.setM_buildableByActivePlayer(true);
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

    @PostLoad
    public void loadHutTokenFromDB() {
        IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MHutToken.class.getSimpleName());
        m_hutTokens.addAll(dao.findAll());
        //m_hutTokens.size();
    }


}

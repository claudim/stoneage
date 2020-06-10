package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.dao.IGenericDAO;
import com.univaq.stoneage.dao.PersistenceServiceFactory;
import com.univaq.stoneage.model.GameMode;
import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.hutTokens.MHutToken;
import com.univaq.stoneage.model.hutTokens.nextHutTokenChoosing.MINextHutTokenStrategy;
import com.univaq.stoneage.model.nextId.IGetNextIdStrategy;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.utility.TokenState;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MBuildingSiteSquare is a persistence entity.
 * It also knows the action to perform if the marker lands on it. Indeed, it manage the action.
 * It is responsible for the creation of all hut tokens and it knows them and handle them until they are built.
 */
@Entity
@DiscriminatorValue(value = "buildingsitesquare")
public class MBuildingSiteSquare extends MSquare {

    @Transient
    ArrayList<MHutToken> m_hutTokens = new ArrayList<>();

    @Transient
    ArrayList<MHutToken> m_playerBuildableMHutTokens;

    @Transient
    MINextHutTokenStrategy m_nextHutTokenIdForPlayerStrategy;

    @Transient
    IGetNextIdStrategy m_nextHutTokenIdToBuildStrategy;

    @Transient
    ICheckBuildableHutStrategy checkBuildableHutAlgorithm;

    public MBuildingSiteSquare() {
    }

    public MBuildingSiteSquare(String a_squareName) {
        super(a_squareName);
    }

    @Override
    public ActionResult doAction(MPlayer mPlayer) {

        m_playerBuildableMHutTokens = checkBuildableHutAlgorithm.checkBuildableHut(mPlayer, m_hutTokens);
        if (m_playerBuildableMHutTokens.size() == 0) {
            MStoneAgeGame.getInstance().getM_grid().forestTokenShuffle();
            return ActionResult.ACTION_DONE;
        } else {
            return ActionResult.HUT_TOKEN_CHECK_DONE;
        }
    }

    @Override
    public String getSquareType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

    public void setupSquare(GameMode mode) {
        support = new PropertyChangeSupport(this); // to implement the oberver pattern
        IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MHutToken.class.getSimpleName(), null);
        m_hutTokens.addAll(dao.findAll());
        m_playerBuildableMHutTokens = new ArrayList<>();
        m_nextHutTokenIdForPlayerStrategy = mode.getNextHutIdStrategy();
        m_nextHutTokenIdToBuildStrategy = mode.getNextHutTokenIdToBuildStrategy();
        checkBuildableHutAlgorithm = new CheckBuildableHutStrategy();
    }

    public ArrayList<MHutToken> getFaceUpHutTokens() {
        ArrayList<MHutToken> faceUpHutTokens = new ArrayList<>();
        for (MHutToken hutToken : m_hutTokens) {
            if (hutToken.getM_state().equals(TokenState.FACEUP)) {
                faceUpHutTokens.add(hutToken);
            }
        }
        return faceUpHutTokens;
    }

    public MHutToken removeHutToken(int idHutToken) {
        MHutToken hutTokenToRemove = null;
        for (int i = 0; i < m_hutTokens.size(); i++) {
            MHutToken mHutToken = m_hutTokens.get(i);
            if (mHutToken.getIdToken() == idHutToken) {
                hutTokenToRemove = mHutToken;
            }
        }
        if (hutTokenToRemove != null) {
            m_hutTokens.remove(hutTokenToRemove);
            notifyPropertyChange("hutTokenRemoved", hutTokenToRemove, null);
        }
        return hutTokenToRemove;
    }

    public MHutToken getNextHutTokenToBuild() {
        List<MHutToken> result = m_hutTokens.stream()                // convert list to stream
                .filter(buildableHutToken -> buildableHutToken.getM_state().equals(TokenState.FACEDOWN))     // we want only facedown
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        ArrayList<MHutToken> buildableFaceDownHutTokens = (ArrayList<MHutToken>) result;

        int nextId = m_nextHutTokenIdToBuildStrategy.getNextId(0, buildableFaceDownHutTokens.size());
        buildableFaceDownHutTokens.get(nextId).setM_state(TokenState.FACEUP);
        return buildableFaceDownHutTokens.get(nextId);
    }

    // get next hut token id for the emulated player
    public int getNextHutTokenId(ArrayList<MHutToken> playerBuildableHutTokens) {
        return m_nextHutTokenIdForPlayerStrategy.getNextHutTokenId(playerBuildableHutTokens);
    }

    public ArrayList<MHutToken> getM_playerBuildableMHutTokens() {
        return m_playerBuildableMHutTokens;
    }

    public void setM_playerBuildableMHutTokens(ArrayList<MHutToken> m_playerBuildableMHutTokens) {
        this.m_playerBuildableMHutTokens = m_playerBuildableMHutTokens;
    }
}

package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.dao.IGenericDAO;
import com.univaq.stoneage.dao.PersistenceServiceFactory;
import com.univaq.stoneage.model.GameMode;
import com.univaq.stoneage.model.MResource;
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
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
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
    ArrayList<MHutToken> m_buildableHutTokens = new ArrayList<>();

    @Transient
    ArrayList<MHutToken> m_playerBuildableMHutTokens;

    @Transient
    MINextHutTokenStrategy m_nextHutTokenIdForPlayerStrategy;

    @Transient
    IGetNextIdStrategy m_nextHutTokenIdToBuildStrategy;

    public MBuildingSiteSquare() {
//        super();
    }

    public MBuildingSiteSquare(String a_squareName) {
        super(a_squareName);
    }

    @Override
    public ActionResult doAction(MPlayer mPlayer) {
        m_playerBuildableMHutTokens = new ArrayList<>();
        AtomicInteger dogResourceNumber = new AtomicInteger(mPlayer.getM_settlement().resourceTypeCounter("cane"));

        //system checks if the player has enough resources to build an hut.
        for (MHutToken mHutToken : m_buildableHutTokens) {
            if (mHutToken.getM_state().equals(TokenState.FACEUP)) {
                mHutToken.setM_buildableByActivePlayer(true);
                for (Map.Entry<MResource, Integer> e : mHutToken.getM_resources().entrySet()) {
                    Integer playerResNum = mPlayer.getM_settlement().resourceTypeCounter(e.getKey().getM_type());
                    if (playerResNum < e.getValue()) {
                        if ((playerResNum + dogResourceNumber.get()) < e.getValue())
                            mHutToken.setM_buildableByActivePlayer(false);
                        else {
                            dogResourceNumber.set(dogResourceNumber.get() - (e.getValue() - playerResNum));
                        }
                    }
                }
                if (mHutToken.isM_buildableByActivePlayer()) m_playerBuildableMHutTokens.add(mHutToken);

                //todo il reset è da fare quando termina il turno un giocatore.
                //reset for the next active player
                //mHutToken.setM_buildableByActivePlayer(false);
            }
        }
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
//
//    @PostLoad
//    public void loadHutTokenFromDB() {
//        support = new PropertyChangeSupport(this); // to implement the oberver pattern
//        IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MHutToken.class.getSimpleName());
//        m_buildableHutTokens.addAll(dao.findAll());
//        m_playerBuildableMHutTokens = new ArrayList<>();
//    }

    public void setupSquare(GameMode mode) {
        support = new PropertyChangeSupport(this); // to implement the oberver pattern
        IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MHutToken.class.getSimpleName());
        m_buildableHutTokens.addAll(dao.findAll());
        m_playerBuildableMHutTokens = new ArrayList<>();
        m_nextHutTokenIdForPlayerStrategy = mode.getNextHutIdStrategy();
        m_nextHutTokenIdToBuildStrategy = mode.getNextHutTokenIdToBuildStrategy();
    }

    public ArrayList<MHutToken> getFaceUpHutTokens() {
        ArrayList<MHutToken> faceUpHutTokens = new ArrayList<>();
        for (MHutToken hutToken : m_buildableHutTokens) {
            if (hutToken.getM_state().equals(TokenState.FACEUP)) {
                faceUpHutTokens.add(hutToken);
            }
        }
        return faceUpHutTokens;
    }

    public MHutToken removeHutToken(int idHutToken) {
        MHutToken hutTokenToRemove = null;
        for (int i = 0; i < m_buildableHutTokens.size(); i++) {
            MHutToken mHutToken = m_buildableHutTokens.get(i);
            if (mHutToken.getIdToken() == idHutToken) {
                hutTokenToRemove = mHutToken;
            }
        }
        if (hutTokenToRemove != null) {
            m_buildableHutTokens.remove(hutTokenToRemove);
            notifyPropertyChange("hutTokenRemoved", hutTokenToRemove, null);
        }
        return hutTokenToRemove;
    }

    public MHutToken getNextHutTokenToBuild() {
        List<MHutToken> result = m_buildableHutTokens.stream()                // convert list to stream
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

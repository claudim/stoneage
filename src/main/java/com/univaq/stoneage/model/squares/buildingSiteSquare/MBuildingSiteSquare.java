package com.univaq.stoneage.model.squares.buildingSiteSquare;

import com.univaq.stoneage.model.MHutToken;
import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.ActionResult;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.nextHutTokenChoosing.MINextHutTokenStrategy;
import com.univaq.stoneage.utility.TokenState;
import com.univaq.stoneage.utility.nextId.IGetNextIdStrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.beans.PropertyChangeEvent;
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

    /**
     * List of hut token not built yet.
     */
    @Transient
    private ArrayList<MHutToken> m_hutTokens = new ArrayList<>();

    /**
     * List of hut token buildable by the active player
     */
    @Transient
    private ArrayList<MHutToken> m_playerBuildableMHutTokens;

    /**
     * Reference to the strategy to choose the next hut token id for the (emulated) player.
     */
    @Transient
    private MINextHutTokenStrategy m_nextHutTokenIdForPlayerStrategy;

    /**
     * Reference to the strategy to choose the next hut token to face up on the square.
     */
    @Transient
    private IGetNextIdStrategy m_nextHutTokenIdToFaceUpStrategy;

    /**
     * Reference to the strategy for control which hut token is buildable for a player.
     */
    @Transient
    private ICheckBuildableHutStrategy checkBuildableHutAlgorithm;

    /**
     * Default constructor.
     */
    public MBuildingSiteSquare() {
    }

    /**
     * Constructor.
     *
     * @param a_squareName The square name
     */
    public MBuildingSiteSquare(String a_squareName) {
        super(a_squareName);
    }

    /**
     * Action to perform if the marker's player lands on it.
     * Check if the player can build one or more hut tokens.
     * If he cannot build any hut tokens, ask to the grid to perform the forest tokens shuffle.
     *
     * @param mPlayer The player who lands on the square
     * @return The action result
     */
    @Override
    public ActionResult doAction(MPlayer mPlayer) {

        m_playerBuildableMHutTokens = checkBuildableHutAlgorithm.checkBuildableHut(mPlayer, m_hutTokens);
        if (m_playerBuildableMHutTokens.size() == 0) {
            System.out.println(mPlayer.getMarkerName() + "  non  può costruire");
            MStoneAgeGame.getInstance().getM_grid().forestTokenShuffle();
            return ActionResult.ACTION_DONE;
        } else {
            System.out.println(mPlayer.getMarkerName() + " può costruire");
            return ActionResult.HUT_TOKEN_CHECK_DONE;
        }
    }

    /**
     * Get the square type.
     *
     * @return the square type
     */
    @Override
    public String getSquareType() {
        return this.getClass().getSimpleName();
    }

    /**
     * Get the next hut token id (for the emulated player) that could be built chosen from the list of the hut token buildable by the player.
     *
     * @param playerBuildableHutTokens The list of the hut token buildable by the player
     * @return The hut token id chosen
     */
    public int getNextHutTokenId(ArrayList<MHutToken> playerBuildableHutTokens) {
        return m_nextHutTokenIdForPlayerStrategy.getNextHutTokenId(playerBuildableHutTokens);
    }

    /**
     * Get the hut token buildable by the active player.
     *
     * @return List of hut token buildable by the active player
     */
    public ArrayList<MHutToken> getM_playerBuildableMHutTokens() {
        return m_playerBuildableMHutTokens;
    }

    /**
     * Set the hut token buildable by the active player.
     *
     * @param m_playerBuildableMHutTokens List of hut token buildable by the active player
     */
    public void setM_playerBuildableMHutTokens(ArrayList<MHutToken> m_playerBuildableMHutTokens) {
        this.m_playerBuildableMHutTokens = m_playerBuildableMHutTokens;
    }

    /**
     * How to manage a notify from the observable.
     *
     * @param evt The notify
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

//    /**
//     * Initial square setup.
//     * Create the all hut tokens and set the square strategies
//     *
//     * @param mode The game mode
//     */
//    public void setupSquare(GameMode mode) {
//        support = new PropertyChangeSupport(this); // to implement the oberver pattern
//        IPersistentGeneric dao = PersistenceServiceFactory.getInstance().getPersistenceClass(MHutToken.class.getSimpleName(), null);
//        m_hutTokens.addAll(dao.findAll());
//        m_playerBuildableMHutTokens = new ArrayList<>();
//        m_nextHutTokenIdForPlayerStrategy = mode.getNextHutIdStrategy();
//        m_nextHutTokenIdToFaceUpStrategy = mode.getNextHutTokenIdToFaceUpStrategy();
//        checkBuildableHutAlgorithm = new CheckBuildableHutStrategy();
//    }


    /**
     * Get all the hut tokens not built yet which are in face up state.
     *
     * @return The face up hut tokens
     */
    public ArrayList<MHutToken> getFaceUpHutTokens() {
        ArrayList<MHutToken> faceUpHutTokens = new ArrayList<>();
        for (MHutToken hutToken : m_hutTokens) {
            if (hutToken.getM_state().equals(TokenState.FACEUP)) {
                faceUpHutTokens.add(hutToken);
            }
        }
        return faceUpHutTokens;
    }

    /**
     * Remove a hut token and notify all the observer.
     *
     * @param idHutToken the id of the hut token to remove
     * @return The hut token removed
     */
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

    /**
     * Get the next hut token to face up on the board.
     *
     * @return The hut token to face up
     */
    public MHutToken getNextHutTokenToBuild() {
        List<MHutToken> result = m_hutTokens.stream()                // convert list to stream
                .filter(buildableHutToken -> buildableHutToken.getM_state().equals(TokenState.FACEDOWN))     // we want only facedown
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        ArrayList<MHutToken> buildableFaceDownHutTokens = (ArrayList<MHutToken>) result;

        int nextId = m_nextHutTokenIdToFaceUpStrategy.getNextId(0, buildableFaceDownHutTokens.size());
        buildableFaceDownHutTokens.get(nextId).setM_state(TokenState.FACEUP);
        return buildableFaceDownHutTokens.get(nextId);
    }

    public ArrayList<MHutToken> getM_hutTokens() {
        return m_hutTokens;
    }

    public void setM_hutTokens(ArrayList<MHutToken> m_hutTokens) {
        this.m_hutTokens = m_hutTokens;
    }

    public MINextHutTokenStrategy getM_nextHutTokenIdForPlayerStrategy() {
        return m_nextHutTokenIdForPlayerStrategy;
    }

    public void setM_nextHutTokenIdForPlayerStrategy(MINextHutTokenStrategy m_nextHutTokenIdForPlayerStrategy) {
        this.m_nextHutTokenIdForPlayerStrategy = m_nextHutTokenIdForPlayerStrategy;
    }

    public IGetNextIdStrategy getM_nextHutTokenIdToFaceUpStrategy() {
        return m_nextHutTokenIdToFaceUpStrategy;
    }

    public void setM_nextHutTokenIdToFaceUpStrategy(IGetNextIdStrategy m_nextHutTokenIdToFaceUpStrategy) {
        this.m_nextHutTokenIdToFaceUpStrategy = m_nextHutTokenIdToFaceUpStrategy;
    }

    public ICheckBuildableHutStrategy getCheckBuildableHutAlgorithm() {
        return checkBuildableHutAlgorithm;
    }

    public void setCheckBuildableHutAlgorithm(ICheckBuildableHutStrategy checkBuildableHutAlgorithm) {
        this.checkBuildableHutAlgorithm = checkBuildableHutAlgorithm;
    }


}

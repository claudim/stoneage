package com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.MSettlement;
import com.univaq.stoneage.model.squares.ActionResult;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;

import java.util.ArrayList;

/**
 * It is a concrete state of the STATE PATTERN of the resource square.
 * Concrete state when the resource square has to release 2 resources.
 * It has a reference to the square.
 */
public class Release2ResourcesState implements ISquareState {
    private final MResourceSquare m_ResourceSquareState;

    /**
     * Constructor.
     *
     * @param m_ResourceSquareState The resource square
     */
    public Release2ResourcesState(MResourceSquare m_ResourceSquareState) {
        this.m_ResourceSquareState = m_ResourceSquareState;
    }

    /**
     * Perform the action if the marker's player lands on the resource square and the square has at least 2 resources.
     *
     * @param player The player who lands on the square
     * @return The action result
     */
    @Override
    public ActionResult doSquareAction(MPlayer player) {
        MSettlement settlement = player.getM_settlement();
        // add the square as observer of the statement only for the resource property
        settlement.addPropertyChangeListener("resource", m_ResourceSquareState);
        ArrayList<MResource> resources = m_ResourceSquareState.getM_resources();
        // la square avrà sicuramente almeno 2 risorse altrimenti non sarebbe entrata in questo stato
        for (int i = 0; i < 2; i++) {
            MResource resource = resources.remove(0);
            settlement.addResource(resource);
        }
        System.out.println(player.getMarkerName() + " ha preso 2 risorse di tipo " + m_ResourceSquareState.getm_resourceType());

        m_ResourceSquareState.notifyPropertyChange("resource", resources.size() + 2, resources.size());

        m_ResourceSquareState.changeState(m_ResourceSquareState.getM_squareStateFactory().createState(m_ResourceSquareState, null));

        return ActionResult.GOT_RESOURCE;
    }

    /**
     * The action to perform when a resource is added to the square.
     */
    @Override
    public void addedResource() {

    }
}

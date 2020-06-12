package com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.MSettlement;
import com.univaq.stoneage.model.squares.ActionResult;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;

import java.util.ArrayList;

/**
 * It is a concrete state of the STATE PATTERN of the resource square.
 * Concrete state when the resource square has at least a resource.
 * It has a reference to the square.
 */
public class WithResourceState implements ISquareState {
    private final MResourceSquare m_ResourceSquareState;

    /**
     * Constructor.
     *
     * @param m_ResourceSquareState The resource square
     */
    public WithResourceState(MResourceSquare m_ResourceSquareState) {
        this.m_ResourceSquareState = m_ResourceSquareState;
    }

    /**
     * Perform the action if the marker's player lands on the resource square and the square has at least a resource.
     *
     * @param player The player who lands on the square
     * @return The action result
     */
    @Override
    public ActionResult doSquareAction(MPlayer player) {
        ArrayList<MResource> resources = m_ResourceSquareState.getM_resources();
        MResource resource = resources.remove(0);
        m_ResourceSquareState.notifyPropertyChange("resource", resources.size() + 1, resources.size());
        MSettlement settlement = player.getM_settlement();
        System.out.println(player.getMarkerName() + " ha preso 1 " + resource.getM_type());
        // add the square as observer of the statement only for the resource property
        settlement.addPropertyChangeListener("resource", m_ResourceSquareState);
        settlement.addResource(resource);
        if (resources.size() == 0) {
            m_ResourceSquareState.changeState(m_ResourceSquareState.getM_squareStateFactory().createState(m_ResourceSquareState, null));
        }
        return ActionResult.GOT_RESOURCE;
    }

    /**
     * The action to perform when a resource is added to the square.
     */
    @Override
    public void addedResource() {
    }
}

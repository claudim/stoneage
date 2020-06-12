package com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.ActionResult;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;

/**
 * It is a concrete state of the STATE PATTERN of the resource square.
 * Concrete state when the resource square has no resource and the game mode is green.
 * It has a reference to the square.
 */
public class NoResourceState implements ISquareState {
    private final MResourceSquare m_ResourceSquareState;

    /**
     * Constructor.
     *
     * @param m_ResourceSquareState The resource square
     */
    public NoResourceState(MResourceSquare m_ResourceSquareState) {
        this.m_ResourceSquareState = m_ResourceSquareState;
    }

    /**
     * Perform the action if the marker's player lands on the resource square and the square has no resource and the game mode is green.
     *
     * @param player The player who lands on the square
     * @return The action result
     */
    @Override
    public ActionResult doSquareAction(MPlayer player) {
        System.out.println(player.getMarkerName() + " non deve far nulla poichè non ci sono risorse da prendere ");
        return ActionResult.ACTION_DONE;
    }

    /**
     * The action to perform when a resource is added to the square.
     * Change the resource square state only if the square has at least one resource and mode game is green.
     */
    @Override
    public void addedResource() {
        if (m_ResourceSquareState.getM_resources().size() > 0) {
            m_ResourceSquareState.changeState(new WithResourceState(m_ResourceSquareState));
        }
    }
}

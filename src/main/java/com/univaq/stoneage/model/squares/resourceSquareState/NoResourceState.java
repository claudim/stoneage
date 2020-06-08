package com.univaq.stoneage.model.squares.resourceSquareState;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.ActionResult;
import com.univaq.stoneage.model.squares.MResourceSquare;

public class NoResourceState implements ISquareState {
    private final MResourceSquare m_ResourceSquareState;

    public NoResourceState(MResourceSquare m_ResourceSquareState) {
        this.m_ResourceSquareState = m_ResourceSquareState;
    }

    @Override
    public ActionResult doSquareAction(MPlayer player) {
        System.out.println(player.getMarkerName() + " non deve far nulla poichè non ci sono risorse da prendere ");
        return ActionResult.ACTION_DONE;
    }

    @Override
    public void addedResource() {
        if (m_ResourceSquareState.getM_resources().size() > 0) {
            m_ResourceSquareState.changeState(new WithResourceState(m_ResourceSquareState));
        }
    }
}

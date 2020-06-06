package com.univaq.stoneage.model.squares.resourceSquareState;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.ActionResult;
import com.univaq.stoneage.model.squares.MResourceSquare;

public class StealResourceState implements ISquareState {
    private final MResourceSquare m_ResourceSquareState;

    public StealResourceState(MResourceSquare m_ResourceSquareState) {
        this.m_ResourceSquareState = m_ResourceSquareState;
    }

    @Override
    public ActionResult doSquareAction(MPlayer player) {
        System.out.println(player.getMarkerName() + " deve rubare una risorsa ");
        return ActionResult.MISSING_RESOURCE;
    }

    @Override
    public void addedResource() {
        m_ResourceSquareState.changeState(new WithResourceState(m_ResourceSquareState));
    }
}

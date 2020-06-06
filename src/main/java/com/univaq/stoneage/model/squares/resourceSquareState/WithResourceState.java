package com.univaq.stoneage.model.squares.resourceSquareState;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.MSettlement;
import com.univaq.stoneage.model.squares.ActionResult;
import com.univaq.stoneage.model.squares.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquareState.squareStateFactory.ISquareStateFactory;
import com.univaq.stoneage.model.squares.resourceSquareState.squareStateFactory.SimpleSquareStateFactory;

import java.util.ArrayList;

public class WithResourceState implements ISquareState {
    private final MResourceSquare m_ResourceSquareState;

    public WithResourceState(MResourceSquare m_ResourceSquareState) {
        this.m_ResourceSquareState = m_ResourceSquareState;
    }

//    @Override
//    public void doSquareAction(MPlayer player) {
//        ArrayList<MResource> resources = m_ResourceSquareState.getM_resources();
//        MResource resource = resources.remove(0);
//        m_ResourceSquareState.notifyPropertyChange("resource", resources.size() + 1, resources.size());
//        MSettlement settlement = player.getM_settlement();
//        settlement.addPropertyChangeListener("resource", m_ResourceSquareState);
//        settlement.addResource(resource);
//        if(resources.size()==0)
//            m_ResourceSquareState.changeState(new StealResourceState(m_ResourceSquareState));
//    }

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
            ISquareStateFactory squareStateFactory = new SimpleSquareStateFactory();
            m_ResourceSquareState.changeState(squareStateFactory.createState("Rossa", m_ResourceSquareState));
        }
        return ActionResult.GOT_RESOURCE;
    }

    @Override
    public void addedResource() {
        //m_ResourceSquareState.changeState(new WithResourceState(m_ResourceSquareState));
    }
}

package com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy;

import com.univaq.stoneage.model.hutTokens.MHutToken;
import com.univaq.stoneage.model.hutTokens.nextHutTokenChoosing.MRandomNextHutTokenStrategy;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.buildingSiteSquare.CheckBuildableHutStrategy;
import com.univaq.stoneage.model.squares.buildingSiteSquare.MBuildingSiteSquare;
import com.univaq.stoneage.persistence.IPersistentGeneric;
import com.univaq.stoneage.persistence.PersistenceServiceFactory;
import com.univaq.stoneage.utility.nextId.GetFirstIdStrategy;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class RedBuildingSiteSquareSetupStrategy implements MISquareSetupStrategy {
    @Override
    public void setupSquare(MSquare square) {
        MBuildingSiteSquare buildingSiteSquare = (MBuildingSiteSquare) square;
        buildingSiteSquare.setSupport(new PropertyChangeSupport(buildingSiteSquare));
        IPersistentGeneric dao = PersistenceServiceFactory.getInstance().getPersistenceClass(MHutToken.class.getSimpleName(), "rossa");
        buildingSiteSquare.setM_hutTokens(dao.findAll());
        buildingSiteSquare.setM_playerBuildableMHutTokens(new ArrayList<>());
        buildingSiteSquare.setCheckBuildableHutAlgorithm(new CheckBuildableHutStrategy());
        buildingSiteSquare.setM_nextHutTokenIdForPlayerStrategy(new MRandomNextHutTokenStrategy());
        buildingSiteSquare.setM_nextHutTokenIdToFaceUpStrategy(new GetFirstIdStrategy());
    }
}

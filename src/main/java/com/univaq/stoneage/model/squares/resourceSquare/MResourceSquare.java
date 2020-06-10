package com.univaq.stoneage.model.squares.resourceSquare;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.gameMode.GameMode;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.ActionResult;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.ISquareState;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory.IResourceSquareStateFactory;
import com.univaq.stoneage.model.squares.squareSetup.MISetupSquareStrategyFactory;
import com.univaq.stoneage.model.squares.squareSetup.MISquareSetupStrategy;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

@Entity
@DiscriminatorValue(value = "resourcesquare")
public class MResourceSquare extends MSquare {

    @Column(name = "resource_type")
    private String m_resourceType;
    @Transient
    private ArrayList<MResource> m_resources;
    @Transient
    private ISquareState m_squareState;

    @Transient
    private IResourceSquareStateFactory m_squareStateFactory;

    public MResourceSquare() {
        m_resources = new ArrayList<>();
    }

    public MResourceSquare(String a_type) {
        m_resourceType = a_type;
        m_resources = new ArrayList<>();
    }

    public String getm_resourceType() {
        return m_resourceType;
    }

    public void setm_resourceType(String m_resourceType) {
        this.m_resourceType = m_resourceType;
    }

    public ArrayList<MResource> getM_resources() {
        return m_resources;
    }

    public void setM_resources(ArrayList<MResource> m_resources) {
        this.m_resources = m_resources;
    }

    @Override
    public String getSquareType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
        notifyPropertyChange("initResource", 0, this.m_resources.size());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("resource") && evt.getOldValue() != null
                && ((MResource) evt.getOldValue()).getM_type().equals(this.m_resourceType)) {
            MResource mResource = (MResource) evt.getOldValue();
            notifyPropertyChange("incrementResource", this.m_resources.size(), this.m_resources.size() + 1);
            m_resources.add(mResource);
            m_squareState.addedResource();
        }
    }

    @Override
    public void setupSquare(GameMode mode) {
        super.support = new PropertyChangeSupport(this); // to implement the observer pattern

        MISetupSquareStrategyFactory squareStrategyFactory = mode.getSetupSquareStrategyFactory();
        MISquareSetupStrategy setupSquareStrategy = squareStrategyFactory.getSetupSquareStrategy(m_resourceType);
        setupSquareStrategy.setupSquare(this);

        m_squareStateFactory = mode.getSquareStateFactory();
        m_squareState = m_squareStateFactory.createState(this, null);
    }

    public ISquareState getM_squareState() {
        return m_squareState;
    }

    public void setM_squareState(ISquareState m_squareState) {
        this.m_squareState = m_squareState;
    }

    public void changeState(ISquareState squareState) {
        m_squareState = squareState;
    }

    @Override
    public ActionResult doAction(MPlayer player) {
        return m_squareState.doSquareAction(player);
    }

    public IResourceSquareStateFactory getM_squareStateFactory() {
        return m_squareStateFactory;
    }

    public void setM_squareStateFactory(IResourceSquareStateFactory m_squareStateFactory) {
        this.m_squareStateFactory = m_squareStateFactory;
    }
}
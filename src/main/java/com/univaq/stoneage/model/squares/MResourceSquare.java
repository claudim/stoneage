package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.resourceSquareState.ISquareState;
import com.univaq.stoneage.model.squares.resourceSquareState.squareStateFactory.ISquareStateFactory;
import com.univaq.stoneage.model.squares.resourceSquareState.squareStateFactory.SimpleSquareStateFactory;
import com.univaq.stoneage.model.squares.squareSetup.MISetupSquareStrategyFactory;
import com.univaq.stoneage.model.squares.squareSetup.MISquareSetupStrategy;
import com.univaq.stoneage.model.squares.squareSetup.MSetupResourceSquareStrategyFactory;

import javax.persistence.*;
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

    // after object creation from Hibernate this method is called
    @PostLoad
    public void createResources() {
        super.support = new PropertyChangeSupport(this); // to implement the observer pattern

        MISetupSquareStrategyFactory squareStrategyFactory = new MSetupResourceSquareStrategyFactory();
        MISquareSetupStrategy setupSquareStrategy = squareStrategyFactory.getSetupSquareStrategy(m_resourceType);
        setupSquareStrategy.setupSquare(this);

        ISquareStateFactory squareStateFactory = new SimpleSquareStateFactory();
        m_squareState = squareStateFactory.createState("Rossa", this);
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
}
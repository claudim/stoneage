package com.univaq.stoneage.model.squares.resourceSquare;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.ActionResult;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.ISquareState;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory.IResourceSquareStateFactory;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * It is responsible for the creation of all the Resource of the same type of the square.
 * Delegate the actual square state to perform the action if the marker's player lands on it.
 * It knows its type, all the resources on the square and how to setup the square..
 * It has a number of internal states and has a reference to the actual internal state.
 * It is the context of the STATE PATTERN.
 * It is the observable of the OBSERVER PATTERN (between MSquare and UResourceSquare).
 * It is the observer of the OBSERVER PATTER (between MSEttelment and MREsourceSquare).
 */
@Entity
@DiscriminatorValue(value = "resourcesquare")
public class MResourceSquare extends MSquare {

    /**
     * The resource type held by this square.
     */
    @Column(name = "resource_type")
    private String m_resourceType;

    /**
     * All the resources hend by the square.
     */
    @Transient
    private ArrayList<MResource> m_resources;
    /**
     * The resource square state.
     */
    @Transient
    private ISquareState m_squareState;

    /**
     * Reference to the resource square state factory.
     */
    @Transient
    private IResourceSquareStateFactory m_squareStateFactory;

    /**
     * Default constructor.
     */
    public MResourceSquare() {
        m_resources = new ArrayList<>();
    }

    /**
     * Constructor.
     *
     * @param a_type The resource type
     */
    public MResourceSquare(String a_type) {
        m_resourceType = a_type;
        m_resources = new ArrayList<>();
    }

    /**
     * Get the resource type.
     *
     * @return The resource type
     */
    public String getm_resourceType() {
        return m_resourceType;
    }

    /**
     * Set the resource type.
     *
     * @param m_resourceType The resource type
     */
    public void setm_resourceType(String m_resourceType) {
        this.m_resourceType = m_resourceType;
    }

    /**
     * Get all resources on the square.
     *
     * @return All resources on the square
     */
    public ArrayList<MResource> getM_resources() {
        return m_resources;
    }

    /**
     * Set all resources on the square.
     *
     * @param m_resources All resources to set on the square
     */
    public void setM_resources(ArrayList<MResource> m_resources) {
        this.m_resources = m_resources;
    }

    /**
     * Get the square type.
     *
     * @return The square type
     */
    @Override
    public String getSquareType() {
        return this.getClass().getSimpleName();
    }

    /**
     * Add an observer to the list and notify all the observer on the list. In this way the last observer knows how many resources the square has.
     *
     * @param pcl The observer to add
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
        notifyPropertyChange("initResource", 0, this.m_resources.size());
    }

    /**
     * How to manage a notify from the observable.
     *
     * @param evt The notify
     */
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

//    /**
//     * Initial square setup.
//     *
//     * @param mode The game mode
//     */
//    @Override
//    public void setupSquare(GameMode mode) {
//        super.support = new PropertyChangeSupport(this); // to implement the observer pattern
//
//        MISetupSquareStrategyFactory squareStrategyFactory = mode.getSetupSquareStrategyFactory();
//        MISquareSetupStrategy setupSquareStrategy = squareStrategyFactory.getSetupSquareStrategy(m_resourceType);
//        setupSquareStrategy.setupSquare(this);
//
//        m_squareStateFactory = mode.getSquareStateFactory();
//        m_squareState = m_squareStateFactory.createState(this, null);
//    }

    /**
     * Get the square state.
     *
     * @return The square state
     */
    public ISquareState getM_squareState() {
        return m_squareState;
    }

    /**
     * Set the square state.
     *
     * @param m_squareState The square state
     */
    public void setM_squareState(ISquareState m_squareState) {
        this.m_squareState = m_squareState;
    }

    /**
     * Change the square state.
     *
     * @param squareState The square state
     */
    public void changeState(ISquareState squareState) {
        m_squareState = squareState;
    }

    /**
     * Delegate the actual square state to perform the action if the marker's player lands on it.
     *
     * @param player The player who lands on the square
     * @return The action result
     */
    @Override
    public ActionResult doAction(MPlayer player) {
        return m_squareState.doSquareAction(player);
    }

    /**
     * Get the square state factory.
     *
     * @return The square state factory
     */
    public IResourceSquareStateFactory getM_squareStateFactory() {
        return m_squareStateFactory;
    }

    /**
     * Set the square state factory.
     *
     * @param m_squareStateFactory the square state factory
     */
    public void setM_squareStateFactory(IResourceSquareStateFactory m_squareStateFactory) {
        this.m_squareStateFactory = m_squareStateFactory;
    }
}
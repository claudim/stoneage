package com.univaq.stoneage.model.hutTokens;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.utility.TokenState;

import javax.persistence.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Map;

/**
 * Class representing hut tokens.
 */
@Entity
@Table(name = "huttoken")
public class MHutToken implements Serializable {

    @Id
    @Column(name = "id_token")
    private int idToken;

    /* It is face up or  face down */
    @Column(name = "state")
    private TokenState m_state;

    /* True if the active player can build this hut, false otherwise */
    @Transient
    private boolean m_buildableByActivePlayer = false;

    @Transient // ignore this property/field
    protected PropertyChangeSupport support = new PropertyChangeSupport(this); // to implement the oberver pattern;

    /* Collection of needed resources to build the hut */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "huttoken_resource", joinColumns = @JoinColumn(name = "id_token"))
    @MapKeyJoinColumn(name = "resource_name")
    @Column(name = "quantity")
    private Map<MResource, Integer> m_resources;

    /**
     * Constructor
     */
    public MHutToken() {
    }

    /**
     * Constructor
     *
     * @param state     face up or face down
     * @param buildable true if buildable by the player
     */
    public MHutToken(TokenState state, boolean buildable) {
        this.m_state = state;
        this.m_buildableByActivePlayer = buildable;
    }

    public TokenState getM_state() {
        return m_state;
    }

    public void setM_state(TokenState m_state) {
        this.m_state = m_state;
    }

    public boolean isM_buildableByActivePlayer() {
        return m_buildableByActivePlayer;
    }

    /**
     * Set current hut buildable by the active player. It fires a prperty change event called 'hutTokenBuildable'
     *
     * @param m_buildableByActivePlayer true if buildable, false otherwise
     */
    public void setM_buildableByActivePlayer(boolean m_buildableByActivePlayer) {
        this.notifyPropertyChange("hutTokenBuildable", this.m_buildableByActivePlayer, m_buildableByActivePlayer);
        this.m_buildableByActivePlayer = m_buildableByActivePlayer;
    }

    public int getIdToken() {
        return idToken;
    }

    public void setIdToken(int idHutToken) {
        this.idToken = idHutToken;
    }

    /**
     * Get map of resources needed to build a hut
     *
     * @return map of resources needed to build a hut
     */
    public Map<MResource, Integer> getM_resources() {
        return m_resources;
    }

    public void setM_resources(Map<MResource, Integer> m_resources) {
        this.m_resources = m_resources;
    }

    /**
     * Add an observer to the list.
     *
     * @param pcl The observer to add
     */
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    /**
     * Remove an observer from the list.
     *
     * @param pcl The observer to remove
     */
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    /**
     * Notify all the observer for the change of the property.
     *
     * @param property  The property name which changed its value
     * @param oldObject The old value of the property
     * @param newObject The new value of the property
     */
    public void notifyPropertyChange(String property, Object oldObject, Object newObject) {
        support.firePropertyChange(property, oldObject, newObject);
    }
}

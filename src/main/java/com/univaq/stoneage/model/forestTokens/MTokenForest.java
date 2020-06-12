package com.univaq.stoneage.model.forestTokens;

import com.univaq.stoneage.utility.TokenState;

import javax.persistence.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * MTokenForest is a generic, persistence abstract super class.
 * It knows its state and value.
 * MTokenForest is obersevable (by UTokenForest).
 */
@Entity
@Table(name = "tokenforest")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class MTokenForest<T> implements Serializable {

    @Transient // ignore this property/field
    protected final PropertyChangeSupport support = new PropertyChangeSupport(this); // to implement the oberver pattern
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected int idToken;
    @Column(name = "state")
    protected TokenState m_state;

    @Column(name = "mode")
    private String m_mode;

    /**
     * Default constructor.
     */
    public MTokenForest() {
    }

    /**
     * Get the forest token id
     *
     * @return int The forest token id
     */
    public int getIdToken() {
        return idToken;
    }

    /**
     * Set the forest token id
     *
     * @param token_id int The forest token id
     */
    public void setIdToken(int token_id) {
        this.idToken = token_id;
    }

    /**
     * Get the forest token state
     *
     * @return boolean The forest token state
     */
    public TokenState getState() {
        return m_state;
    }

    /**
     * @param aFaceUpOrDown
     */
    public void setState(TokenState aFaceUpOrDown) {
        notifyPropertyChangeListener("token_state", this.m_state, aFaceUpOrDown);
        m_state = aFaceUpOrDown;
    }

    /**
     * Get the forest token value
     *
     * @return T The forest token value
     */
    public abstract T getValue();

    /**
     * Set the forest token value
     *
     * @param value T The forest token value
     */
    public abstract void setValue(T value);

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void notifyPropertyChangeListener(String propertyName, Object oldValue, Object newValue) {
        support.firePropertyChange(propertyName, oldValue, newValue);
    }

}

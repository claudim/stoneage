package com.univaq.stoneage.model.forestTokens;

import javax.persistence.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * MTokenForest is a generic, persistence abstract super class.
 * It knows its position, state and value.
 * MTokenForest is obersevable.
 */
@Entity
@Table(name = "tokenforest")
//@MappedSuperclass
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue(value = "tokenforest")
public abstract class MTokenForest<T> implements Serializable {

    @Transient
    public final boolean FACEDOWN = false;
    @Transient
    public final boolean FACEUP = true;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int token_id;

    @Column(name = "state")
    private boolean m_state;

    @Column(name = "position")
    private int m_position;


    @Transient // ignore this property/field
    private final PropertyChangeSupport support = new PropertyChangeSupport(this); // to implement the oberver pattern

    /**
     * Default constructor.
     */
    public MTokenForest() {
    }

    /**
     * Constructor to define forest token position and FACEDOWN state.
     *
     * @param position forest token position
     */
    public MTokenForest(int position) {
        this.m_state = FACEDOWN;
        this.m_position = position;
    }

    /**
     * Get the forest token id
     *
     * @return int The forest token id
     */
    public int getToken_id() {
        return token_id;
    }

    /**
     * Set the forest token id
     *
     * @param token_id int The forest token id
     */
    public void setToken_id(int token_id) {
        this.token_id = token_id;
    }

    /**
     * Get the forest token position
     *
     * @return int The forest token position
     */
    public int getM_position() {
        return m_position;
    }

    /**
     * Set the forest token position
     *
     * @param m_position int The forest token position
     */
    public void setM_position(int m_position) {
        this.m_position = m_position;
    }

    /**
     * Get the forest token state
     *
     * @return boolean The forest token state
     */
    public boolean getState() {
        return m_state;
    }

    /**
     * @param aFaceUpOrDown
     */
    public void setState(boolean aFaceUpOrDown) {
        notifyPropertyChange(aFaceUpOrDown);
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

    public void notifyPropertyChange(boolean aFaceUpOrDown) {
        support.firePropertyChange("token_state", this.m_state, aFaceUpOrDown);
    }
}

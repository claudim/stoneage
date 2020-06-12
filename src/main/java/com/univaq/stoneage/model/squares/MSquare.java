package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.gameMode.GameMode;
import com.univaq.stoneage.model.players.MPlayer;

import javax.persistence.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * MSquare is a persistence entity.
 * It knows its name, its the next square with which it is linked, if it is the start square.
 * It knows the action to perform if the marker lands on it and how to setup the square.
 * It is the observable of the OBSERVER PATTERN.
 */
@Entity
@Table(name = "Square")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "square_type", discriminatorType = DiscriminatorType.STRING)
public abstract class MSquare implements Serializable, PropertyChangeListener {
	@Id
	@Column(name = "square_name", length = 30)
	private String m_name;

	@Column(name = "start_square")
	private boolean m_startSquare;

	@OneToOne(targetEntity = MSquare.class, cascade = CascadeType.ALL)
	@JoinColumns(
			{
					@JoinColumn(name = "next_square_name", referencedColumnName = "square_name"),
					@JoinColumn(name = "next_square_mode", referencedColumnName = "mode")
			})
	private MSquare m_nextSquare;

	@Id
	@Column(name = "mode")
	private String m_mode;

	@Transient // ignore this property/field
	protected PropertyChangeSupport support = new PropertyChangeSupport(this);

	/**
	 * Default constructor.
	 */
	public MSquare() {
	}

	/**
	 * Constructor.
	 *
	 * @param m_name The square name
	 */
	public MSquare(String m_name) {
		this.m_name = m_name;
		this.m_startSquare = false;
		this.m_nextSquare = null;
	}

	/**
	 * Get the square name.
	 *
	 * @return The square name
	 */
	public String getM_name() {
		return m_name;
	}

	/**
	 * Set the square name.
	 *
	 * @param m_name The square name
	 */
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	/**
	 * Get the next square which the square is linked to.
	 *
	 * @return The square which the square is linked to.
	 */
	public MSquare getM_nextSquare() {
		return m_nextSquare;
	}

	/**
	 * Set the next square which the square is linked to.
	 *
	 * @param m_nextSquare The next square which the square is linked to
	 */
	public void setM_nextSquare(MSquare m_nextSquare) {
		this.m_nextSquare = m_nextSquare;
	}

	/**
	 * Get true if the square is a start square, false otherwise.
	 *
	 * @return true if the square is a start square, false otherwise
	 */
	public boolean isM_startSquare() {
		return m_startSquare;
	}

	/**
	 * Set the square as a start square or not.
	 *
	 * @param m_startSquare true to set the square as a start square, false otherwise
	 */
	public void setM_startSquare(boolean m_startSquare) {
		this.m_startSquare = m_startSquare;
	}

	/**
	 * Initial square setup.
	 *
	 * @param mode The game mode
	 */
	public abstract void setupSquare(GameMode mode);

	/**
	 * Action to perform if the marker's player lands on it.
	 *
	 * @param mPlayer The player who lands on the square
	 * @return The action result
	 */
	public abstract ActionResult doAction(MPlayer mPlayer);

	/**
	 * Get the square type.
	 *
	 * @return the square type
	 */
	public abstract String getSquareType();

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

	/**
	 * How to manage a notify from the observable.
	 *
	 * @param evt The notify
	 */
	@Override
	public abstract void propertyChange(PropertyChangeEvent evt);


}
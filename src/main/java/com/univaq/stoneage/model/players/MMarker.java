package com.univaq.stoneage.model.players;


import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;

import javax.persistence.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * Persistent class.
 * It knows its name, in which square it is.
 * It is observable.
 */
@Entity
@Table(name = "Marker")
public class MMarker implements Serializable {

	@Id
	private int id;

	/**
	 * The name
	 */
	@Column(name = "marker_name", length = 30)
	private String m_markerName;

	/**
	 * Reference to the square where it is.
	 */
	@OneToOne(targetEntity = MSquare.class, cascade = CascadeType.ALL)
	@JoinColumns(
			{
					@JoinColumn(name = "square_name", referencedColumnName = "square_name"),
					@JoinColumn(name = "mode", referencedColumnName = "mode")
			})
	private MSquare m_square;

	@Transient // ignore this property/field
	private final PropertyChangeSupport support; // to implement the observer pattern

	/**
	 * Default constructor.
	 */
	public MMarker() {
		support = new PropertyChangeSupport(this);

	}

	/**
	 * Get the marker name.
	 *
	 * @return The marker name
	 */
	public String getM_markerName() {
		return m_markerName;
	}

	/**
	 * Set the marker name.
	 *
	 * @param m_markerName The marker name
	 */
	public void setM_markerName(String m_markerName) {
		this.m_markerName = m_markerName;
	}

	/**
	 * Get the square in which the marker is.
	 *
	 * @return The square
	 */
	public MSquare getM_square() {
		return m_square;
	}

	/**
	 * Set the square in which the marker is.
	 *
	 * @param m_square The square
	 */
	public void setM_square(MSquare m_square) {
		this.m_square = m_square;
	}

	/**
	 * Change the square in which the marker is and notify the new location to all observer.
	 *
	 * @param aNewSquare The new square
	 */
	public void changeSquare(MSquare aNewSquare) {
		if (this.m_square != null) {
			notifyPropertyChange("square", this.m_square.getM_name(), aNewSquare.getM_name());
		}
		this.m_square = aNewSquare;
	}

	/**
	 * Get the square in which the marker is.
	 *
	 * @return The current square
	 */
	public MSquare getCurrentSquare() {
		return this.m_square;
	}

	public String getResourceTypeOfCurrentSquare() {
		String resourceType = "";
		try {
			resourceType = ((MResourceSquare) this.getCurrentSquare()).getm_resourceType();

		} catch (Exception e) {
			// it is not a resource square
		}
		return resourceType;
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
package com.univaq.stoneage.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.StringJoiner;

public class MMarker {
	private String m_markerName;
	private MSquare m_square;

	private PropertyChangeSupport support; // to implement the oberver pattern

	public MMarker() {
		support = new PropertyChangeSupport(this);
	}

	public String getM_markerName() {
		return m_markerName;
	}

	public void setM_markerName(String m_markerName) {
		this.m_markerName = m_markerName;
	}

	public void changeSquare(MSquare aNewSquare) {
		StringJoiner propertyNameJoiner = new StringJoiner("_");
		propertyNameJoiner.add(this.m_markerName).add("square"); // markerName_square
		if(this.m_square != null) {
			support.firePropertyChange(propertyNameJoiner.toString(), this.m_square.getM_name(), aNewSquare.getM_name());
		}
		this.m_square = aNewSquare;
	}

	public MSquare getCurrentSquare() {
		return m_square;
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

}
package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.players.MPlayer;

import javax.persistence.*;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

/**
 * MSquare is a persistence entity.
 * It knows its name, its the next square with which it is linked, if it is the start square.
 * It also knows the action to perform if the marker lands on it.
 */
@Entity
@Table(name = "Square")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "square_type", discriminatorType = DiscriminatorType.STRING)
public abstract class MSquare implements Serializable {
	@Id
	//@Column(name = "square_name", nullable = true, unique = true, length = 30)
	@Column(name = "square_name", unique = true, length = 30)
	private String m_name;

	@Column(name = "start_square")
	private boolean m_startSquare;

	@OneToOne(targetEntity = MSquare.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "next_square_name")
	private MSquare m_nextSquare;

	public MSquare() {
	}

	public MSquare(String m_name) {
		this.m_name = m_name;
		this.m_startSquare = false;
		this.m_nextSquare = null;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public MSquare getM_nextSquare() {
		return m_nextSquare;
	}

	public void setM_nextSquare(MSquare m_nextSquare) {
		this.m_nextSquare = m_nextSquare;
	}

	public boolean isM_startSquare() {
		return m_startSquare;
	}

	public void setM_startSquare(boolean m_startSquare) {
		this.m_startSquare = m_startSquare;
	}

	public abstract void doAction(MPlayer mPlayer);

	public abstract String getSquareType();

	public abstract void addPropertyChangeListener(PropertyChangeListener pcl);

	public abstract void removePropertyChangeListener(PropertyChangeListener pcl);

	public abstract void notifyPropertyChange(Object object);


}
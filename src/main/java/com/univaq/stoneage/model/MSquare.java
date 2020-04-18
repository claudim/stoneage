package com.univaq.stoneage.model;

import javax.persistence.*;

@Entity
@Table(name = "Square")
public class MSquare {
	@Id
	@Column(name = "square_name", nullable = true, unique = true, length = 30)
	private String m_name;

	@Column(name = "start_square")
	private boolean m_startSquare;

	@OneToOne(targetEntity = MSquare.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "next_square_name")
	private MSquare m_nextSquare;

	public MSquare() {
        super();
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
}
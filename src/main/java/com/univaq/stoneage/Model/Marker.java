package com.univaq.stoneage.Model;

public class Marker {
	//public Player m_owns;
	private String m_markerName;
	private Square m_square;

	public String getM_markerName() {
		return m_markerName;
	}

	public void setM_markerName(String m_markerName) {
		this.m_markerName = m_markerName;
	}

	public Marker(String m_markerName, Square m_square) {
		this.m_markerName = m_markerName;
		this.m_square = m_square;
	}

	public void changeSquare(Square aNewSquare) {
		this.m_square = aNewSquare;
		//throw new UnsupportedOperationException();
	}

	public Square getCurrentSquare() {
		return m_square;
		//throw new UnsupportedOperationException();
	}
}
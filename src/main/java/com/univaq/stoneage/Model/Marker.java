package com.univaq.stoneage.Model;

public class Marker {
	private String m_markerName;
	private Square m_square;

	public Marker() {
	}

	public String getM_markerName() {
		return m_markerName;
	}

	public void setM_markerName(String m_markerName) {
		this.m_markerName = m_markerName;
	}

	public void changeSquare(Square aNewSquare) {
		this.m_square = aNewSquare;
	}

	public Square getCurrentSquare() {
		return m_square;
	}
}
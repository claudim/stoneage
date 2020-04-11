package com.univaq.stoneage.Model;

public class MMarker {
	private String m_markerName;
	private MSquare m_square;

	public MMarker() {
	}

	public String getM_markerName() {
		return m_markerName;
	}

	public void setM_markerName(String m_markerName) {
		this.m_markerName = m_markerName;
	}

	public void changeSquare(MSquare aNewSquare) {
		this.m_square = aNewSquare;
	}

	public MSquare getCurrentSquare() {
		return m_square;
	}
}
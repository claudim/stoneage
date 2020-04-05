package com.univaq.stoneage.Model;

public abstract class Player {
	private Marker m_marker;

	public Marker getM_marker() {
		return m_marker;
	}

	public void setM_marker(Marker m_marker) {
		this.m_marker = m_marker;
	}

	public Player(Marker m_marker) {
		this.m_marker = m_marker;
	}

	/**
	 * @param tokenForestValue
	 * @param board
	 */
	public void moveMarker(Object tokenForestValue, Board board) {
		Square currentSquare = m_marker.getCurrentSquare();
		Square newSquare = board.findNewSquare(currentSquare,tokenForestValue);
		m_marker.changeSquare(newSquare);
	}
}
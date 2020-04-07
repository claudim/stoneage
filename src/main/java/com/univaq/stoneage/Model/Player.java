package com.univaq.stoneage.Model;

/**
 * Player resposabile del movimento del marker e della creazione del marker
 */
public abstract class Player {
	private Marker m_marker;

	public Player() {
	}

	public Marker getM_marker() {
		return m_marker;
	}

	public void setM_marker(Marker m_marker) {
		this.m_marker = m_marker;
	}

	public void createMarker(String aMarkerName, Square aNewSquare){
		Marker m = new Marker();
		m.setM_markerName(aMarkerName);
		m.changeSquare(aNewSquare);
		this.m_marker = m;
	}

	/**
	 * @param tokenForest
	 * @param board
	 */
	public void moveMarker(TokenForest tokenForest, Board board) {
		Square currentSquare = m_marker.getCurrentSquare();
		Square newSquare = FindNewSquareStrategyFactory.getInstance()
				.getFindNewSquareStrategy(tokenForest.getClass().getSimpleName())
				.findNewSquare(currentSquare, tokenForest);
		m_marker.changeSquare(newSquare);
	}
}
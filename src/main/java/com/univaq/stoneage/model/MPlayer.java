package com.univaq.stoneage.model;

/**
 * The class Player is responsible for the marker creation and marker movement.
 */
public abstract class MPlayer {
	private MMarker m_marker;
	private boolean m_winner;

	public MPlayer() {
		this.m_winner = false;
	}

	public MMarker getM_marker() {
		return m_marker;
	}

	public void setM_marker(MMarker m_marker) {
		this.m_marker = m_marker;
	}

	public void createMarker(String aMarkerName, MSquare aNewSquare){
		MMarker m = new MMarker();
		m.setM_markerName(aMarkerName);
		m.changeSquare(aNewSquare);
		this.m_marker = m;
	}

	public String getMarkerName() {
		return this.m_marker.getM_markerName();
	}

	public boolean isM_winner() {
		return m_winner;
	}

	public void setM_winner(boolean m_winner) {
		this.m_winner = m_winner;
	}

	/**
	 * @param MTokenForest
	 * @param MBoard
	 */
	public void moveMarker(MTokenForest MTokenForest, MBoard MBoard) {
		MSquare currentSquare = m_marker.getCurrentSquare();
		MFindNewSquareStrategyFactory instance = MFindNewSquareStrategyFactory.getInstance();
		MIFindNewSquareStrategy findNewSquareStrategy = instance.getFindNewSquareStrategy(MTokenForest.getClass().getSimpleName());
		MSquare newSquare = findNewSquareStrategy.findNewSquare(currentSquare, MTokenForest);
		m_marker.changeSquare(newSquare);
	}

	public abstract void playTurn();
}
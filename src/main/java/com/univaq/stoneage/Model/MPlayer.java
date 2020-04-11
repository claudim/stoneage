package com.univaq.stoneage.Model;

/**
 * Player resposabile del movimento del marker e della creazione del marker
 */
public abstract class MPlayer {
	private MMarker m_marker;

	public MPlayer() {
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

	public String getMarkerName(){
		return this.m_marker.getM_markerName();
	}

	/**
	 * @param MTokenForest
	 * @param MBoard
	 */
	public void moveMarker(MTokenForest MTokenForest, MBoard MBoard) {
		MSquare currentSquare = m_marker.getCurrentSquare();
		MSquare newSquare = MFindNewSquareStrategyFactory.getInstance()
				.getFindNewSquareStrategy(MTokenForest.getClass().getSimpleName())
				.findNewSquare(currentSquare, MTokenForest);
		m_marker.changeSquare(newSquare);
	}
}
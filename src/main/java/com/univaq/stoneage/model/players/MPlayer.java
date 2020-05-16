package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.hutTokens.MHutToken;
import com.univaq.stoneage.model.squares.MBoard;
import com.univaq.stoneage.model.squares.MBuildingSiteSquare;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.findingSquare.MFindNewSquareStrategyFactory;
import com.univaq.stoneage.model.squares.findingSquare.MIFindNewSquareStrategy;

import java.util.ArrayList;

/**
 * The class Player is responsible for the marker creation and marker movement.
 */
public abstract class MPlayer {
    private MMarker m_marker;
    private MSettlement m_settlement;
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

	public MSettlement getM_settlement() {
		return m_settlement;
	}

	public void setM_settlement(MSettlement m_settlement) {
		this.m_settlement = m_settlement;
	}

	public void createMarker(String aMarkerName, MSquare aNewSquare) {
		MMarker m = new MMarker();
		m.setM_markerName(aMarkerName);
		m.changeSquare(aNewSquare);
		this.m_marker = m;
	}

	public String getMarkerName() {
		return this.m_marker.getM_markerName();
	}

	public boolean isM_winner() {
		if (m_settlement.getM_builtHutTokens().size() == 3)
			m_winner = true;
		return m_winner;
	}

	public void setM_winner(boolean m_winner) {
		this.m_winner = m_winner;
	}

	/**
	 * @param MTokenForest
	 * @param MBoard
	 */
	public MSquare moveMarker(MTokenForest MTokenForest, MBoard MBoard) {
		MSquare currentSquare = m_marker.getCurrentSquare();
		MFindNewSquareStrategyFactory instance = MFindNewSquareStrategyFactory.getInstance();
		MIFindNewSquareStrategy findNewSquareStrategy = instance.getFindNewSquareStrategy(MTokenForest.getClass().getSimpleName());
		MSquare newSquare = findNewSquareStrategy.findNewSquare(currentSquare, MTokenForest);
		m_marker.changeSquare(newSquare);
		//MStoneAgeGame.getInstance().getGameState().onNewSquare();
		return newSquare;
	}

	public abstract void playTurn();

	public void createSettlement(String aName) {
		m_settlement = new MSettlement(aName);
	}

	public abstract void buildHut(ArrayList<MHutToken> playerBuildableHutTokens);

	public void buildHut(int idHutToken) {
		MBuildingSiteSquare mBuildingSiteSquare = (MBuildingSiteSquare) m_marker.getCurrentSquare();
		MHutToken mHutToken = mBuildingSiteSquare.removeHutToken(idHutToken);
		if (mHutToken != null) {
			m_settlement.addHutToken(mHutToken);
		}
	}


}
package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.gameState.GameState;
import com.univaq.stoneage.model.hutTokens.MHutToken;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.buildingSiteSquare.MBuildingSiteSquare;
import com.univaq.stoneage.model.squares.findingSquare.MFindNewSquareStrategyFactory;
import com.univaq.stoneage.model.squares.findingSquare.MIFindNewSquareStrategy;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;

import java.util.ArrayList;
import java.util.Optional;

/**
 * The class Player is responsible for the marker creation and marker movement.
 */
public abstract class MPlayer {
	protected MMarker m_marker;
	protected MSettlement m_settlement;
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

		IGameGoalStrategy gameGoalStrategy = MStoneAgeGame.getInstance().getM_gameGoalStrategy();
		return gameGoalStrategy.isWinner(this);
	}

	public void setM_winner(boolean m_winner) {
		this.m_winner = m_winner;
	}

	/**
	 * @param MTokenForest
	 */
	public MSquare moveMarker(MTokenForest MTokenForest) {
		MSquare currentSquare = m_marker.getCurrentSquare();
		MFindNewSquareStrategyFactory instance = MFindNewSquareStrategyFactory.getInstance();
		MIFindNewSquareStrategy findNewSquareStrategy = instance.getFindNewSquareStrategy(MTokenForest.getClass().getSimpleName());
		MSquare newSquare = findNewSquareStrategy.findNewSquare(currentSquare, MTokenForest);
		m_marker.changeSquare(newSquare);
		System.out.println(this.getMarkerName() + " è ora sulla casella " + newSquare.getM_name());
		return newSquare;
	}

	public abstract void playTurn();

	public void createSettlement(String aName) {
		m_settlement = new MSettlement(aName);
	}

	//public abstract void buildHut(ArrayList<MHutToken> playerBuildableHutTokens);
	public abstract void buildHut();

	public void buildHut(int idHutToken) {
		MBuildingSiteSquare mBuildingSiteSquare = (MBuildingSiteSquare) m_marker.getCurrentSquare();
		MHutToken mHutToken = mBuildingSiteSquare.removeHutToken(idHutToken);
		if (mHutToken != null) {
			m_settlement.addHutToken(mHutToken);
			System.out.println(this.getMarkerName() + " ha costruito 1 capanna");
		}
	}

	public abstract void stealResource();

	public void stealResource(String playerName) {
		String resourceType = ((MResourceSquare) m_marker.getCurrentSquare()).getm_resourceType();
		ArrayList<MPlayer> m_players = MStoneAgeGame.getInstance().getM_players();
		Optional<MPlayer> found = Optional.empty();
		for (MPlayer p : m_players) {
			if (p.getMarkerName().equals(playerName)) {
				found = Optional.of(p);
				break;
			}
		}
		MPlayer player = found.get();
		// if there is a resource the player steals it, nothing otherwise
		for (MResource r : player.getM_settlement().getM_resources()) {
			if (r.getM_type().equals(resourceType)) {
				player.getM_settlement().stealResource(r);
				m_settlement.addResource(r);
				System.out.println(this.getMarkerName().concat(" ha rubato 1 ").concat(resourceType).concat(" a ").concat(playerName));
				break;
			}
		}
	}

	public abstract void executeAbility();

	public abstract void executeOnSquareAbility();

	public abstract void executeOnStartTurnAbility();

	public void executeOnEndTurnAbility() {
		GameState gameState = MStoneAgeGame.getInstance().getM_gameState();
		if (isM_winner()) {
			System.out.println(this.getMarkerName() + " ha vinto la partita");
			gameState.winner();
			// visualizza vittoria
		} else {
			// next player play his turn
			System.out.println(this.getMarkerName() + " ha terminato il suo turno");
			gameState.nextTurn();
		}
	}

	public abstract MPlayer getPlayer();

	public void createMarker(String aMarkerName) {
		MMarker m = new MMarker();
		m.setM_markerName(aMarkerName);
		this.m_marker = m;

	}
}
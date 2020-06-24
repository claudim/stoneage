package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.MHutToken;
import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.gameState.GameState;
import com.univaq.stoneage.model.players.findingSquare.MFindNewSquareStrategyFactory;
import com.univaq.stoneage.model.players.findingSquare.MIFindNewSquareStrategy;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.buildingSiteSquare.MBuildingSiteSquare;
//import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;

/**
 * The class Player is responsible for the marker and settlement creation, marker movement, build a hut token, steal a resource, choose the name player to rob.
 * It knows if is the winner.
 */
public abstract class MPlayer {
	protected MMarker m_marker;
	protected MSettlement m_settlement;
	private boolean m_winner;

	/**
	 * Constructor.
	 */
	public MPlayer() {
		this.m_winner = false;
	}

	/**
	 * Get the player marker.
	 *
	 * @return The marker.
	 */
	public MMarker getM_marker() {
		return m_marker;
	}

	/**
	 * Set the marker.
	 *
	 * @param m_marker The marker.
	 */
	public void setM_marker(MMarker m_marker) {
		this.m_marker = m_marker;
	}

	/**
	 * Get the settlement.
	 *
	 * @return the settlement
	 */
	public MSettlement getM_settlement() {
		return m_settlement;
	}

	/**
	 * Set the settlement
	 *
	 * @param m_settlement the settlement
	 */
	public void setM_settlement(MSettlement m_settlement) {
		this.m_settlement = m_settlement;
	}

	/**
	 * Get the marker name.
	 *
	 * @return The marker name
	 */
	public String getMarkerName() {
		return this.m_marker.getM_markerName();
	}

	/**
	 * Check if it is the winner according to the game goal.
	 *
	 * @return true if is the winner, false otherwise
	 */
	public boolean isM_winner() {
		IGameGoalStrategy gameGoalStrategy = MStoneAgeGame.getInstance().getM_gameGoalStrategy();
		return gameGoalStrategy.isWinner(this);
	}

	/**
	 * Set winner.
	 *
	 * @param m_winner true if is the winner, false otherwise
	 */
	public void setM_winner(boolean m_winner) {
		this.m_winner = m_winner;
	}

	/**
	 * Move the marker according to the token forest.
	 *
	 * @param MTokenForest The token forest
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

	/**
	 * Start a turn.
	 */
	public abstract void playTurn();

	/**
	 * Create the settlement.
	 *
	 * @param aName The name.
	 */
	public void createSettlement(String aName) {
		m_settlement = new MSettlement(aName);
	}

	/**
	 * Build a hut token.
	 *
	 * @param idHutToken The hut token id to build.
	 */
	public void buildHut(int idHutToken) {
		MBuildingSiteSquare mBuildingSiteSquare = (MBuildingSiteSquare) m_marker.getCurrentSquare();
		MHutToken mHutToken = mBuildingSiteSquare.removeHutToken(idHutToken);
		if (mHutToken != null) {
			m_settlement.addHutToken(mHutToken);
			System.out.println(this.getMarkerName() + " ha costruito 1 capanna");
		}
	}

	/**
	 * Choose the robbed player name among game players.
	 *
	 * @return the robbed player name
	 */
	public abstract String choosePlayerToRob();

	/**
	 * Steal a resource from the player passed as parameter.
	 *
	 * @param player The robbed player
	 */
	public void stealResource(MPlayer player) {
		String resourceType = m_marker.getResourceTypeOfCurrentSquare();
		// if there is a resource the player steals it, nothing otherwise
		for (MResource r : player.getM_settlement().getM_resources()) {
			if (r.getM_type().equals(resourceType)) {
				player.getM_settlement().stealResource(r);
				m_settlement.addResource(r);
				System.out.println(this.getMarkerName().concat(" ha rubato 1 ").concat(resourceType).concat(" a ").concat(player.getMarkerName()));
				break;
			}
		}
	}

	/**
	 * Perform actions according to the player abilities when the player is on the square.
	 */
	public abstract void executeOnSquareAbility();

	/**
	 * Perform start turn actions according to the player abilities.
	 */
	public abstract void executeOnStartTurnAbility();

	/**
	 * Perform end turn actions according to the player abilities.
	 */
	public void executeOnEndTurnAbility(GameState gameState) {
		//GameState gameState = MStoneAgeGame.getInstance().getM_gameState();
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

	/**
	 * Get the player with no ability.
	 *
	 * @return The player with no ability.
	 */
	public abstract MPlayer getPlayer();

	/**
	 * Create the marker.
	 *
	 * @param aMarkerName The marker name
	 */
	public void createMarker(String aMarkerName) {
		MMarker m = new MMarker();
		m.setM_markerName(aMarkerName);
		this.m_marker = m;
	}

	/**
	 * Create the marker and set it on a square.
	 *
	 * @param aMarkerName The marker name
	 * @param aNewSquare  The square.
	 */
	public void createMarker(String aMarkerName, MSquare aNewSquare) {
		MMarker m = new MMarker();
		m.setM_markerName(aMarkerName);
		m.changeSquare(aNewSquare);
		this.m_marker = m;
	}

	/**
	 * Choose the hut token id to build.
	 *
	 * @return the hut token id
	 */
	public abstract int chooseIdHutToken();
}
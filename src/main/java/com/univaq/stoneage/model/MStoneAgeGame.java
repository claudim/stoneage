package com.univaq.stoneage.model;

import com.univaq.stoneage.dao.IGenericDAO;
import com.univaq.stoneage.dao.PersistenceServiceFactory;
import com.univaq.stoneage.model.forestTokens.MGrid;
import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.gameState.GameState;
import com.univaq.stoneage.model.hutTokens.MHutToken;
import com.univaq.stoneage.model.players.MMarker;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.MPlayerFactory;
import com.univaq.stoneage.model.players.playerTurning.MHumanPlayersFirstStrategy;
import com.univaq.stoneage.model.players.playerTurning.MINextPlayerStrategy;
import com.univaq.stoneage.model.squares.MBoard;
import com.univaq.stoneage.model.squares.MBuildingSiteSquare;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.utility.PlayerType;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;


// todo modificare classi concrete e funzioni
/**
 * MStoneAgeGame is a singleton facade controller.
 * It is responsible for the game initialization and the turn managing (System operations).
 * It is responsible for the creation of the board, grid and manages the players creation.
 * It knows board, grid, players.
 */
public class MStoneAgeGame {
	private static MStoneAgeGame instance;
	private MGrid m_grid;
	private ArrayList<MPlayer> m_players;
	private MBoard m_board;
	private MPlayerFactory m_playerFactory;
	private MINextPlayerStrategy m_nextPlayerStrategy;
	private int numPlayer;
	private GameState gameState;
	//private MPlayer activePlayer;
	protected PropertyChangeSupport support; // to implement the observer pattern

	public static MStoneAgeGame getInstance() {

		if (instance == null) {
			instance = new MStoneAgeGame();
		}
		return instance;
	}

	public void playStoneAge(String aMode, int aNumPlayers, String aMarkerName) {
		initializeStoneAgeGame(aMode, aNumPlayers, aMarkerName);
		gameState.initialize();
	}

	public void initializeStoneAgeGame(String aMode, int aNumPlayers, String aMarkerName) {
		gameState = new GameState();
		this.support = new PropertyChangeSupport(this);
		setNumPlayer(aNumPlayers);
		// create a board
		m_board = new MBoard();
		// create a grid
		m_grid = new MGrid();
		MSquare startSquare = m_board.getStartSquare();
		if (startSquare == null) {
			startSquare = m_board.getM_squares().get(0);
		}
		m_playerFactory = new MPlayerFactory();
		createPlayers(aMarkerName, startSquare, aNumPlayers);
		m_nextPlayerStrategy = new MHumanPlayersFirstStrategy(m_players.size()); // set the right strategy to identify the players order
		m_players = m_nextPlayerStrategy.sortPlayers(m_players);
		//activePlayer = m_players.get(m_nextPlayerStrategy.getIndexActivePlayer()); // set the first Player
		// m_nextPlayerStrategy = new MHumanPlayersFirstStrategy(m_players); // set the right strategy to identify the players order
		//activePlayer = getCurrentPlayer(); // set the first Player
	}

	/**
	 * Play a single player turn.
	 * System operation.
	 *
	 * @param aIdToken
	 */
	public void playTurn(int aIdToken) {
		gameState.playTurn(aIdToken);
	}

	public void buildHut(int idHutToken) {
		gameState.hutBuilt(idHutToken);
	}

	//todo se ne deve occupare stone age game di rubare la risorsa?
	public void stealResource(String playerName) {
		gameState.stealResource(playerName);
	}

	private void createPlayers(String aMarkerName, MSquare aStartSquare, int aNumPlayers) {
		m_players = new ArrayList<>();
		ArrayList<String> playersNames = this.getPlayersNamesFromDB();
		MPlayer p = this.m_playerFactory.getPlayer(PlayerType.HumanPlayer);
		p.createMarker(aMarkerName, aStartSquare);
		p.createSettlement(aMarkerName);
		m_players.add(p);
		Iterator<String> it = playersNames.iterator();
		for (int i = 0; i < aNumPlayers && it.hasNext(); i++) {
			String markerName = it.next();
			if (!markerName.equals(aMarkerName)) {
				p = this.m_playerFactory.getPlayer(PlayerType.EmulatedPlayer);
				p.createMarker(markerName, aStartSquare);
				p.createSettlement(markerName);
				m_players.add(p);
			}
		}
	}

	private ArrayList<String> getPlayersNamesFromDB() {
		ArrayList<String> playersNames = new ArrayList<>();
		IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MMarker.class.getSimpleName());
		ArrayList<MMarker> markers = dao.findAll();
		for (MMarker marker : markers) {
			playersNames.add(marker.getM_markerName());
		}
		return playersNames;
	}

	public ArrayList<MTokenForest> getAllTokenForest() {
		return this.m_grid.getM_tokens();
	}

	public ArrayList<MSquare> getAllSquare() {
		return m_board.getM_squares();

	}

	public void setM_players(ArrayList<MPlayer> m_players) {
		this.m_players = m_players;
	}

	public MINextPlayerStrategy getM_nextPlayerStrategy() {
		return m_nextPlayerStrategy;
	}

	public int getNumPlayer() {
		return numPlayer;
	}

	public void setNumPlayer(int numPlayer) {
		this.numPlayer = numPlayer;
	}

	public MGrid getM_grid() {
		return m_grid;
	}

	public ArrayList<MPlayer> getM_players() {
		return m_players;
	}

	public MBoard getM_board() {
		return m_board;
	}

	public GameState getGameState() {
		return gameState;
	}

	public MHutToken getHutToken() {
		MBuildingSiteSquare mBuildingSiteSquare = m_board.getBuildingSiteSquare();
		if (mBuildingSiteSquare != null) {
			return mBuildingSiteSquare.getNextHutTokenToBuild();
		}
		return null;
	}

	public MPlayer getActivePlayer() {
		return m_players.get(m_nextPlayerStrategy.getIndexActivePlayer());
		//return activePlayer;
	}

//	public void setActivePlayer(MPlayer activePlayer) {
//		this.activePlayer = activePlayer;
//	}

	public void setNextPlayerAsActivePlayer() {
		MPlayer activePlayer = m_players.get(m_nextPlayerStrategy.getIndexActivePlayer());
		MPlayer nextPlayer = getNextPlayer();
		notifyPropertyChange("activePlayer", activePlayer.getMarkerName(), nextPlayer.getMarkerName());
		//activePlayer = nextPlayer;
	}
//
//	private void setActivePlayer() {
//		int indexActivePlayer = this.m_nextPlayerStrategy.getIndexActivePlayer();
//		//	notifyPropertyChange();
//		activePlayer = m_players.get(indexActivePlayer);
//	}

	private MPlayer getNextPlayer() {
		int indexNextPlayer = this.m_nextPlayerStrategy.getIndexNextPlayer();
		return m_players.get(indexNextPlayer);
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	public void notifyPropertyChange(String property, Object oldObject, Object newObject) {
		support.firePropertyChange(property, oldObject, newObject);
	}
}
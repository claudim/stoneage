package com.univaq.stoneage.model;

import com.univaq.stoneage.model.forestTokens.MGrid;
import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.gameState.GameState;
import com.univaq.stoneage.model.hutTokens.MHutToken;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.MPlayerFactory;
import com.univaq.stoneage.model.players.playerTurning.MINextPlayerStrategy;
import com.univaq.stoneage.model.squares.MBoard;
import com.univaq.stoneage.model.squares.MBuildingSiteSquare;
import com.univaq.stoneage.model.squares.MSquare;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;


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
	private GameState m_gameState;
	private IGameGoalStrategy m_gameGoalStrategy;

	private GameMode m_mode;
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
		m_gameState.initialize();
	}

	public void initializeStoneAgeGame(String aMode, int aNumPlayers, String aMarkerName) {
		m_gameState = new GameState();
		m_mode = new GameMode(aMode);
		this.support = new PropertyChangeSupport(this);
		setNumPlayer(aNumPlayers);

		// create a board
		m_board = new MBoard(m_mode);
		// create a grid
		m_grid = new MGrid(m_mode);

		MSquare startSquare = m_board.getStartSquare();

		m_playerFactory = new MPlayerFactory();
		m_playerFactory.createPlayers(aNumPlayers, aMarkerName);
		m_playerFactory.setStartSquare(startSquare);
		m_players = m_playerFactory.getPlayers();

		//IGameGoalStrategyFactory gameGoalStrategyFactory = new GameGoalStrategyFactory();
		//m_gameGoalStrategy = gameGoalStrategyFactory.createGameGoalStrategy();
		m_gameGoalStrategy = m_mode.getGameGoalStrategy();

		//m_nextPlayerStrategy = new MHumanPlayersFirstStrategy(m_players.size()); // set the right strategy to identify the players order
		m_nextPlayerStrategy = m_mode.getNextPlayerStrategy(aNumPlayers);  // set the right strategy to identify the players order
		m_players = m_nextPlayerStrategy.sortPlayers(m_players);
	}

	/**
	 * Play a single player turn.
	 * System operation.
	 *
	 * @param aIdToken
	 */
	public void playTurn(int aIdToken) {
		m_gameState.playTurn(aIdToken);
	}

	public void buildHut(int idHutToken) {
		m_gameState.hutBuilt(idHutToken);
	}

	//todo se ne deve occupare stone age game di rubare la risorsa?
	public void stealResource(String playerName) {
		m_gameState.stealResource(playerName);
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

	public GameState getM_gameState() {
		return m_gameState;
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
	}

	public void setNextPlayerAsActivePlayer() {
		MPlayer activePlayer = m_players.get(m_nextPlayerStrategy.getIndexActivePlayer());
		MPlayer nextPlayer = getNextPlayer();
		notifyPropertyChange("activePlayer", activePlayer.getMarkerName(), nextPlayer.getMarkerName());
	}

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

	public IGameGoalStrategy getM_gameGoalStrategy() {
		return m_gameGoalStrategy;
	}

	public void setM_gameGoalStrategy(IGameGoalStrategy m_gameGoalStrategy) {
		this.m_gameGoalStrategy = m_gameGoalStrategy;
	}
}
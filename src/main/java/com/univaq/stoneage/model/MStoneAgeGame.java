package com.univaq.stoneage.model;

import com.univaq.stoneage.model.forestTokens.MGrid;
import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.gameMode.GameMode;
import com.univaq.stoneage.model.gameState.GameState;
import com.univaq.stoneage.model.hutTokens.MHutToken;
import com.univaq.stoneage.model.playerTurning.INextPlayerStrategy;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.playerFactory.MPlayerFactory;
import com.univaq.stoneage.model.squares.MBoard;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.buildingSiteSquare.MBuildingSiteSquare;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * MStoneAgeGame is a singleton facade controller.
 * It is responsible for the game initialization; to play a single player turn, build a hut token, steal a resource from a player.
 * It is responsible for the creation of the board, grid and manages the players creation.
 * It knows board, grid, players, game state, game mode, game goal, the game strategy to get the next player.
 */
public class MStoneAgeGame {
	private static MStoneAgeGame instance;
	private MGrid m_grid;
	private ArrayList<MPlayer> m_players;
	private MBoard m_board;
	private MPlayerFactory m_playerFactory;
	private INextPlayerStrategy m_nextPlayerStrategy;
	private int numPlayer;
	private GameState m_gameState;
	private IGameGoalStrategy m_gameGoalStrategy;
	private GameMode m_mode;
	protected PropertyChangeSupport support; // to implement the observer pattern


	/**
	 * Get the game instance.
	 *
	 * @return The game instance
	 */
	public static MStoneAgeGame getInstance() {

		if (instance == null) {
			instance = new MStoneAgeGame();
		}
		return instance;
	}

	/**
	 * Play to Stone Age game.
	 * System operation.
	 *
	 * @param aMode       The game mode
	 * @param aNumPlayers Number of players
	 * @param aMarkerName Human player's name
	 */
	public void playStoneAge(String aMode, int aNumPlayers, String aMarkerName) {
		initializeStoneAgeGame(aMode, aNumPlayers, aMarkerName);
		m_gameState.initialize();
	}

	/**
	 * Initialize the game.
	 *
	 * @param aMode       The game mode
	 * @param aNumPlayers Number of players
	 * @param aMarkerName Human player's name
	 */
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

		m_gameGoalStrategy = m_mode.getGameGoalStrategy();

		m_nextPlayerStrategy = m_mode.getNextPlayerStrategy(aNumPlayers);  // set the right strategy to identify the players order
		m_players = m_nextPlayerStrategy.sortPlayers(m_players);
	}

	/**
	 * Play a single player turn.
	 * System operation.
	 *
	 * @param aIdToken The forest token id
	 */
	public void playTurn(int aIdToken) {
		m_gameState.playTurn(aIdToken);
	}

	/**
	 * Build a hut token.
	 * System operation.
	 *
	 * @param idHutToken The hut token id
	 */
	public void buildHut(int idHutToken) {
		m_gameState.hutBuilt(idHutToken);
	}

	/**
	 * Steal a resource from one player.
	 * System operation.
	 *
	 * @param playerName The player name to be robbed
	 */
	public void stealResource(String playerName) {
		m_gameState.stealResource(playerName);
	}

	/**
	 * Get all the game forest tokens.
	 *
	 * @return The game forest tokens
	 */
	public ArrayList<MTokenForest> getAllTokenForest() {
		return this.m_grid.getM_tokens();
	}

	/**
	 * Get all the game squares.
	 *
	 * @return The game squares
	 */
	public ArrayList<MSquare> getAllSquare() {
		return m_board.getM_squares();

	}

	/**
	 * Get the strategy to manage the choice of the next player.
	 *
	 * @return The strategy to manage the choice of the next player.
	 */
	public INextPlayerStrategy getM_nextPlayerStrategy() {
		return m_nextPlayerStrategy;
	}

	/**
	 * Get the number of game players.
	 *
	 * @return The number of game players
	 */
	public int getNumPlayer() {
		return numPlayer;
	}

	/**
	 * Set the number of game players.
	 *
	 * @param numPlayer The number of game players
	 */
	public void setNumPlayer(int numPlayer) {
		this.numPlayer = numPlayer;
	}

	/**
	 * Get the game grid.
	 *
	 * @return the game grid
	 */
	public MGrid getM_grid() {
		return m_grid;
	}

	/**
	 * Get the game players.
	 *
	 * @return The game players.
	 */
	public ArrayList<MPlayer> getM_players() {
		return m_players;
	}

	/**
	 * Set the game players.
	 *
	 * @param m_players The game players.
	 */
	public void setM_players(ArrayList<MPlayer> m_players) {
		this.m_players = m_players;
	}

	/**
	 * Get the game board.
	 *
	 * @return The game board
	 */
	public MBoard getM_board() {
		return m_board;
	}

	/**
	 * Get the game state.
	 *
	 * @return The game state
	 */
	public GameState getM_gameState() {
		return m_gameState;
	}

	/**
	 * Get the next hut token to build if exists. Null otherwise.
	 *
	 * @return The next hut token to build if exists. Null otherwise.
	 */
	public MHutToken getHutToken() {
		MBuildingSiteSquare mBuildingSiteSquare = m_board.getBuildingSiteSquare();
		if (mBuildingSiteSquare != null) {
			return mBuildingSiteSquare.getNextHutTokenToBuild();
		}
		return null;
	}

	/**
	 * Get the active game player.
	 *
	 * @return The active game player
	 */
	public MPlayer getActivePlayer() {
		return m_players.get(m_nextPlayerStrategy.getIndexActivePlayer());
	}

	/**
	 * Set the active game player.
	 *
	 * @param player The active game player
	 */
	public void setActivePlayer(MPlayer player) {
		int indexActivePlayer = m_nextPlayerStrategy.getIndexActivePlayer();
		m_players.set(indexActivePlayer, player);
	}

	/**
	 * Set the next player as the active player and notify all the observers.
	 */
	public void setNextPlayerAsActivePlayer() {
		MPlayer activePlayer = m_players.get(m_nextPlayerStrategy.getIndexActivePlayer());
		MPlayer nextPlayer = getNextPlayer();
		notifyPropertyChange("activePlayer", activePlayer.getMarkerName(), nextPlayer.getMarkerName());
	}

	/**
	 * Get the next game player.
	 *
	 * @return The next game player
	 */
	private MPlayer getNextPlayer() {
		int indexNextPlayer = this.m_nextPlayerStrategy.getIndexNextPlayer();
		return m_players.get(indexNextPlayer);
	}

	/**
	 * Add an observer to the list.
	 *
	 * @param pcl The observer to add
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	/**
	 * Remove an observer from the list.
	 *
	 * @param pcl The observer to remove
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	/**
	 * Notify all the observer for the change of the property.
	 *
	 * @param property  The property name which changed its value
	 * @param oldObject The old value of the property
	 * @param newObject The new value of the property
	 */
	public void notifyPropertyChange(String property, Object oldObject, Object newObject) {
		support.firePropertyChange(property, oldObject, newObject);
	}

	/**
	 * Get the game goal strategy.
	 *
	 * @return The game goal.
	 */
	public IGameGoalStrategy getM_gameGoalStrategy() {
		return m_gameGoalStrategy;
	}

	/**
	 * Set the game goal strategy.
	 *
	 * @param m_gameGoalStrategy The game goal strategy
	 */
	public void setM_gameGoalStrategy(IGameGoalStrategy m_gameGoalStrategy) {
		this.m_gameGoalStrategy = m_gameGoalStrategy;
	}
}
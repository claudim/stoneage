package com.univaq.stoneage.model;

import com.univaq.stoneage.dao.IGenericDAO;
import com.univaq.stoneage.dao.PersistenceServiceFactory;
import com.univaq.stoneage.utility.PlayerType;

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

	private MPlayer activePlayer;

	public static MStoneAgeGame getInstance() {

		if (instance == null) {
			instance = new MStoneAgeGame();
		}
		return instance;
	}

	public void playStoneAge(String aMode, int aNumPlayers, String aMarkerName) {
		initializeStoneAgeGame(aMode, aNumPlayers, aMarkerName);
//		mainGameLoop();
		gameLoop();
	}

	private void gameLoop() {
		if (!activePlayer.isM_winner()) {
			activePlayer = getNextPlayer();
			activePlayer.playTurn();
		} else {
			//show victory
		}

	}

//	private void mainGameLoop() {
//		boolean winner = false;
//		MPlayer currentPlayer;
//		while (!winner){
//
//			currentPlayer = getCurrentPlayer();
//
//
//		}
//	}

	private void initializeStoneAgeGame(String aMode, int aNumPlayers, String aMarkerName) {
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
		m_nextPlayerStrategy = new MHumanPlayersFirstStrategy(m_players); // set the right strategy to identify the players order
		activePlayer = getCurrentPlayer(); // set the first Player

		System.out.println("inizializzato il gioco");
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


	/**
	 * Play a single player turn.
	 * System operation.
	 *
	 * @param aIdPosition
	 */
	public void playTurn(int aIdPosition) {
		MTokenForest mTokenForest = this.m_grid.faceUpTokenForest(aIdPosition);
		if (mTokenForest != null) {
			activePlayer.moveMarker(mTokenForest, m_board);
		}
		System.out.println("playturn terminato");
		gameLoop();


		//this.m_grid.getRandomTokenForest();


		//currentPlayer.chooseRandomTokenForest();
//		if (currentPlayer instanceof EmulatedPlayer) {
//
//			int idPosition = m_grid.chooseRandomTokenForest();
//			this.playTurn(idPosition);
//		}
	}


	private void createPlayers(String aMarkerName, MSquare aStartSquare, int aNumPlayers) {
		m_players = new ArrayList<>();
		ArrayList<String> playersNames = this.getPlayersNamesFromDB();
		MPlayer p = this.m_playerFactory.getPlayer(PlayerType.HumanPlayer);
		p.createMarker(aMarkerName, aStartSquare);
		m_players.add(p);
		Iterator<String> it = playersNames.iterator();
		for (int i = 0; i < aNumPlayers && it.hasNext(); i++) {
			String markerName = it.next();
			if (!markerName.equals(aMarkerName)) {
				p = this.m_playerFactory.getPlayer(PlayerType.EmulatedPlayer);
				p.createMarker(markerName, aStartSquare);
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

	public MPlayer getCurrentPlayer() {
		return this.m_nextPlayerStrategy.getCurrentPlayer();
	}

	public MPlayer getNextPlayer() {
		return this.m_nextPlayerStrategy.getNextPlayer();
	}

	public void setM_players(ArrayList<MPlayer> m_players) {
		this.m_players = m_players;
	}

	public MINextPlayerStrategy getM_nextPlayerStrategy() {
		return m_nextPlayerStrategy;
	}
}
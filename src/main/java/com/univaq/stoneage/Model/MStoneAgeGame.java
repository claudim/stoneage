package com.univaq.stoneage.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;


// todo aggiungere il player factory e modificare classi concrete e funzioni
public class MStoneAgeGame {
	private static MStoneAgeGame instance;
	private MGrid m_grid;
	private ArrayList<MPlayer> m_players;
	private MBoard m_board;
	private static int turnCounter;
	private MPlayerFactory m_playerFactory;

	public static MStoneAgeGame getInstance() {

		if (instance == null) {
			instance = new MStoneAgeGame();
		}
		return instance;
	}

	public static void setTurnCounter(int turnCounter) {
		MStoneAgeGame.turnCounter = turnCounter;
	}

	public static int getTurnCounter() {
		return turnCounter;
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

	//Per ora memorizzo il nome dei possibili giocatori quì
	//TODO recuperarli dal db
	private ArrayList<String> playersNames = new ArrayList<>();


	public void playTurn(int aIdPosition) {
		MTokenForest MTokenForest = this.m_grid.faceUpTokenForest(aIdPosition);

		MPlayer currentPlayer = m_players.get(turnCounter);
		currentPlayer.moveMarker(MTokenForest, m_board);

		//currentPlayer = this.getNextPlayer();
		//this.m_grid.getRandomTokenForest();


		//currentPlayer.chooseRandomTokenForest();
//		if (currentPlayer instanceof EmulatedPlayer) {
//
//			int idPosition = m_grid.chooseRandomTokenForest();
//			this.playTurn(idPosition);
//		}
	}

	public MPlayer getNextPlayer() {

		setTurnCounter((turnCounter + 1) % m_players.size());
		return m_players.get(turnCounter);

	}

	public void initializeStoneAgeGame(String aMode, int aNumPlayers, String aMarkerName) {
		// create a board
		this.m_board = new MBoard();
		// create a grid
		this.m_grid = new MGrid();

		MSquare startSquare = m_board.getStartSquare();
		this.m_playerFactory = new MPlayerFactory();
		addPlayersNaive();
		createPlayers(aMarkerName, startSquare, aNumPlayers);

		setFirstPlayer();
		System.out.println("inizializzato il gioco");

	}

	private void setFirstPlayer() {
		setTurnCounter(0);
	}


	private void createPlayers(String aMarkerName, MSquare aStartSquare, int aNumPlayers) {
		m_players = new ArrayList<>();
		MPlayer p = this.m_playerFactory.getPlayer("HumanPlayer");
		p.createMarker(aMarkerName, aStartSquare);
		m_players.add(p);
		Iterator<String> it = playersNames.iterator();
		for (int i = 0; i<aNumPlayers && it.hasNext(); i++)
		{
			String markerName = it.next();
			if (!markerName.equals(aMarkerName))
			{
				p = this.m_playerFactory.getPlayer("EmulatedPlayer");
				p.createMarker(markerName, aStartSquare);
				m_players.add(p);
			}
		}
	}

	private void addPlayersNaive() {
		playersNames.add("Jono");
		playersNames.add("Jada");
		playersNames.add("Martin");
		playersNames.add("Guff");
	}

	public ArrayList<MTokenForest> getAllTokenForest() {
		return this.m_grid.getM_tokens();
	}

	public ArrayList<MSquare> getAllSquare() {
		return m_board.getM_squares();

	}
}
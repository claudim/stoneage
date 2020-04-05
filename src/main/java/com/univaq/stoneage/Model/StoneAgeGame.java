package com.univaq.stoneage.Model;

import java.util.ArrayList;
import java.util.Vector;

public class StoneAgeGame {
	private Grid m_grid;
	private Vector<Player> m_players = new Vector<>();
	private Board m_board;
	private static int turnCounter;

	public static void setTurnCounter(int turnCounter) {
		StoneAgeGame.turnCounter = turnCounter;
	}


	public static int getTurnCounter() {
		return turnCounter;
	}


	public Grid getM_grid() {
		return m_grid;
	}

	public Vector<Player> getM_players() {
		return m_players;
	}

	public Board getM_board() {
		return m_board;
	}

	//Per ora memorizzo il nome dei possibili giocatori quì
	//TODO recuperarli dal db
	private ArrayList<String> playersNames = new ArrayList<>();


	public void playTurn(int aIdPosition) {
		Object tokenForestValue = this.m_grid.faceUpTokenForest(aIdPosition);
		Player currentPlayer = m_players.get(turnCounter);

		currentPlayer.moveMarker((String) tokenForestValue, m_board);

		currentPlayer = this.getNextPlayer();
		if (currentPlayer instanceof EmulatedPlayer) {

			int idPosition = m_grid.chooseRandomTokenForest();
			this.playTurn(idPosition);

		}
	}

	public Player getNextPlayer() {

		setTurnCounter((turnCounter + 1) % m_players.size());
		return m_players.get(turnCounter);

	}

	public void initializeStoneAgeGame(String aMode, int aNumPlayers, String aMarkerName) {
		// create a board
		m_board = new Board();

		// create a grid
		m_grid = new Grid();

		Square startSquare = m_board.getStartSquare();

		addPlayersNaive();

		createPlayers(aMarkerName, startSquare);

		setFirstPlayer();

	}

	private void setFirstPlayer() {
		setTurnCounter(0);
	}


	private void createPlayers(String aMarkerName, Square startSquare) {
		m_players.add(new HumanPlayer(aMarkerName, startSquare));
		//attenzione creo altri 3 giocatori todo cambiare in modo da far creare n-1 giocatori ulteriori
		for (String markerName: playersNames)
		{
			if (!markerName.equals(aMarkerName))
			m_players.add(new EmulatedPlayer(markerName, startSquare));
		}
	}

	private void addPlayersNaive() {
		playersNames.add("Jono");
		playersNames.add("Jada");
		playersNames.add("Martin");
		playersNames.add("Guff");
	}
}
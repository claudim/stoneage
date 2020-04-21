package com.univaq.stoneage.model;

import com.univaq.stoneage.dao.IGenericDAO;
import com.univaq.stoneage.dao.PersistenceServiceFactory;
import com.univaq.stoneage.utility.PlayerType;

import java.util.ArrayList;
import java.util.Iterator;


// todo modificare classi concrete e funzioni
public class MStoneAgeGame {
	private static MStoneAgeGame instance;
	private MGrid m_grid;
	private ArrayList<MPlayer> m_players;
	private MBoard m_board;
	private MPlayerFactory m_playerFactory;
	private MINextPlayerStrategy m_nextPlayerStrategy;

	public static MStoneAgeGame getInstance() {

		if (instance == null) {
			instance = new MStoneAgeGame();
		}
		return instance;
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

	public void playTurn(int aIdPosition) {
		MTokenForest MTokenForest = this.m_grid.faceUpTokenForest(aIdPosition);

		MPlayer currentPlayer = this.getCurrentPlayer();
		currentPlayer.moveMarker(MTokenForest, m_board);

		System.out.println("playturn terminato");
		currentPlayer = this.m_nextPlayerStrategy.getNextPlayer();

		//this.m_grid.getRandomTokenForest();


		//currentPlayer.chooseRandomTokenForest();
//		if (currentPlayer instanceof EmulatedPlayer) {
//
//			int idPosition = m_grid.chooseRandomTokenForest();
//			this.playTurn(idPosition);
//		}
	}

	public void initializeStoneAgeGame(String aMode, int aNumPlayers, String aMarkerName) {
        // create a board
        this.m_board = new MBoard();
        // create a grid
        this.m_grid = new MGrid();

        MSquare startSquare = m_board.getStartSquare();
        this.m_playerFactory = new MPlayerFactory();
        createPlayers(aMarkerName, startSquare, aNumPlayers);
        this.m_nextPlayerStrategy = new MANextPlayerStrategy(this.m_players); // set the right strategy to identify the players order
        MPlayer currentPlayer = this.getCurrentPlayer(); // set the first Player

        System.out.println("inizializzato il gioco");
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

	public void setM_players(ArrayList<MPlayer> m_players) {
		this.m_players = m_players;
	}
}
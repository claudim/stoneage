package com.univaq.stoneage.model;

import com.univaq.stoneage.dao.IGenericDAO;
import com.univaq.stoneage.dao.PersistenceServiceFactory;

import java.util.ArrayList;

// todo migliorare la ricerca della start square

/**
 * Board class knows all board squares and which is the start square.
 */
public class MBoard {
	private ArrayList<MSquare> m_squares;
	//private MFindNewSquareStrategyFactory MFindNewSquareStrategyFactory;

	public MBoard() {
		m_squares = new ArrayList<>();
		// create squares
		this.createBoardSquares();
	}

	public ArrayList<MSquare> getM_squares() {
		return m_squares;
	}

	public void createBoardSquares() {
		createSquareFromDB();
	}

	private void createSquareFromDB() {
		IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MSquare.class.getSimpleName());
		m_squares.addAll(dao.findAll());
	}

	private MSquare getSquareByName(String aTokenForestValue) {

		for (MSquare s : m_squares) {
			if (s.getM_name().equals(aTokenForestValue)) return s;
		}

		//todo se ritorna null bisogna gestirlo in qualche modo ad esempio lancia eccezione
		return null;

	}

	public MSquare getStartSquare() {
		// TODO migliorare
		m_squares.size();
		for (MSquare square : m_squares) {
			if (square.isM_startSquare()) {
				return square;
			}

		}
		return null;
	}

}
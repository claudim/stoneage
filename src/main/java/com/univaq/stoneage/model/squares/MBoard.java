package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.GameMode;
import com.univaq.stoneage.model.ISquareFactory;

import java.util.ArrayList;

/**
 * MBoard class is responsible for the square creation.
 * MBoard class knows all board squares, how they are connected and which is the start square.
 */
public class MBoard {
    /**
     * Field for a list of all squares.
     */
    private final ArrayList<MSquare> m_squares;

	/**
	 * Constructor.
	 * Create all squares and initialize the board fields.
	 *
	 * @param mode
	 */
	public MBoard(GameMode mode) {
		//m_squares = new ArrayList<>();

		ISquareFactory squareFactory = mode.getSquareFactory();
		m_squares = squareFactory.createSquares(mode);
		//this.createBoardSquares();
	}

	/**
	 * Get a collection of squares.
	 *
	 * @return ArrayList<MSquare> A collection of squares.
	 */
	public ArrayList<MSquare> getM_squares() {
		return m_squares;
	}

	/**
	 * Create the squares.
	 */
//	private void createBoardSquares() {
//		this.createSquareFromDB();
//	}

	/**
	 * Create the squares by accessing the DB.
	 */
//	private void createSquareFromDB() {
//		IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MSquare.class.getSimpleName());
//		m_squares.addAll(dao.findAll());
//	}

	/**
	 * Search and get a square by name if exists otherwise it returns null
	 *
	 * @param aTokenForestValue A square name forest token value.
	 * @return MSquare The searched square if exists, null otherwise.
	 */
	private MSquare getSquareByName(String aTokenForestValue) {

		for (MSquare s : m_squares) {
			if (s.getM_name().equals(aTokenForestValue)) return s;
		}
		return null;
	}

	/**
	 * Search and get the start square if exists otherwise it returns null
	 *
	 * @return MSquare The searched square if exists, null otherwise.
	 */
	public MSquare getStartSquare() {
		for (MSquare square : m_squares) {
			if (square.isM_startSquare()) {
				return square;
			}
		}
		return m_squares.get(0);
	}

	/**
	 * Search and get the building site square if exists otherwise it returns null
	 *
	 * @return MBuildingSiteSquare The searched square if exists, null otherwise.
	 */
	public MBuildingSiteSquare getBuildingSiteSquare() {
		for (MSquare square : m_squares) {
			if (square.getSquareType().equals(MBuildingSiteSquare.class.getSimpleName())) {
				return (MBuildingSiteSquare) square;
			}
		}
		return null;
	}
}
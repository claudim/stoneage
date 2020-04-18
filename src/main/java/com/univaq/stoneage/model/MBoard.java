package com.univaq.stoneage.model;

import com.univaq.stoneage.dao.SquareDAO;

import java.util.ArrayList;

// todo migliorare la ricerca della start square
/**
 * Board class knows all board squares and which is the start square.
 */
public class MBoard{
	private ArrayList<MSquare> m_squares;
	private MFindNewSquareStrategyFactory MFindNewSquareStrategyFactory;

	public MBoard() {
		m_squares = new ArrayList<>();
		// create squares
		this.createBoardSquares();
		// link among squares
		//this.linkSquare();
	}


	public ArrayList<MSquare> getM_squares() {
		return m_squares;
	}

	public void createBoardSquares() {
		//TODO  la creazione delle caselle va fatto automaticamente
		//dovrebbe esserci un ciclo for per la creazione
		//creazioneSquareNaive();
		createSquareFromDB();
	}

	//Serve solo per la creazione al volo delle caselle
	private void creazioneSquareNaive() {
		m_squares.add(new MSquare("Cantiere"));
		m_squares.add(new MSquare("Cane"));
		m_squares.add(new MSquare("Sorpresa"));
		m_squares.add(new MSquare("Prateria"));
		m_squares.add(new MSquare("Foresta"));
		m_squares.add(new MSquare("Artigiano"));
		m_squares.add(new MSquare("Cava"));
		m_squares.add(new MSquare("CampoDiBattaglia"));
		m_squares.add(new MSquare("Fiume"));
		m_squares.add(new MSquare("Mercato"));
	}

	private void createSquareFromDB() {
		SquareDAO dao = new SquareDAO();
		ArrayList<MSquare> all = (ArrayList<MSquare>) dao.findAll();
		m_squares.addAll(all);
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
		//return m_squares.
		//return m_squares.get(0); // il cantiere
		for (MSquare square : m_squares) {
			if (square.isM_startSquare()) {
				return square;
			}
		}
		return null;
	}

//	public void linkSquare() {
//		linkSquaresNaive();
//
//	}

//	private void linkSquaresNaive() {
//		m_squares.get(0).setM_nextSquare(m_squares.get(1)); // cantiere -> cane
//		m_squares.get(1).setM_nextSquare(m_squares.get(2)); // cane -> sorpresa
//		m_squares.get(2).setM_nextSquare(m_squares.get(3)); // sorpresa -> prateria
//		m_squares.get(3).setM_nextSquare(m_squares.get(4)); // prateria -> foresta
//		m_squares.get(4).setM_nextSquare(m_squares.get(5)); // foresta -> artigiano
//		m_squares.get(5).setM_nextSquare(m_squares.get(6)); // artigiano -> cava
//		m_squares.get(6).setM_nextSquare(m_squares.get(7)); // cava -> battaglia
//		m_squares.get(7).setM_nextSquare(m_squares.get(8)); // battaglia -> fiume
//		m_squares.get(8).setM_nextSquare(m_squares.get(9)); // fiume -> mercato
//		m_squares.get(9).setM_nextSquare(m_squares.get(0)); // mercato -> cantiere
//	}
}
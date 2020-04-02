package com.univaq.stoneage.Model;

import java.util.Vector;

public class Board {
	private Vector<Square> m_squares = new Vector<>();

	public Board() {
		// create squares
		this.createBoardSquares();
		// link among squares
		this.linkSquare();
	}

	public Vector<Square> getM_squares() {
		return m_squares;
	}

	public void createBoardSquares(){
		//TODO  la creazione delle caselle va fatto automaticamente

		//dovrebbe esserci un ciclo for per la creazione

		creazioneSquareNaive();

	}

	//Serve solo per la creazione al volo delle caselle
	private void creazioneSquareNaive() {
		m_squares.add(new Square("Cantiere"));
		m_squares.add(new Square("Cane"));
		m_squares.add(new Square("Sorpresa"));
		m_squares.add(new Square("Prateria"));
		m_squares.add(new Square("Foresta"));
		m_squares.add(new Square("Artigiano"));
		m_squares.add(new Square("Cava"));
		m_squares.add(new Square("CampoDiBattaglia"));
		m_squares.add(new Square("Fiume"));
		m_squares.add(new Square("Mercato"));

	}

	public Square findNewSquare(Square aCurrentSquare, String aTokenForestValue) {

		Square newSquare = aCurrentSquare;

		try{
			int intValue = Integer.parseInt(aTokenForestValue);
			for(int i = 1 ; i <= intValue; i++){
				newSquare = newSquare.getM_nextSquare();
			}

		} catch (NumberFormatException e)
		{
			newSquare = getSquareByName(aTokenForestValue);

		}

		return newSquare;
		//throw new UnsupportedOperationException();
	}

	private Square getSquareByName(String aTokenForestValue) {

		for(Square s : m_squares){
			if (s.getM_name().equals(aTokenForestValue)) return s;
		}

		//todo se ritorna null bisogna gestirlo in qualche modo ad esempio lancia eccezione
		return null;

	}

	public Square getStartSquare() {
		// TODO migliorare
		return m_squares.get(0); // il cantiere
		//throw new UnsupportedOperationException();
	}


	public void linkSquare() {
		//TODO  il collegamento delle caselle va fatto automaticamente

		// for each collegamento tra square
		/*
		for (Square square : m_squares)
		{
			square.setM_nextSquare();
		}*/

		linkSquaresNaive();


		//throw new UnsupportedOperationException();
	}

	private void linkSquaresNaive() {
		m_squares.get(0).setM_nextSquare(m_squares.get(1)); // cantiere -> cane
		m_squares.get(1).setM_nextSquare(m_squares.get(2)); // cane -> sorpresa
		m_squares.get(2).setM_nextSquare(m_squares.get(3)); // sorpresa -> prateria
		m_squares.get(3).setM_nextSquare(m_squares.get(4)); // prateria -> foresta
		m_squares.get(4).setM_nextSquare(m_squares.get(5)); // foresta -> artigiano
		m_squares.get(5).setM_nextSquare(m_squares.get(6)); // artigiano -> cava
		m_squares.get(6).setM_nextSquare(m_squares.get(7)); // cava -> battaglia
		m_squares.get(7).setM_nextSquare(m_squares.get(8)); // battaglia -> fiume
		m_squares.get(8).setM_nextSquare(m_squares.get(9)); // fiume -> mercato
		m_squares.get(9).setM_nextSquare(m_squares.get(0)); // mercato -> cantiere
	}
}
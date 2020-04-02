package com.univaq.stoneage.Model;

import java.util.ArrayList;
import java.util.Random;

public class Grid {

	private ArrayList<Integer> m_idPositionsFaceDownForestTokens;
	private ArrayList<Position> m_positions;

	public Grid() {
		m_idPositionsFaceDownForestTokens = new ArrayList<>();
		this.createPositions();
		for(Position pos: m_positions)
		{
			m_idPositionsFaceDownForestTokens.add(pos.getIdPosition());
		}
	}

	public ArrayList<Integer> getM_idPositionsFaceDownForestTokens() {
		return m_idPositionsFaceDownForestTokens;
	}



	public ArrayList<Position> getM_positions() {
		return m_positions;
	}

	public void setM_positions(ArrayList<Position> m_positions) {
		this.m_positions = m_positions;
	}

	public int chooseRandomTokenForest() {
		Random rand = new Random();
		Integer index = m_idPositionsFaceDownForestTokens.get(rand.nextInt(m_idPositionsFaceDownForestTokens.size()));
		return m_idPositionsFaceDownForestTokens.get(index);
	}

	public String faceUpTokenForest(int aIdPosition) {
		Position p = getPosition(aIdPosition);
		TokenForest t = p.getTokenForest();
		t.setState(t.FACEUP);
		removeForestTokenFromIdPositionsFaceDownForestTokens(p);
		return t.getValue();
	}

	private void removeForestTokenFromIdPositionsFaceDownForestTokens(Position p) {
		m_idPositionsFaceDownForestTokens.remove(Integer.valueOf(p.getIdPosition()));
	}

	public Position getPosition(int aIdPos) {
		return m_positions.get(aIdPos);
		//throw new UnsupportedOperationException();
	}

	private void createPositions(){
		this.m_positions = new ArrayList<>();
		for (int i=0; i<16; i++)
		{
			m_positions.add(new Position(i));
		}
	}
}
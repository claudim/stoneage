package com.univaq.stoneage.Model;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

//TODO aggiungere una strategy per individuare la strategia giusta per scegliere i token
//todo le caselle sono conosciute da db o dalla board. capire cosa fare

public class Grid {

	private ArrayList<TokenForest> m_tokens;

	public Grid() {
		this.m_tokens = new ArrayList<TokenForest>();

		//todo togli questo schifo per carità divina
		this.createTokenForestNaive();
	}


	public ArrayList<TokenForest> getM_tokens() {
		return m_tokens;
	}

	public void setM_tokens(ArrayList<TokenForest> m_tokens) {
		this.m_tokens = m_tokens;
	}

	/*public int chooseRandomTokenForest() {
		Random rand = new Random();
		Integer index = m_idPositionsFaceDownForestTokens.get(rand.nextInt(m_idPositionsFaceDownForestTokens.size()));
		return m_idPositionsFaceDownForestTokens.get(index);
	}*/

	/**
	 * Find the token forest in the given position
	 *
	 * @param position the position of the token forest
	 * @return the token forest in the given position if present
	 * @throws NoSuchElementException if the token is not present
	 */
	protected TokenForest searchTFbyPosition(int position) throws NoSuchElementException {
		return m_tokens.stream()
				.filter((t) -> t.getM_position() == position)
				.findFirst()
				.orElseThrow(NoSuchElementException::new);
	}

	public TokenForest faceUpTokenForest(int position) {
		TokenForest t;
		t = this.searchTFbyPosition(position); //todo gestire eccezione
		t.setState(t.FACEUP);
		return t;
	}

	private void createTokenForestNaive() {
		this.m_tokens.add(new SquareTokenForest(7, "cantiere"));
		this.m_tokens.add(new SquareTokenForest(8, "cane"));
		this.m_tokens.add(new SquareTokenForest(9, "sorpresa"));
		this.m_tokens.add(new SquareTokenForest(10, "prateria"));
		this.m_tokens.add(new SquareTokenForest(11, "foresta"));
		this.m_tokens.add(new SquareTokenForest(12, "artigiano"));
		this.m_tokens.add(new SquareTokenForest(13, "cava"));
		this.m_tokens.add(new SquareTokenForest(14, "campoDiBattaglia"));
		this.m_tokens.add(new SquareTokenForest(15, "fiume"));
		this.m_tokens.add(new SquareTokenForest(0, "mercato"));
		this.m_tokens.add(new DieFaceTokenForest(1, 1));
		this.m_tokens.add(new DieFaceTokenForest(2, 2));
		this.m_tokens.add(new DieFaceTokenForest(3, 3));
		this.m_tokens.add(new DieFaceTokenForest(4, 4));
		this.m_tokens.add(new DieFaceTokenForest(5, 5));
		this.m_tokens.add(new DieFaceTokenForest(6, 6));
	}

}
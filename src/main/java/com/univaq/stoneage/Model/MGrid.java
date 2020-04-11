package com.univaq.stoneage.Model;

import java.util.ArrayList;
import java.util.NoSuchElementException;

//TODO aggiungere una strategy per individuare la strategia giusta per scegliere i token
//todo le caselle sono conosciute da db o dalla board. capire cosa fare

/**
 * Grid ha la conoscenza dei token
 * ha responsibilità di girare il token e quindi ottenere il valore del token scelto
 * scegliere un token forest random
 */
public class MGrid {

	private ArrayList<MTokenForest> m_tokens;

	public MGrid() {
		this.m_tokens = new ArrayList<MTokenForest>();

		//todo togli questo schifo per carità divina
		this.createTokenForestNaive();
	}


	public ArrayList<MTokenForest> getM_tokens() {
		return m_tokens;
	}

	public void setM_tokens(ArrayList<MTokenForest> m_tokens) {
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
	protected MTokenForest searchTFbyPosition(int position) throws NoSuchElementException {
		return m_tokens.stream()
				.filter((t) -> t.getM_position() == position)
				.findFirst()
				.orElseThrow(NoSuchElementException::new);
	}

	public MTokenForest faceUpTokenForest(int position) {
		MTokenForest t;
		t = this.searchTFbyPosition(position); //todo gestire eccezione
		t.setState(t.FACEUP);
		return t;
	}

	private void createTokenForestNaive() {
		this.m_tokens.add(new MSquareMTokenForest(7, "Cantiere"));
		this.m_tokens.add(new MSquareMTokenForest(8, "Cane"));
		this.m_tokens.add(new MSquareMTokenForest(9, "Sorpresa"));
		this.m_tokens.add(new MSquareMTokenForest(10, "Prateria"));
		this.m_tokens.add(new MSquareMTokenForest(11, "Foresta"));
		this.m_tokens.add(new MSquareMTokenForest(12, "Artigiano"));
		this.m_tokens.add(new MSquareMTokenForest(13, "Cava"));
		this.m_tokens.add(new MSquareMTokenForest(14, "CampoDiBattaglia"));
		this.m_tokens.add(new MSquareMTokenForest(15, "Fiume"));
		this.m_tokens.add(new MSquareMTokenForest(0, "Mercato"));
		this.m_tokens.add(new MDieFaceMTokenForest(1, 1));
		this.m_tokens.add(new MDieFaceMTokenForest(2, 2));
		this.m_tokens.add(new MDieFaceMTokenForest(3, 3));
		this.m_tokens.add(new MDieFaceMTokenForest(4, 4));
		this.m_tokens.add(new MDieFaceMTokenForest(5, 5));
		this.m_tokens.add(new MDieFaceMTokenForest(6, 6));
	}
}
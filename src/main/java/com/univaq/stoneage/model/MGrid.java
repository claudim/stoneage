package com.univaq.stoneage.model;

import java.util.ArrayList;
import java.util.NoSuchElementException;

//TODO aggiungere una strategy per individuare la strategia giusta per scegliere i token
/**
 * Grid is a Pure Fabrication class to manage forest tokens. It creates, knows and manages them.
 * It is responsible for the forest tokens creations, to face up a single token to get it value.
 * scegliere un token forest random
 */
public class MGrid {

	/**
	 * Field for a list of all forest tokens.
	 */
	private ArrayList<MTokenForest> m_tokens;

	/**
	 * Constructor.
	 * Create all forest tokens and initialize the grid fields.
	 */
	public MGrid() {
		m_tokens = new ArrayList<MTokenForest>();
		createTokenForest();
	}

	/**
	 * Get a collection of forest token.
	 *
	 * @return ArrayList<MTokenForest> A collection of forest token
	 */
	public ArrayList<MTokenForest> getM_tokens() {
		return m_tokens;
	}

	public void setM_tokens(ArrayList<MTokenForest> m_tokens) {
		this.m_tokens = m_tokens;
	}

	/**
	 * Create the forest token
	 */
	public void createTokenForest() {
		this.createTokenForestNaive();
//		IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MTokenForest.class.getSimpleName());
//		m_tokens.addAll(dao.findAll());
	}

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

	/**
	 * Face up the forest token by the position.
	 *
	 * @param position int the forest token position.
	 * @return the forest token
	 */
	public MTokenForest faceUpTokenForest(int position) {
		MTokenForest t;
		try {
			t = searchTFbyPosition(position);
			t.setState(t.FACEUP);
		} catch (NoSuchElementException e) {
			t = null;
		}
		return t;
	}

	// to delete
	private void createTokenForestNaive() {
		this.m_tokens.add(new MSquareTokenForest(7, "Cantiere"));
		this.m_tokens.add(new MSquareTokenForest(8, "Cane"));
		this.m_tokens.add(new MSquareTokenForest(9, "Sorpresa"));
		this.m_tokens.add(new MSquareTokenForest(10, "Prateria"));
		this.m_tokens.add(new MSquareTokenForest(11, "Foresta"));
		this.m_tokens.add(new MSquareTokenForest(12, "Artigiano"));
		this.m_tokens.add(new MSquareTokenForest(13, "Cava"));
		this.m_tokens.add(new MSquareTokenForest(14, "Battaglia"));
		this.m_tokens.add(new MSquareTokenForest(15, "Fiume"));
		this.m_tokens.add(new MSquareTokenForest(0, "Mercato"));
		this.m_tokens.add(new MDieFaceTokenForest(1, 1));
		this.m_tokens.add(new MDieFaceTokenForest(2, 2));
		this.m_tokens.add(new MDieFaceTokenForest(3, 3));
		this.m_tokens.add(new MDieFaceTokenForest(4, 4));
		this.m_tokens.add(new MDieFaceTokenForest(5, 5));
		this.m_tokens.add(new MDieFaceTokenForest(6, 6));
	}

	/*public int chooseRandomTokenForest() {
		Random rand = new Random();
		Integer index = m_idPositionsFaceDownForestTokens.get(rand.nextInt(m_idPositionsFaceDownForestTokens.size()));
		return m_idPositionsFaceDownForestTokens.get(index);
	}*/
}
package com.univaq.stoneage.model.forestTokens;

import com.univaq.stoneage.dao.IGenericDAO;
import com.univaq.stoneage.dao.PersistenceServiceFactory;
import com.univaq.stoneage.model.shuffle.CollectionsShuffleStrategy;
import com.univaq.stoneage.model.shuffle.IShuffleStrategy;
import com.univaq.stoneage.utility.TokenState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static com.univaq.stoneage.utility.TokenState.FACEDOWN;

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

	private final PropertyChangeSupport support = new PropertyChangeSupport(this); // to implement the observer pattern between MGrid and UGrid
	/**
	 * Field for the shuffle strategy.
	 */
	private IShuffleStrategy m_shuffleStrategy;


	/**
	 * Constructor.
	 * Create all forest tokens and initialize the grid fields.
	 */
	public MGrid() {
		m_tokens = new ArrayList<MTokenForest>();
		m_shuffleStrategy = new CollectionsShuffleStrategy();
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

	public IShuffleStrategy getM_shuffleStrategy() {
		return m_shuffleStrategy;
	}

	public void setM_shuffleStrategy(IShuffleStrategy m_shuffleStrategy) {
		this.m_shuffleStrategy = m_shuffleStrategy;
	}

	/**
	 * Create the forest token
	 */
	public void createTokenForest() {
		//this.createTokenForestNaive();
		IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MTokenForest.class.getSimpleName());
		m_tokens.addAll(dao.findAll());
	}

	/**
	 * Find the token forest in the given id
	 *
	 * @param idToken the id of the token forest
	 * @return the token forest in the given id if present
	 * @throws NoSuchElementException if the token is not present
	 */
	public MTokenForest searchTFbyId(int idToken) throws NoSuchElementException {
		return m_tokens.stream()
				.filter((t) -> t.getToken_id() == idToken)
				.findFirst()
				.orElseThrow(NoSuchElementException::new);
	}

	/**
	 * Face up the forest token by the idToken.
	 *
	 * @param idToken int the forest token id.
	 * @return the forest token
	 */
	public MTokenForest faceUpTokenForest(int idToken) {
		MTokenForest t;
		try {
			t = searchTFbyId(idToken);
			t.setState(TokenState.FACEUP);
		} catch (NoSuchElementException e) {
			t = null;
		}
		return t;
	}

	/*public int chooseRandomTokenForest() {
		Random rand = new Random();
		Integer index = m_idPositionsFaceDownForestTokens.get(rand.nextInt(m_idPositionsFaceDownForestTokens.size()));
		return m_idPositionsFaceDownForestTokens.get(index);
	}*/

	/**
	 * Shuffle, set to face down and change position to all forest token.
	 */
	public void forestTokenShuffle() {
		this.m_shuffleStrategy.shuffle(m_tokens);
		m_tokens.forEach(tokenForest -> tokenForest.setState(FACEDOWN));
		notifyPropertyChangeListener("shuffleForestToken", null, this.m_tokens);
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	public void notifyPropertyChangeListener(String propertyName, Object oldValue, Object newValue) {
		support.firePropertyChange(propertyName, oldValue, newValue);
	}
}
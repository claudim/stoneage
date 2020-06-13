package com.univaq.stoneage.model.forestTokens;

import com.univaq.stoneage.model.forestTokens.forestTokenFactory.ITokenForestFactory;
import com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing.MINextForestTokenStrategy;
import com.univaq.stoneage.model.gameMode.GameMode;
import com.univaq.stoneage.model.shuffle.IShuffleStrategy;
import com.univaq.stoneage.utility.TokenState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.univaq.stoneage.utility.TokenState.FACEDOWN;

/**
 * Grid is a Pure Fabrication class to manage forest tokens. It creates, knows and manages them.
 * It is responsible for the forest tokens creations, to face up a single token to get it value.
 * It has a reference to a strategy for choosing the next forest token and for shuffling the tokens.
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
	 * Reference to a strategy for choosing the next forest token.
	 */
	private MINextForestTokenStrategy m_nextForestTokenStrategy;

	/**
	 * Constructor.
	 * Create all forest tokens and initialize the grid fields.
	 */
	public MGrid(GameMode mode) {

		ITokenForestFactory forestTokenFactory = mode.getForestTokenFactory();
		m_tokens = forestTokenFactory.createForestTokens();
		m_shuffleStrategy = mode.getShuffleStrategy();
		m_nextForestTokenStrategy = mode.getNextForestTokenStrategy();

	}

	/**
	 * Get a collection of forest token.
	 *
	 * @return ArrayList<MTokenForest> A collection of forest token
	 */
	public ArrayList<MTokenForest> getM_tokens() {
		return m_tokens;
	}

	/**
	 * Set the forest tokens.
	 *
	 * @param m_tokens The forest tokens
	 */
	public void setM_tokens(ArrayList<MTokenForest> m_tokens) {
		this.m_tokens = m_tokens;
	}

	/**
	 * Get the shuffle strategy.
	 *
	 * @return the shuffle strategy
	 */
	public IShuffleStrategy getM_shuffleStrategy() {
		return m_shuffleStrategy;
	}

	/**
	 * Set the shuffle strategy.
	 *
	 * @param m_shuffleStrategy the shuffle strategy
	 */
	public void setM_shuffleStrategy(IShuffleStrategy m_shuffleStrategy) {
		this.m_shuffleStrategy = m_shuffleStrategy;
	}

	/**
	 * Get the strategy for choosing the next forest token.
	 *
	 * @return The strategy for choosing the next forest token
	 */
	public MINextForestTokenStrategy getM_nextForestTokenStrategy() {
		return m_nextForestTokenStrategy;
	}

	/**
	 * Set the strategy for choosing the next forest token.
	 *
	 * @param m_nextForestTokenStrategy The strategy for choosing the next forest token.
	 */
	public void setM_nextForestTokenStrategy(MINextForestTokenStrategy m_nextForestTokenStrategy) {
		this.m_nextForestTokenStrategy = m_nextForestTokenStrategy;
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
				.filter((t) -> t.getIdToken() == idToken)
				.findFirst()
				.orElseThrow(NoSuchElementException::new);
	}

	/**
	 * Find the token forest by its value
	 *
	 * @param value the value of the token forest.
	 * @return the token forest with this value if present, null otherwise
	 */
	public MTokenForest searchTFbyValue(String value) throws NoSuchElementException {
		for (MTokenForest tokenForest : m_tokens) {
			if (tokenForest.getValue().toString().equals(value)) {
				return tokenForest;
			}
		}
		return null;
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

	/**
	 * Get all forest tokens in face down state
	 *
	 * @return list of forest tokens in face down state
	 */
	public List<MTokenForest> getFACEDOWNTokenForest() {
		ArrayList<MTokenForest> FACEDOWNTokens = new ArrayList<>();
		m_tokens.forEach(tf -> {
			if (tf.getState().equals(FACEDOWN)) FACEDOWNTokens.add(tf);
		});
		return FACEDOWNTokens;
	}

	public int getNextForestTokenId() {
		return m_nextForestTokenStrategy.getNextForestTokenId(getFACEDOWNTokenForest());
	}

	/**
	 * Shuffle, set to face down and change position to all forest token.
	 */
	public void forestTokenShuffle() {
		m_shuffleStrategy.shuffle(m_tokens);
		m_tokens.forEach(tokenForest -> tokenForest.setState(FACEDOWN));
		notifyPropertyChangeListener("shuffleForestToken", null, this.m_tokens);
	}

	/**
	 * Add an observer to the list.
	 *
	 * @param pcl The observer to add
	 */
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	/**
	 * Remove an observer from the list.
	 *
	 * @param pcl The observer to remove
	 */
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	/**
	 * Notify all the observer for the change of the property.
	 *
	 * @param property The property name which changed its value
	 * @param oldValue The old value of the property
	 * @param newValue The new value of the property
	 */
	public void notifyPropertyChangeListener(String property, Object oldValue, Object newValue) {
		support.firePropertyChange(property, oldValue, newValue);
	}
}
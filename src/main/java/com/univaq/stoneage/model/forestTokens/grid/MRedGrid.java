package com.univaq.stoneage.model.forestTokens.grid;


import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing.MRandomNextForestTokenStrategy;
import com.univaq.stoneage.persistence.IPersistentGeneric;
import com.univaq.stoneage.persistence.PersistenceServiceFactory;
import com.univaq.stoneage.utility.shuffle.NoShuffleStrategy;

/**
 * Concrete Grid class for the red mode. It initializes the grid with appropriate strategies for red mode
 */
public class MRedGrid extends MGrid {
    /**
     * Constructor.
     * Create all forest tokens and initialize the red grid fields.
     */
    public MRedGrid() {
        makeForestTokens();
        makeNextForestTokenStrategy();
        makeShufflingStrategy();
    }

    /**
     * Create token forest for red mode from db by ORM
     */
    protected void makeForestTokens() {
        IPersistentGeneric dao = PersistenceServiceFactory.getInstance().getPersistenceClass(MTokenForest.class.getSimpleName(), "rossa");
        m_tokens = dao.findAll();
    }

    /**
     * Create a strategy for choosing next token forest.
     */
    private void makeNextForestTokenStrategy() {
        m_nextForestTokenStrategy = new MRandomNextForestTokenStrategy();
    }

    /**
     * Create a strategy for shuffling token forest.
     */
    private void makeShufflingStrategy() {
        m_shuffleStrategy = new NoShuffleStrategy();
    }


}

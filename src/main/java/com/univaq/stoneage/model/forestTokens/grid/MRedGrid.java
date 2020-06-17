package com.univaq.stoneage.model.forestTokens.grid;


import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing.MRandomNextForestTokenStrategy;
import com.univaq.stoneage.persistence.IPersistentGeneric;
import com.univaq.stoneage.persistence.PersistenceServiceFactory;
import com.univaq.stoneage.utility.shuffle.NoShuffleStrategy;

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

    private void makeForestTokens() {
        IPersistentGeneric dao = PersistenceServiceFactory.getInstance().getPersistenceClass(MTokenForest.class.getSimpleName(), "rossa");
        m_tokens = dao.findAll();
    }

    private void makeNextForestTokenStrategy() {
        m_nextForestTokenStrategy = new MRandomNextForestTokenStrategy();
    }

    private void makeShufflingStrategy() {
        m_shuffleStrategy = new NoShuffleStrategy();
    }


}

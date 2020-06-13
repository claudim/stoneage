package com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing;

import com.univaq.stoneage.model.forestTokens.MTokenForest;

import java.util.List;

/**
 * Interface to a strategy to get the next forest token id.
 */
public interface MINextForestTokenStrategy {
    /**
     * Get the next forest token id from a list.
     *
     * @param tokens List of token
     * @return the forest token id
     */
    int getNextForestTokenId(List<MTokenForest> tokens);
}

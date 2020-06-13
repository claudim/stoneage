package com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing;

import com.univaq.stoneage.model.forestTokens.MTokenForest;

import java.util.List;
import java.util.Random;

/**
 * It is responsible to choose the next forest token id using java.util.Random
 */
public class MRandomNextForestTokenStrategy implements MINextForestTokenStrategy {

    /**
     * Get the next forest token id from a list using java.util.Random.
     *
     * @param tokens List of token
     * @return The token id
     */
    @Override
    public int getNextForestTokenId(List<MTokenForest> tokens) {
        Random rand = new Random();
        return tokens.get(rand.nextInt(tokens.size())).getIdToken();
    }
}

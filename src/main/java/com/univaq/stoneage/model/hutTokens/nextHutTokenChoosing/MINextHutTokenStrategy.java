package com.univaq.stoneage.model.hutTokens.nextHutTokenChoosing;

import com.univaq.stoneage.model.hutTokens.MHutToken;

import java.util.List;

/**
 * Interface defining methods for any strategy to find next hut token
 */
public interface MINextHutTokenStrategy {
    /**
     * Get next hut token id in a given list
     *
     * @param tokens list of hut token
     * @return id of next hut
     */
    int getNextHutTokenId(List<MHutToken> tokens);
}

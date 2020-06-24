package com.univaq.stoneage.model.squares.nextHutTokenChoosing;

import com.univaq.stoneage.model.MHutToken;

import java.util.List;
import java.util.Random;

/**
 * Strategy that return random index in a list of hut tokens
 */
public class MRandomNextHutTokenStrategy implements MINextHutTokenStrategy {

    /**
     * Get random index of a list
     *
     * @param tokens list of hut token
     * @return random index
     */
    @Override
    public int getNextHutTokenId(List<MHutToken> tokens) {
        Random rand = new Random();
        return tokens.get(rand.nextInt(tokens.size())).getIdToken();
    }

}

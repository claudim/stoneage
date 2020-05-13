package com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing;

import com.univaq.stoneage.model.forestTokens.MTokenForest;

import java.util.List;
import java.util.Random;

public class MRandomNextForestTokenStrategy implements MINextForestTokenStrategy {

    @Override
    public int getNextForestTokenId(List<MTokenForest> tokens) {
        Random rand = new Random();
        return tokens.get(rand.nextInt(tokens.size())).getToken_id();
    }
}

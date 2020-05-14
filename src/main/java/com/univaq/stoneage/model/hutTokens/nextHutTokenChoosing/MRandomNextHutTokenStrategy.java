package com.univaq.stoneage.model.hutTokens.nextHutTokenChoosing;

import com.univaq.stoneage.model.hutTokens.MHutToken;

import java.util.List;
import java.util.Random;

public class MRandomNextHutTokenStrategy implements MINextHutTokenStrategy {

    @Override
    public int getNextHutTokenId(List<MHutToken> tokens) {
        Random rand = new Random();
        return tokens.get(rand.nextInt(tokens.size())).getIdToken();
    }

}

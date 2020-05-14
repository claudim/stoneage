package com.univaq.stoneage.model.hutTokens.nextHutTokenChoosing;

import com.univaq.stoneage.model.hutTokens.MHutToken;

import java.util.List;

public interface MINextHutTokenStrategy {
    int getNextHutTokenId(List<MHutToken> tokens);
}

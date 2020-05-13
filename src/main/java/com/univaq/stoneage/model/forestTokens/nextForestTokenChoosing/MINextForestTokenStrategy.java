package com.univaq.stoneage.model.forestTokens.nextForestTokenChoosing;

import com.univaq.stoneage.model.forestTokens.MTokenForest;

import java.util.List;

public interface MINextForestTokenStrategy {
    int getNextForestTokenId(List<MTokenForest> tokens);
}

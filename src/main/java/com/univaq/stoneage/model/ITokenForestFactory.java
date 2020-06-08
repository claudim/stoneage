package com.univaq.stoneage.model;

import com.univaq.stoneage.model.forestTokens.MTokenForest;

import java.util.ArrayList;

public interface ITokenForestFactory {

    ArrayList<MTokenForest> createForestTokens();
}

package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.hutTokens.MHutToken;
import com.univaq.stoneage.model.players.MPlayer;

import java.util.ArrayList;

public interface ICheckBuildableHutStrategy {
    ArrayList<MHutToken> checkBuildableHut(MPlayer player, ArrayList<MHutToken> hutTokensToCheck);
}

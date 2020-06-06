package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.squares.surpriseToken.ISurpriseTokenCommand;

public interface IPlayerAbilityCombiningStrategyFactory {
    IPlayerAbilityCombiningStrategy getStrategy(MPlayer player, ISurpriseTokenCommand surpriseTokenCommand);
}

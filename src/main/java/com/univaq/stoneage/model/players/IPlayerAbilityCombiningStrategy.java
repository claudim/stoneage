package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.squares.surpriseToken.ISurpriseTokenCommand;

public interface IPlayerAbilityCombiningStrategy {

    MPlayer combineAbilities(MPlayer player, ISurpriseTokenCommand surpriseTokenCommand);

}

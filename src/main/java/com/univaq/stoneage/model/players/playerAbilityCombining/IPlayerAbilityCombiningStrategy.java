package com.univaq.stoneage.model.players.playerAbilityCombining;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.ISurpriseTokenCommand;

public interface IPlayerAbilityCombiningStrategy {

    MPlayer combineAbilities(MPlayer player, ISurpriseTokenCommand surpriseTokenCommand);
}

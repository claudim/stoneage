package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.squares.surpriseToken.ISurpriseTokenCommand;
import com.univaq.stoneage.utility.PlayerType;

public interface IPlayerFactory {
    MPlayer getPlayer(PlayerType aPlayerType);

    //crea il player con abilità
    MPlayer getPlayer(MPlayer player, ISurpriseTokenCommand ability);
}

package com.univaq.stoneage.model.players.playerFactory;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.ISurpriseTokenCommand;
import com.univaq.stoneage.utility.PlayerType;

public interface IPlayerFactory {
    MPlayer getPlayer(PlayerType aPlayerType);

    //crea il player con abilità
    MPlayer getPlayer(MPlayer player, ISurpriseTokenCommand ability);
}

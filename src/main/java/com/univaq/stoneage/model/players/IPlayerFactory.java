package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.squares.surpriseToken.ISurpriseTokenCommand;
import com.univaq.stoneage.utility.PlayerType;

public interface IPlayerFactory {
    MPlayer getPlayer(PlayerType aPlayerType);

    MPlayer getPlayer(MPlayer player, ISurpriseTokenCommand ability);
}

package com.univaq.stoneage.model.players.playerAbilityCombining;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.ISurpriseTokenCommand;

public class KeepCurrentAbilityStrategy implements IPlayerAbilityCombiningStrategy {
    @Override
    public MPlayer combineAbilities(MPlayer player, ISurpriseTokenCommand surpriseTokenCommand) {
        return player;
    }
}

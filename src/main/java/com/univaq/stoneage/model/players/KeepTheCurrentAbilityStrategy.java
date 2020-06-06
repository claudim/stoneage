package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.squares.surpriseToken.ISurpriseTokenCommand;

public class KeepTheCurrentAbilityStrategy implements IPlayerAbilityCombiningStrategy {
    @Override
    public MPlayer combineAbilities(MPlayer player, ISurpriseTokenCommand surpriseTokenCommand) {
        return player;
    }
}

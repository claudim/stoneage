package com.univaq.stoneage.model.players.playerAbilityCombining;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.ISurpriseTokenCommand;

/**
 * This strategy keeps only the current ability.
 */
public class KeepCurrentAbilityStrategy implements IPlayerAbilityCombiningStrategy {
    /**
     * Keep only the current ability so do not combine the abilities.
     *
     * @param player               The player
     * @param surpriseTokenCommand The surprise token
     * @return
     */
    @Override
    public MPlayer combineAbilities(MPlayer player, ISurpriseTokenCommand surpriseTokenCommand) {
        return player;
    }
}

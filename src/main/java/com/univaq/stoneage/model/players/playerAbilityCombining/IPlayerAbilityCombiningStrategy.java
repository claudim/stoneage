package com.univaq.stoneage.model.players.playerAbilityCombining;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.ISurpriseTokenCommand;

/**
 * Define a common interface for the strategy to combining the player abilities.
 */
public interface IPlayerAbilityCombiningStrategy {

    /**
     * Combine the abilities of the player with the ability given bu the surprise token in a new player.
     *
     * @param player               The player
     * @param surpriseTokenCommand The surprise token
     * @return The player with the combined abilites.
     */
    MPlayer combineAbilities(MPlayer player, ISurpriseTokenCommand surpriseTokenCommand);
}

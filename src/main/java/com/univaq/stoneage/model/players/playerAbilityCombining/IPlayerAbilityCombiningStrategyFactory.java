package com.univaq.stoneage.model.players.playerAbilityCombining;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.ISurpriseTokenCommand;

/**
 * Define a common interface to create the player ability combining strategy.
 */
public interface IPlayerAbilityCombiningStrategyFactory {
    /**
     * Get the player ability combining strategy.
     *
     * @param player               The player
     * @param surpriseTokenCommand The surprise token
     * @return The combining strategy
     */
    IPlayerAbilityCombiningStrategy getStrategy(MPlayer player, ISurpriseTokenCommand surpriseTokenCommand);
}

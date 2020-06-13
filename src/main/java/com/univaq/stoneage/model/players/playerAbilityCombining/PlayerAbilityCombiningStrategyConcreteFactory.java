package com.univaq.stoneage.model.players.playerAbilityCombining;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.ISurpriseTokenCommand;

/**
 * Factory to create the player ability combining strategy.
 */
public class PlayerAbilityCombiningStrategyConcreteFactory implements IPlayerAbilityCombiningStrategyFactory {

    /**
     * Get the setOnlyNewAbility combining strategy.
     *
     * @param player               The player
     * @param surpriseTokenCommand The surprise token
     * @return The combining strategy
     */
    @Override
    public IPlayerAbilityCombiningStrategy getStrategy(MPlayer player, ISurpriseTokenCommand surpriseTokenCommand) {
        if (player.getClass().getSuperclass().getSimpleName().equals(MPlayer.class.getSimpleName()))
            return new SetOnlyNewAbilityStrategy(); // dota il player (CHE è SENZA ABILITà) di una abilità
        else
            // scegli in base ai parametri quale strategia adottare
            return new SetOnlyNewAbilityStrategy();
    }

}

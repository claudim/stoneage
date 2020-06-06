package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.squares.surpriseToken.ISurpriseTokenCommand;

public class PlayerAbilityCombiningStrategyConcreteFactory implements IPlayerAbilityCombiningStrategyFactory {

    @Override
    public IPlayerAbilityCombiningStrategy getStrategy(MPlayer player, ISurpriseTokenCommand surpriseTokenCommand) {
        if (player.getClass().getSuperclass().getSimpleName().equals(MPlayer.class.getSimpleName()))
            return new SetOnlyTheNewAbilityStrategy(); // dota il player (CHE è SENZA ABILITà) di una abilità
        else
            // scegli in base ai parametri quale strategia adottare
            return new SetOnlyTheNewAbilityStrategy();
    }

}

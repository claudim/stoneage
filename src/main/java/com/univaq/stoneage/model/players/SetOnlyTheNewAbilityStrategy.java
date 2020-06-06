package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.squares.surpriseToken.ISurpriseTokenCommand;

public class SetOnlyTheNewAbilityStrategy implements IPlayerAbilityCombiningStrategy {
    @Override
    public MPlayer combineAbilities(MPlayer player, ISurpriseTokenCommand surpriseTokenCommand) {
        MPlayer playerWithNoAbility = player.getPlayer();
        MPlayer playerWithAbilities;
        switch (surpriseTokenCommand.getClass().getSimpleName()) {
            case "TwoResourcesSupriseTokenCommand":
                playerWithAbilities = new Take2ResourcesAbilityPlayerDecorator(playerWithNoAbility);
                break;

            case "SkipTurnSurpriseTokenCommand":
                playerWithAbilities = new SkipNextTurnAbilityPlayerDecorator(playerWithNoAbility);
                break;

            case "TakeAnotherTurnSurpriseTokenCommand":
                playerWithAbilities = new TakeAnotherTurnAbilityPlayerDecorator(playerWithNoAbility);
                break;

            default:
                playerWithAbilities = playerWithNoAbility;
                break;
        }
        return playerWithAbilities;
    }
}

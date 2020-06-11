package com.univaq.stoneage.model.players.playerAbilityCombining;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.extraAbilityPlayer.SkipNextTurnAbilityPlayerDecorator;
import com.univaq.stoneage.model.players.extraAbilityPlayer.Take2ResourcesAbilityPlayerDecorator;
import com.univaq.stoneage.model.players.extraAbilityPlayer.TakeAnotherTurnAbilityPlayerDecorator;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.ISurpriseTokenCommand;

public class SetOnlyNewAbilityStrategy implements IPlayerAbilityCombiningStrategy {
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

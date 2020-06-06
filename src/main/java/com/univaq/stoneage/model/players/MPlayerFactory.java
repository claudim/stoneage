package com.univaq.stoneage.model.players;

import com.univaq.stoneage.model.squares.surpriseToken.ISurpriseTokenCommand;
import com.univaq.stoneage.utility.PlayerType;

/**
 * PlayerFactory is responsible for the player creation
 */
public class MPlayerFactory implements IPlayerFactory {

    public MPlayer getPlayer(PlayerType aPlayerType) {
        switch (aPlayerType) {
            case HumanPlayer:
                return new MHumanPlayer();
            default:
                return new MEmulatedPlayer();
        }
    }

    public MPlayer getPlayer(MPlayer player, ISurpriseTokenCommand ability) {

        IPlayerAbilityCombiningStrategyFactory playerAbilityCombiningStrategyFactory = new PlayerAbilityCombiningStrategyConcreteFactory();
        IPlayerAbilityCombiningStrategy combiningStrategy = playerAbilityCombiningStrategyFactory.getStrategy(player, ability);
        return combiningStrategy.combineAbilities(player, ability);
    }
}

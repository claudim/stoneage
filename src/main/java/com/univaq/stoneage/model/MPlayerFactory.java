package com.univaq.stoneage.model;

import com.univaq.stoneage.utility.PlayerType;

/**
 * PlayerFactory is responsible for the player creation
 */
public class MPlayerFactory {

    public MPlayer getPlayer(PlayerType aPlayerType) {
        switch (aPlayerType) {
            case HumanPlayer:
                return new MHumanPlayer();
            default:
                return new MEmulatedPlayer();
        }
    }
}

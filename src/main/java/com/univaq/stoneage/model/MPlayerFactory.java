package com.univaq.stoneage.model;

/**
 * PlayerFactory is responsible for the player creation
 */
public class MPlayerFactory {

    public MPlayer getPlayer(String aPlayerType){
        switch (aPlayerType) {
            case "HumanPlayer":
                return new MHumanPlayer();
            default:
                return new MEmulatedPlayer();
        }
    }
}

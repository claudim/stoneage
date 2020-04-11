package com.univaq.stoneage.Model;

/**
 * PlayerFactory is responsible for the player creation
 */
public class MPlayerFactory {

    public MPlayer getPlayer(String aPlayerType){
        switch (aPlayerType) {
            case "HumanPlayer": return new MHumanMPlayer();
            default: return new MEmulatedMPlayer();
        }
    }
}

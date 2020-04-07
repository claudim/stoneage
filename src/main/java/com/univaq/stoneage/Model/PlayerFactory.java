package com.univaq.stoneage.Model;

/**
 * PlayerFactory is responsible for the player creation
 */
public class PlayerFactory {

    public Player getPlayer(String aPlayerType){
        switch (aPlayerType) {
            case "HumanPlayer": return new HumanPlayer();
            default: return new EmulatedPlayer();
        }
    }
}

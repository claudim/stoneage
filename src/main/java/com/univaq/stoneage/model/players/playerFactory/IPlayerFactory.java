package com.univaq.stoneage.model.players.playerFactory;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.ISurpriseTokenCommand;
import com.univaq.stoneage.utility.PlayerType;

import java.util.ArrayList;

/**
 * Interface for the player factory.
 */
public interface IPlayerFactory {

    /**
     * Create a player.
     *
     * @param aPlayerType the player type to create
     * @return the created player
     */
    MPlayer getPlayer(PlayerType aPlayerType);

    /**
     * Create a player with abilities starting from a player according to the surprise token.
     *
     * @param player  The starting player
     * @param ability The surprise token command
     * @return The new player
     */
    MPlayer getPlayer(MPlayer player, ISurpriseTokenCommand ability);

    /**
     * Create all the game players.
     *
     * @param aNumPlayers      The number of the player to create
     * @param nameHumanPlayers The human players' name
     * @return List of players
     */
    ArrayList<MPlayer> createPlayers(int aNumPlayers, String... nameHumanPlayers);
}

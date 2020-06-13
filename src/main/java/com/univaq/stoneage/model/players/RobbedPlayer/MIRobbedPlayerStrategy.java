package com.univaq.stoneage.model.players.RobbedPlayer;

import com.univaq.stoneage.model.players.MPlayer;

import java.util.List;

/**
 * Define an interface to get the robbed player name.
 */
public interface MIRobbedPlayerStrategy {
    /**
     * Get the robbed player name chosen among a list of player.
     *
     * @param players The players
     * @return The robbed player name
     */
    String getRobbedPlayerName(List<MPlayer> players);

}

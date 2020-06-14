package com.univaq.stoneage.model.players.RobbedPlayer;

import com.univaq.stoneage.model.players.MPlayer;

import java.util.List;
import java.util.Random;

/**
 * Strategy to choose randomly a robbed player.
 */
public class MRandomRobbedPlayerStrategy implements MIRobbedPlayerStrategy {
    /**
     * Get the robbed player name chosen among a list of player randomly.
     *
     * @param players The players
     * @return The robbed player name
     */
    @Override
    public String getRobbedPlayerName(List<MPlayer> players) {
        Random rand = new Random();
        return players.get(rand.nextInt(players.size())).getMarkerName();
    }
}

package com.univaq.stoneage.model.players.RobbedPlayer;

import com.univaq.stoneage.model.players.MPlayer;

import java.util.List;
import java.util.Random;

public class MRandomRobberPlayerStrategy implements MIRobbedPlayerStrategy {
    @Override
    public String getRobbedPlayerName(List<MPlayer> players) {
        Random rand = new Random();
        return players.get(rand.nextInt(players.size())).getMarkerName();
    }
}

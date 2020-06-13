package com.univaq.stoneage.model.players.playerFactory;

import com.univaq.stoneage.dao.IGenericDAO;
import com.univaq.stoneage.dao.PersistenceServiceFactory;
import com.univaq.stoneage.model.players.MEmulatedPlayer;
import com.univaq.stoneage.model.players.MHumanPlayer;
import com.univaq.stoneage.model.players.MMarker;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.playerAbilityCombining.IPlayerAbilityCombiningStrategy;
import com.univaq.stoneage.model.players.playerAbilityCombining.IPlayerAbilityCombiningStrategyFactory;
import com.univaq.stoneage.model.players.playerAbilityCombining.PlayerAbilityCombiningStrategyConcreteFactory;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.ISurpriseTokenCommand;
import com.univaq.stoneage.utility.PlayerType;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * PlayerFactory is responsible for the player creation.
 */
public class MPlayerFactory implements IPlayerFactory {

    private ArrayList<MPlayer> players;

    public ArrayList<MPlayer> createPlayers(int aNumPlayers, String... nameHumanPlayers) {
        players = new ArrayList<>();
        ArrayList<String> playersNames = this.getPlayersNamesFromDB();
        for (String name : nameHumanPlayers) {
            MPlayer p = getPlayer(PlayerType.HumanPlayer);
            p.createMarker(name);
            p.createSettlement(name);
            playersNames.remove(name);
            players.add(p);
            aNumPlayers--;
        }
        Iterator<String> it = playersNames.iterator();
        for (int i = 0; i < aNumPlayers && it.hasNext(); i++) {
            String markerName = it.next();
            MPlayer p = getPlayer(PlayerType.EmulatedPlayer);
            p.createMarker(markerName);
            p.createSettlement(markerName);
            players.add(p);
        }
        return players;
    }

    private ArrayList<String> getPlayersNamesFromDB() {
        ArrayList<String> playersNames = new ArrayList<>();
        IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MMarker.class.getSimpleName(), null);
        ArrayList<MMarker> markers = dao.findAll();
        for (MMarker marker : markers) {
            playersNames.add(marker.getM_markerName());
        }
        return playersNames;
    }

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

    public void setStartSquare(MSquare startSquare) {
        players.forEach(mPlayer -> {
            mPlayer.getM_marker().setM_square(startSquare);
        });
    }

    public ArrayList<MPlayer> getPlayers() {
        return players;
    }
}

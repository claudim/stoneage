package com.univaq.stoneage.model.players.playerFactory;

import com.univaq.stoneage.model.players.MEmulatedPlayer;
import com.univaq.stoneage.model.players.MHumanPlayer;
import com.univaq.stoneage.model.players.MMarker;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.playerAbilityCombining.IPlayerAbilityCombiningStrategy;
import com.univaq.stoneage.model.players.playerAbilityCombining.IPlayerAbilityCombiningStrategyFactory;
import com.univaq.stoneage.model.players.playerAbilityCombining.PlayerAbilityCombiningStrategyConcreteFactory;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.ISurpriseTokenCommand;
import com.univaq.stoneage.persistence.IPersistentGeneric;
import com.univaq.stoneage.persistence.PersistenceServiceFactory;
import com.univaq.stoneage.utility.PlayerType;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * PlayerFactory is responsible for the player creation.
 */
public class MPlayerFactory implements IPlayerFactory {

    /* List of players */
    private ArrayList<MPlayer> players;

    /**
     * Creates the righ number of players of the right type
     *
     * @param aNumPlayers      The number of the player to create
     * @param nameHumanPlayers The human players' name
     * @return List of players
     */
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

    /**
     * Returns players names taken from db
     *
     * @return list of names
     */
    private ArrayList<String> getPlayersNamesFromDB() {
        ArrayList<String> playersNames = new ArrayList<>();
        IPersistentGeneric dao = PersistenceServiceFactory.getInstance().getPersistenceClass(MMarker.class.getSimpleName(), null);
        ArrayList<MMarker> markers = dao.findAll();
        for (MMarker marker : markers) {
            playersNames.add(marker.getM_markerName());
        }
        return playersNames;
    }

    /**
     * Create a player of the given type
     *
     * @param aPlayerType the player type to create
     * @return a new player of the given type
     */
    public MPlayer getPlayer(PlayerType aPlayerType) {
        switch (aPlayerType) {
            case HumanPlayer:
                return new MHumanPlayer();
            default:
                return new MEmulatedPlayer();
        }
    }

    /**
     * Create a player with abilities starting from a player according to the surprise token.
     *
     * @param player  The starting player
     * @param ability The surprise token command
     * @return player with new ability
     */
    public MPlayer getPlayer(MPlayer player, ISurpriseTokenCommand ability) {
        IPlayerAbilityCombiningStrategyFactory playerAbilityCombiningStrategyFactory = new PlayerAbilityCombiningStrategyConcreteFactory();
        IPlayerAbilityCombiningStrategy combiningStrategy = playerAbilityCombiningStrategyFactory.getStrategy(player, ability);
        return combiningStrategy.combineAbilities(player, ability);
    }

    /**
     * Set starting square for every player
     *
     * @param startSquare
     */
    public void setStartSquare(MSquare startSquare) {
        players.forEach(mPlayer -> {
            mPlayer.getM_marker().setM_square(startSquare);
        });
    }

    /**
     * Get list of players
     *
     * @return list of players
     */
    public ArrayList<MPlayer> getPlayers() {
        return players;
    }
}

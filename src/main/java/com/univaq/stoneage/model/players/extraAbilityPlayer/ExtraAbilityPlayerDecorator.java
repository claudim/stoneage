package com.univaq.stoneage.model.players.extraAbilityPlayer;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;

/**
 * Hold a reference to a player with no ability and define a compliant interface to the player interface.
 */
public abstract class ExtraAbilityPlayerDecorator extends MPlayer {

    /**
     * Reference to a player with no ability.
     */
    protected MPlayer player;

    /**
     * Constructor.
     *
     * @param player Player with no ability
     */
    public ExtraAbilityPlayerDecorator(MPlayer player) {
        this.player = player;
    }

    /**
     * Get the player with no ability.
     *
     * @return The player with no ability
     */
    @Override
    public MPlayer getPlayer() {
        return player;
    }

    /**
     * Remove the ability.
     */
    public void removeAbility() {
        //int indexActivePlayer = MStoneAgeGame.getInstance().getM_nextPlayerStrategy().getIndexActivePlayer();
        //MStoneAgeGame.getInstance().getM_players().set(indexActivePlayer, player);
        MStoneAgeGame.getInstance().setActivePlayer(player);
        System.out.println("Abilità rimossa a " + player.getMarkerName());
    }

}

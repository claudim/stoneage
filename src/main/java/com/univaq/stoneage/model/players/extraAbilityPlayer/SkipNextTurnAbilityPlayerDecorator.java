package com.univaq.stoneage.model.players.extraAbilityPlayer;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;

/**
 * Define a player with the ability to skip the turn.
 */
public class SkipNextTurnAbilityPlayerDecorator extends ExtraAbilityPlayerDecorator {

    /**
     * Constructor.
     *
     * @param player The player to add the ability
     */
    public SkipNextTurnAbilityPlayerDecorator(MPlayer player) {
        super(player);
        this.m_marker = player.getM_marker();
        this.m_settlement = player.getM_settlement();
    }

    @Override
    public void playTurn() {
    }

    /**
     * Choose the robbed player name among game players.
     *
     * @return the robbed player name
     */
    @Override
    public String choosePlayerToRob() {
        return player.choosePlayerToRob();
    }

    /**
     * Execute the ability when the player is on a square.
     */
    @Override
    public void executeOnSquareAbility() {

    }

    /**
     * Execute the ability on start turn.
     */
    @Override
    public void executeOnStartTurnAbility() {
        removeAbility();
        MStoneAgeGame.getInstance().getM_gameState().skipTurn();
        System.out.println(player.getMarkerName() + " ha saltato il turno");
    }

    /**
     * Choose the hut token id to build.
     *
     * @return the hut token id
     */
    @Override
    public int chooseIdHutToken() {
        return player.chooseIdHutToken();
    }
}

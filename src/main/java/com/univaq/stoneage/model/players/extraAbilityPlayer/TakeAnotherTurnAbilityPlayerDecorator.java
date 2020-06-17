package com.univaq.stoneage.model.players.extraAbilityPlayer;

import com.univaq.stoneage.model.gameState.GameState;
import com.univaq.stoneage.model.players.MPlayer;

/**
 * Define a player with the ability to take another turn.
 */
public class TakeAnotherTurnAbilityPlayerDecorator extends ExtraAbilityPlayerDecorator {

    /**
     * Constructor.
     *
     * @param playerWithNoAbility The player to add the ability
     */
    public TakeAnotherTurnAbilityPlayerDecorator(MPlayer playerWithNoAbility) {
        super(playerWithNoAbility);
        this.m_marker = playerWithNoAbility.getM_marker();
        this.m_settlement = playerWithNoAbility.getM_settlement();
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

    }

    /**
     * Execute the ability on end turn.
     */
    @Override
    public void executeOnEndTurnAbility(GameState gameState) {
        removeAbility();
        if (isM_winner()) {
            gameState.winner();
            // visualizza vittoria
        } else {
            // next player play his turn
            gameState.takeAnotherTurn();
        }
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

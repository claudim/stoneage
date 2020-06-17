package com.univaq.stoneage.model.players.extraAbilityPlayer;

import com.univaq.stoneage.model.gameState.GameState;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.ISquareState;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory.IResourceSquareStateFactory;

/**
 * Define a player with the ability to take 2 resource when the player is on a resource square.
 */
public class Take2ResourcesAbilityPlayerDecorator extends ExtraAbilityPlayerDecorator {

    /**
     * Constructor.
     *
     * @param player The player to add the ability
     */
    public Take2ResourcesAbilityPlayerDecorator(MPlayer player) {
        super(player);
        this.m_marker = player.getM_marker();
        this.m_settlement = player.getM_settlement();
    }

    /**
     * Execute the ability when the player is on a square.
     */
    @Override
    public void executeOnSquareAbility() {
        MSquare currentSquare = player.getM_marker().getCurrentSquare();
        try {
            // cambio lo stato della square
            IResourceSquareStateFactory squareStateFactory = ((MResourceSquare) currentSquare).getM_squareStateFactory();
            ISquareState squareState = squareStateFactory.createState((MResourceSquare) currentSquare, "Take2");
            ((MResourceSquare) currentSquare).changeState(squareState);

            //rimuovo l'abilità
            removeAbility();
        } catch (Exception e) {
        }
    }

    /**
     * Execute the ability on start turn.
     */
    @Override
    public void executeOnStartTurnAbility() {
        player.executeOnStartTurnAbility();
    }

    /**
     * Execute the ability on end turn.
     */
    @Override
    public void executeOnEndTurnAbility(GameState gameState) {
    }

    /**
     * Delegate the player with no ability to perform the play turn.
     */
    @Override
    public void playTurn() {
        //execute on start turn ability
        player.playTurn();
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
     * Choose the hut token id to build.
     *
     * @return the hut token id
     */
    @Override
    public int chooseIdHutToken() {
        return player.chooseIdHutToken();
    }

}

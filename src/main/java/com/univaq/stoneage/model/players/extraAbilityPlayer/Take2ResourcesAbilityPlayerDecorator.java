package com.univaq.stoneage.model.players.extraAbilityPlayer;

import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.resourceSquare.MResourceSquare;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.ISquareState;
import com.univaq.stoneage.model.squares.resourceSquare.resourceSquareState.squareStateFactory.IResourceSquareStateFactory;

public class Take2ResourcesAbilityPlayerDecorator extends ExtraAbilityPlayerDecorator {

    public Take2ResourcesAbilityPlayerDecorator(MPlayer player) {
        super(player);
        this.m_marker = player.getM_marker();
        this.m_settlement = player.getM_settlement();
    }

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

    @Override
    public void executeOnStartTurnAbility() {
        player.executeOnStartTurnAbility();
    }

    @Override
    public void executeOnEndTurnAbility() {

    }

    @Override
    public void playTurn() {
        //execute on start turn ability
        player.playTurn();
    }

    @Override
    public void buildHut() {
        player.buildHut();
    }

    @Override
    public void stealResource() {
        player.stealResource();
    }

//    @Override
//    public void executeAbility() {
//
//    }


}

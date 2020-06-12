package com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.playerFactory.IPlayerFactory;
import com.univaq.stoneage.model.squares.ActionResult;

/**
 * It is a concreteCommand component of the COMMAND PATTERN.
 * The ConcreteCommand defines a binding between an action and a Receiver.
 * It knows to who ask to perform the action and which is the action to perform.
 * Delegate the playerFactory for the creation of the player with the ability
 * to get 2 resources from the resource square.
 */
public class TwoResourcesSupriseTokenCommand implements ISurpriseTokenCommand {
    /**
     * The command receiver
     */
    private final IPlayerFactory playerFactory;

    /**
     * Constructor.
     *
     * @param playerFactory The receiver
     */
    public TwoResourcesSupriseTokenCommand(IPlayerFactory playerFactory) {
        this.playerFactory = playerFactory;
    }

    /**
     * Execute the command.
     * Delegate the playerFactory for the creation of the player with the ability to get 2 resources from the resource square.
     *
     * @return The action result
     */
    @Override
    public ActionResult execute() {
        MPlayer player = MStoneAgeGame.getInstance().getActivePlayer();
        //IPlayerFactory playerFactory = new MPlayerFactory();
        MPlayer playerWithAbility = playerFactory.getPlayer(player, this);
        MStoneAgeGame.getInstance().setActivePlayer(playerWithAbility);
        System.out.println(player.getMarkerName() + " ha preso l'abilità : + 2 risorse nel prox turno");
        return ActionResult.ACTION_DONE;
    }
}

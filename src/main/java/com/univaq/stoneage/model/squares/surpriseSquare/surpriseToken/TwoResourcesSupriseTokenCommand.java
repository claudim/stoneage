package com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.playerFactory.IPlayerFactory;
import com.univaq.stoneage.model.players.playerFactory.MPlayerFactory;
import com.univaq.stoneage.model.squares.ActionResult;

/**
 * It is a concreteCommand component of the COMMAND PATTERN.
 * It knows to who tell to perform the action and which is the action.
 */
public class TwoResourcesSupriseTokenCommand implements ISurpriseTokenCommand {
    private MPlayer player;

    /**
     * Constructor.
     *
     * @param player The receiver
     */
    public TwoResourcesSupriseTokenCommand(MPlayer player) {
        this.player = player;
    }

    /**
     * Execute the command.
     * Delegate the playerFactory for the creation of the player with the ability to get 2 resources from the resource square.
     *
     * @return The action result
     */
    @Override
    public ActionResult execute() {
        player = MStoneAgeGame.getInstance().getActivePlayer();
        IPlayerFactory playerFactory = new MPlayerFactory();
        MPlayer playerWithAbility = playerFactory.getPlayer(this.player, this);
        MStoneAgeGame.getInstance().setActivePlayer(playerWithAbility);
        System.out.println(player.getMarkerName() + " ha preso l'abilità : + 2 risorse nel prox turno");
        return ActionResult.ACTION_DONE;
    }
}

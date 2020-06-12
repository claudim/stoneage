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
 * to take another turn.
 */
public class TakeAnotherTurnSurpriseTokenCommand implements ISurpriseTokenCommand {
    /**
     * The command receiver
     */
    private final IPlayerFactory playerFactory;

    /**
     * Constructor.
     *
     * @param playerFactory The receiver
     */
    public TakeAnotherTurnSurpriseTokenCommand(IPlayerFactory playerFactory) {
        this.playerFactory = playerFactory;
    }

    /**
     * Execute the command.
     * Delegate the playerFactory for the creation of the player with the ability to take another turn.
     *
     * @return The action result
     */
    @Override
    public ActionResult execute() {
        MPlayer player = MStoneAgeGame.getInstance().getActivePlayer();
        MPlayer playerWithAbility = playerFactory.getPlayer(player, this);
        MStoneAgeGame.getInstance().setActivePlayer(playerWithAbility);
        System.out.println(player.getMarkerName() + " ha preso l'abilità : esegui un altro turno");
        return ActionResult.ACTION_DONE;
    }
}

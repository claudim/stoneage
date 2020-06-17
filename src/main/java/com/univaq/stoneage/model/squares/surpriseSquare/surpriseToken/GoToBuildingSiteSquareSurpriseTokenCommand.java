package com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.forestTokens.grid.MGrid;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.ActionResult;
import com.univaq.stoneage.model.squares.MSquare;

/**
 * It is a concreteCommand component of the COMMAND PATTERN.
 * The ConcreteCommand defines a binding between an action and a Receiver.
 * It knows to who ask to perform the action and which is the action to perform.
 * Delegate the player to land its marker on the building site square.
 */

public class GoToBuildingSiteSquareSurpriseTokenCommand implements ISurpriseTokenCommand {
    private static final String squareName = "Cantiere";
    /**
     * The command receiver
     */
    private MPlayer player;

    /**
     * Constructor.
     *
     * @param player The receiver
     */
    public GoToBuildingSiteSquareSurpriseTokenCommand(MPlayer player) {
        this.player = player;
    }

    /**
     * Execute the command.
     * Delegate the player to land its marker on the building site square.
     *
     * @return The action result
     */
    @Override
    public ActionResult execute() {
        // trovare l'id del cantiere
        player = MStoneAgeGame.getInstance().getActivePlayer();
        MGrid grid = MStoneAgeGame.getInstance().getM_grid();
        MTokenForest tokenForest = grid.searchTFbyValue(squareName);
        MSquare newSquare = player.moveMarker(tokenForest);
        System.out.println(player.getMarkerName() + " è ora in Building Site Square");
        return newSquare.doAction(player);
    }
}

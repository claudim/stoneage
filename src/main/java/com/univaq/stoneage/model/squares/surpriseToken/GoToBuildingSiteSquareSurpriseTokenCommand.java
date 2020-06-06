package com.univaq.stoneage.model.squares.surpriseToken;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.forestTokens.MGrid;
import com.univaq.stoneage.model.forestTokens.MTokenForest;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.ActionResult;
import com.univaq.stoneage.model.squares.MSquare;

public class GoToBuildingSiteSquareSurpriseTokenCommand implements ISurpriseTokenCommand {
    private final String squareName = "Cantiere";
    private MPlayer player;


    public GoToBuildingSiteSquareSurpriseTokenCommand(MPlayer player) {
        this.player = player;
    }

    @Override
    public void setReceiver(Object receiver) {
        player = (MPlayer) receiver;
    }

    @Override
    public ActionResult execute() {
        // trovare l'id del cantiere
        MGrid grid = MStoneAgeGame.getInstance().getM_grid();
        MTokenForest tokenForest = grid.searchTFbyValue(squareName);
        //int idForestToken = tokenForest.getIdToken();
        MSquare newSquare = player.moveMarker(tokenForest);
        System.out.println(player.getMarkerName() + " è ora in Building Site Square");
        return newSquare.doAction(player);
//
//        // stato del gioco in waitingForTokenForest e spostamento del marker nella nuova casella
//        GameState gameState = MStoneAgeGame.getInstance().getGameState();
//        gameState.waitForTokenForest();
//        gameState.playTurn(idForestToken);

    }
}

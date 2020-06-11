package com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.playerFactory.IPlayerFactory;
import com.univaq.stoneage.model.players.playerFactory.MPlayerFactory;
import com.univaq.stoneage.model.squares.ActionResult;

public class TakeAnotherTurnSurpriseTokenCommand implements ISurpriseTokenCommand {
    private MPlayer player;

    public TakeAnotherTurnSurpriseTokenCommand(MPlayer player) {
        this.player = player;
    }

    @Override
    public ActionResult execute() {
//        ArrayList<MPlayer> players = MStoneAgeGame.getInstance().getM_players();
//        int indexActivePlayer = MStoneAgeGame.getInstance().getM_nextPlayerStrategy().getIndexActivePlayer();
//        player = players.get(indexActivePlayer);
        player = MStoneAgeGame.getInstance().getActivePlayer();
        IPlayerFactory playerFactory = new MPlayerFactory();
        MPlayer playerWithAbility = playerFactory.getPlayer(this.player, this);
        //players.set(indexActivePlayer, playerWithAbility);
        MStoneAgeGame.getInstance().setActivePlayer(playerWithAbility);
        System.out.println(player.getMarkerName() + " ha preso l'abilità : esegui un altro turno");
        return ActionResult.ACTION_DONE;
    }
}

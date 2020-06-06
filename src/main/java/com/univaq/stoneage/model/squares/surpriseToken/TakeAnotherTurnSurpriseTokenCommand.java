package com.univaq.stoneage.model.squares.surpriseToken;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.IPlayerFactory;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.MPlayerFactory;
import com.univaq.stoneage.model.squares.ActionResult;

public class TakeAnotherTurnSurpriseTokenCommand implements ISurpriseTokenCommand {
    private MPlayer player;

    public TakeAnotherTurnSurpriseTokenCommand(MPlayer player) {
        this.player = player;
    }

    @Override
    public void setReceiver(Object receiver) {
        player = (MPlayer) receiver;
    }

    @Override
    public ActionResult execute() {
        IPlayerFactory playerFactory = new MPlayerFactory();
        MPlayer playerWithAbility = playerFactory.getPlayer(this.player, this);
        int indexActivePlayer = MStoneAgeGame.getInstance().getM_nextPlayerStrategy().getIndexActivePlayer();
        MStoneAgeGame.getInstance().getM_players().set(indexActivePlayer, playerWithAbility);
        System.out.println(player.getMarkerName() + " ha preso l'abilità : esegui un altro turno");
        return ActionResult.ACTION_DONE;
    }
}

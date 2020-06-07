package com.univaq.stoneage.model.squares.surpriseToken;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.IPlayerFactory;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.MPlayerFactory;
import com.univaq.stoneage.model.squares.ActionResult;

import java.util.ArrayList;

public class TwoResourcesSupriseTokenCommand implements ISurpriseTokenCommand {
    private MPlayer player;

    public TwoResourcesSupriseTokenCommand(MPlayer player) {
        this.player = player;
    }


    @Override
    public ActionResult execute() {
        // cambia abilità al player
//        player = new Take2ResourcesAbilityPlayerDecorator(player);
//        int indexActivePlayer = MStoneAgeGame.getInstance().getM_nextPlayerStrategy().getIndexActivePlayer();
//        MStoneAgeGame.getInstance().getM_players().set(indexActivePlayer, player);

//        Take2ResourcesAbilityPlayerDecorator take2ResourcesAbilityPlayerDecorator = new Take2ResourcesAbilityPlayerDecorator(player.getPlayer());
//        player.addAbility(take2ResourcesAbilityPlayerDecorator);


        ArrayList<MPlayer> players = MStoneAgeGame.getInstance().getM_players();
        int indexActivePlayer = MStoneAgeGame.getInstance().getM_nextPlayerStrategy().getIndexActivePlayer();
        player = players.get(indexActivePlayer);
        IPlayerFactory playerFactory = new MPlayerFactory();
        MPlayer playerWithAbility = playerFactory.getPlayer(this.player, this);
        players.set(indexActivePlayer, playerWithAbility);
        System.out.println(player.getMarkerName() + " ha preso l'abilità : + 2 risorse nel prox turno");
        return ActionResult.ACTION_DONE;
    }
}

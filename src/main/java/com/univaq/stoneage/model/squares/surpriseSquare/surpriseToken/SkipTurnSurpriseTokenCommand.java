package com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.playerFactory.IPlayerFactory;
import com.univaq.stoneage.model.players.playerFactory.MPlayerFactory;
import com.univaq.stoneage.model.squares.ActionResult;

public class SkipTurnSurpriseTokenCommand implements ISurpriseTokenCommand {
    private MPlayer player;

    public SkipTurnSurpriseTokenCommand(MPlayer player) {
        this.player = player;
    }

    @Override
    public ActionResult execute() {

//        SkipNextTurnAbilityPlayerDecorator skipNextTurnAbilityPlayerDecorator = new SkipNextTurnAbilityPlayerDecorator(player.getPlayer());
//        player.addAbility(skipNextTurnAbilityPlayerDecorator);

//        ArrayList<MPlayer> players = MStoneAgeGame.getInstance().getM_players();
//        int indexActivePlayer = MStoneAgeGame.getInstance().getM_nextPlayerStrategy().getIndexActivePlayer();
        //player = players.get(indexActivePlayer);
        player = MStoneAgeGame.getInstance().getActivePlayer();
        IPlayerFactory playerFactory = new MPlayerFactory();
        MPlayer playerWithAbility = playerFactory.getPlayer(this.player, this);
        MStoneAgeGame.getInstance().setActivePlayer(playerWithAbility);
        //players.set(indexActivePlayer, playerWithAbility);
        System.out.println(player.getMarkerName() + " ha preso l'abilità : salta turno");
        return ActionResult.ACTION_DONE;
    }
}

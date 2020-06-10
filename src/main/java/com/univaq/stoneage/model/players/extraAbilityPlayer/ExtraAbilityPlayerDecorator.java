package com.univaq.stoneage.model.players.extraAbilityPlayer;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;

public abstract class ExtraAbilityPlayerDecorator extends MPlayer {

    protected MPlayer player;

    public ExtraAbilityPlayerDecorator(MPlayer player) {
        this.player = player;
    }

    @Override
    public MPlayer getPlayer() {
        return player;
    }

    public void removeAbility() {
        int indexActivePlayer = MStoneAgeGame.getInstance().getM_nextPlayerStrategy().getIndexActivePlayer();
        MStoneAgeGame.getInstance().getM_players().set(indexActivePlayer, player);
        System.out.println("Abilità rimossa a " + player.getMarkerName());

    }

}

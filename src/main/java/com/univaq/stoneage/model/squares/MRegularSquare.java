package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.players.MPlayer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "regularsquare")
public class MRegularSquare extends MSquare {
    @Override
    public void doAction(MPlayer mPlayer) {

    }

    @Override
    public String getSquareType() {
        return this.getClass().getSimpleName();
    }


}

package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.players.MPlayer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.beans.PropertyChangeEvent;

@Entity
@DiscriminatorValue(value = "regularsquare")
public class MRegularSquare extends MSquare {
    @Override
    public void doAction(MPlayer mPlayer) {
        MStoneAgeGame.getInstance().getGameState().nextTurn();
    }

    @Override
    public String getSquareType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.players.MPlayer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.beans.PropertyChangeEvent;

import static com.univaq.stoneage.model.squares.ActionResult.ACTION_DONE;

@Entity
@DiscriminatorValue(value = "regularsquare")
public class MRegularSquare extends MSquare {
    @Override
    public ActionResult doAction(MPlayer mPlayer) {
        // MStoneAgeGame.getInstance().getGameState().nextTurn();
        return ACTION_DONE;
    }

    @Override
    public String getSquareType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

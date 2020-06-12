package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.gameMode.GameMode;
import com.univaq.stoneage.model.players.MPlayer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.beans.PropertyChangeEvent;

import static com.univaq.stoneage.model.squares.ActionResult.ACTION_DONE;


@Entity
@DiscriminatorValue(value = "regularsquare")
public class MRegularSquare extends MSquare {

    /**
     * Action to perform if the marker's player lands on it.
     *
     * @param mPlayer The player who lands on the square
     * @return The action result
     */
    @Override
    public ActionResult doAction(MPlayer mPlayer) {
        return ACTION_DONE;
    }

    /**
     * Initial square setup.
     *
     * @param mode The game mode
     */
    @Override
    public void setupSquare(GameMode mode) {
    }

    /**
     * Get the square type.
     *
     * @return the square type
     */
    @Override
    public String getSquareType() {
        return this.getClass().getSimpleName();
    }

    /**
     * How to manage a notify from the observable.
     *
     * @param evt The notify
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}

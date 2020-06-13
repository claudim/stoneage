package com.univaq.stoneage.model.squares.surpriseSquare;

import com.univaq.stoneage.model.gameMode.GameMode;
import com.univaq.stoneage.model.nextId.GetRandomIdStrategy;
import com.univaq.stoneage.model.nextId.IGetNextIdStrategy;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.playerFactory.IPlayerFactory;
import com.univaq.stoneage.model.players.playerFactory.MPlayerFactory;
import com.univaq.stoneage.model.squares.ActionResult;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collections;

/**
 * It is responsible for the creation of all the Surprise Tokens.
 * It knows the action to perform if the marker lands on it and how to setup the square.
 * It knows its type.
 */
@Entity
@DiscriminatorValue(value = "surprisesquare")
public class MSurpriseSquare extends MSquare {

    /**
     * All the surprise tokens.
     */
    @Transient
    private ArrayList<ISurpriseTokenCommand> m_supriseTokens;

    /**
     * Initial square setup.
     * Create all the surprise tokens and set the receiver.
     *
     * @param mode The game mode
     */
    public void setupSquare(GameMode mode) {
        // super.support = new PropertyChangeSupport(this); // to implement the observer pattern
        IPlayerFactory playerFactory = new MPlayerFactory();
        m_supriseTokens = new ArrayList<>();

        m_supriseTokens.add(new TakeAnotherTurnSurpriseTokenCommand(playerFactory));
        m_supriseTokens.add(new GoToBuildingSiteSquareSurpriseTokenCommand(null));
        m_supriseTokens.add(new TwoResourcesSupriseTokenCommand(playerFactory));
        m_supriseTokens.add(new SkipTurnSurpriseTokenCommand(playerFactory));

    }

    /**
     * Action to perform if the marker's player lands on it.
     * Pic a surprise token and execute it.
     *
     * @param mPlayer The player who lands on the square
     * @return The action result
     */
    @Override
    public ActionResult doAction(MPlayer mPlayer) {

        // scegli una sorpresa
        IGetNextIdStrategy getNextIdStrategy = new GetRandomIdStrategy(); // todo meglio una factory??
        int nextId = getNextIdStrategy.getNextId(Collections.singletonList(m_supriseTokens));

        ISurpriseTokenCommand supriseToken = m_supriseTokens.get(nextId);
        return supriseToken.execute();
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
